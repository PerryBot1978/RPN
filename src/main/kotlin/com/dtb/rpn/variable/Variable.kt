package com.dtb.rpn.variable

import com.dtb.rpn.function.builtins.*
import com.dtb.rpn.function.builtins.math.*

interface Variable {
	fun stringify(): String
	fun type(): Class<*> { return this.javaClass }
	fun findName(): String? {
		val out = names
			.entries
			.filter { it.value == this }
			.first ?: return null
		return out.key
	}

	companion object {
		val names = HashMap<String, Variable>()
		val types = HashMap<String, Type>()

		fun assign(name: String, variable: Variable) {
//			println("Variables.assign($name, $variable) : Old = ${names[name]}")

			if (names.contains(name) && names[name]!!.type() != variable.type())
				throw IllegalArgumentException("Incompatible types ${names[name]!!.type()} and ${variable.type()}")
			if (!names.contains(name) && variable !is PlaceholderVariable)
				throw IllegalArgumentException("Undefined variable $name")
			names[name] = variable
		}

		init {
			names["+"] = PlusFunction()
			names["-"] = MinusFunction()
			names["*"] = MultiplyFunction()
			names["/"] = DivFunction()
			names["^"] = PowFunction()

			names["="] = AssignmentFunction()
			names["def"] = DefineVariableFunction()
			names["newline"] = NewLineFunction()
		}

		init {
			types["decimal"]  = Type(DecimalVariable::class.java)
			types["string"]   = Type(StringVariable ::class.java)
			types["function"] = Type(CustomFunction ::class.java)
			types["type"]     = Type(Type           ::class.java)
		}
	}
}