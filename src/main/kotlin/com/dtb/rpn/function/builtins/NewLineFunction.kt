package com.dtb.rpn.function.builtins

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.Variable

class NewLineFunction : Function {
	override fun numArgs(): Int = 0

	override fun parameters(): Array<Array<Class<*>>> = arrayOf()

	override fun invoke(vararg args: Variable): Variable? {
		return null
	}
}