package com.dtb.rpn.function.builtins

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.StringVariable
import com.dtb.rpn.variable.Variable

class AssignmentFunction : Function {
	override fun numArgs(): Int = 2

	override fun parameters(): Array<Array<Class<*>>> {
		return arrayOf(
			arrayOf(StringVariable::class.java, Variable::class.java)
		)
	}

	override fun invoke(vararg args: Variable): Variable {
		assert(args[0] is StringVariable)
//		println("${args[0].stringify()} = ${args[1]}")

		Variable.names[(args[0] as StringVariable).str] = args[1]
		return args[1]
	}
}