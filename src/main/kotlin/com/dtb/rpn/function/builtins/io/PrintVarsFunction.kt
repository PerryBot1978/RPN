package com.dtb.rpn.function.builtins.io

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.NoneVariable
import com.dtb.rpn.variable.StringVariable
import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable

class PrintVarsFunction : Function {
	override fun numArgs(): Int = 0

	override fun parameters(): Array<Array<Type>> = arrayOf()

	override fun invoke(vararg args: Variable): Variable {
		return StringVariable("[VARS] ${Variable.names}")
	}
}