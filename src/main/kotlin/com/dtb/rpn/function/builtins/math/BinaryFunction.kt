package com.dtb.rpn.function.builtins.math

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.Type

interface BinaryFunction : Function {
	override fun numArgs(): Int = 2

	override fun parameters(): Array<Array<Type>> {
		return arrayOf(
			arrayOf(Type.types["Decimal"]!!, Type.types["Decimal"]!!)
		)
	}
}