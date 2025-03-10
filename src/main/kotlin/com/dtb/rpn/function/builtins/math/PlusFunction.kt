package com.dtb.rpn.function.builtins.math

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.DecimalVariable
import com.dtb.rpn.variable.StringVariable
import com.dtb.rpn.variable.Variable

class PlusFunction : Function {
	override fun numArgs(): Int = 2

	override fun parameters(): Array<Array<Class<*>>> {
		return arrayOf(
			arrayOf(DecimalVariable::class.java, DecimalVariable::class.java),
			arrayOf(StringVariable::class.java, Variable::class.java)
		)
	}

	override fun invoke(vararg args: Variable): Variable? {
//		println("${args[0]} + ${args[1]}")

		if (args[0] is DecimalVariable && args[1] is DecimalVariable)
			return args[0] as DecimalVariable + args[1] as DecimalVariable
		if (args[0] is StringVariable)
			return args[0] as StringVariable + args[1]
		return null
	}
}