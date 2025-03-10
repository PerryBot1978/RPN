package com.dtb.rpn.function.builtins.io

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.NoneVariable
import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable

class SilentFunction : Function {
	override fun numArgs(): Int = 1
	override fun parameters(): Array<Array<Type>> {
		return arrayOf(
			arrayOf(Type.types["Function"]!!),
			arrayOf(Type.types["String"]!!),
			arrayOf(Type.types["Decimal"]!!),
			arrayOf(Type.types["Type"]!!)
		)
	}

	override fun invoke(vararg args: Variable): Variable {
		return NoneVariable()
	}
}