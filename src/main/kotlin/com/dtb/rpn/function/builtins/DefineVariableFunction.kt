package com.dtb.rpn.function.builtins

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.StringVariable
import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable

class DefineVariableFunction : Function {
	override fun numArgs(): Int = 2

	override fun parameters(): Array<Array<Class<*>>> {
		return arrayOf(
			arrayOf(Variable::class.java, Type::class.java)
		)
	}

	override fun invoke(vararg args: Variable): Variable? {
		assert(args[1] is Type)

		val name = if (args[0] is StringVariable) {
			(args[0] as StringVariable).str
		} else {
			args[0].findName()!!
		}

		Variable.assign(name, PlaceholderVariable(name, args[1] as Type))
		return args[1]
	}
}