package com.dtb.rpn.function.builtins.math

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.DecimalVariable
import com.dtb.rpn.variable.Variable

class DivFunction : Function {
	override fun numArgs(): Int = 2

	override fun parameters(): Array<Array<Class<*>>> {
		return arrayOf(
			arrayOf(DecimalVariable::class.java, DecimalVariable::class.java)
		)
	}

	override fun invoke(vararg args: Variable): Variable? {
		if (args[0] is DecimalVariable && args[1] is DecimalVariable)
			return args[0] as DecimalVariable / args[1] as DecimalVariable
		return null
	}
}