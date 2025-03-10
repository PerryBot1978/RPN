package com.dtb.rpn.function.builtins.math

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.*

class PlusFunction : BinaryFunction {
	override fun parameters(): Array<Array<Type>> {
		return arrayOf(
			arrayOf(Type.types["Decimal"]!!, Type.types["Decimal"]!!),
			arrayOf(Type.types["String"]!!,  Type.types["Decimal"]!!),
			arrayOf(Type.types["String"]!!,  Type.types["String"]!!),
		)
	}

	override fun invoke(vararg args: Variable): Variable {
//		println("${args[0]} + ${args[1]}")

		if (args[0] is DecimalVariable && args[1] is DecimalVariable)
			return args[0] as DecimalVariable + args[1] as DecimalVariable
		if (args[0] is StringVariable)
			return args[0] as StringVariable + args[1]
		return NoneVariable()
	}
}