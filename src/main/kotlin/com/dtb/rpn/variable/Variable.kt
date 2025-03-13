package com.dtb.rpn.variable

import com.dtb.rpn.function.builtins.io.PrintFunction
import com.dtb.rpn.function.builtins.io.PrintVarsFunction
import com.dtb.rpn.function.builtins.io.ReadFileFunction
import com.dtb.rpn.function.builtins.io.SilentFunction
import com.dtb.rpn.function.builtins.math.*
import com.dtb.rpn.function.builtins.variable.AssignmentFunction
import com.dtb.rpn.function.builtins.variable.DefineVariableFunction
import com.dtb.rpn.function.builtins.variable.PlaceholderVariable

interface Variable {
	fun stringify(): String
	fun type(): Type

	fun findName(): String? {
		return try {
			val out = names
				.entries
				.filter { it.value == this }
				.first ?: return null
			out.key
		} catch (e: NoSuchElementException) {
			null
		}
	}
	fun findType(): String? {
		val out = Type.types
			.map { Pair(it.key, it.value.type()) }
			.filter { it.second == this.type() }
			.first ?: return null
		return out.first
	}

	companion object {
		val names = HashMap<String, Variable>()

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
			names["read_file"] = ReadFileFunction()

			names["print"]      = PrintFunction()
			names["println"]    = PrintFunction("\n")
			names["print_vars"] = PrintVarsFunction()
			names["silent"]     = SilentFunction()
		}
	}
}