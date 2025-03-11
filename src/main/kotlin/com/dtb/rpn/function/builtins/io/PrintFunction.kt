package com.dtb.rpn.function.builtins.io

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable

class PrintFunction(private val suffix: String = "") : Function {
	override fun numArgs(): Int = 1

	override fun parameters(): Array<Array<Type>> {
		return arrayOf(
			arrayOf(Type.types["String"]!!),
			arrayOf(Type.types["Decimal"]!!),
		)
	}

	override fun invoke(vararg args: Variable): Variable {
		print(args[0].stringify() + suffix)
		System.out.flush()
		return args[0]
	}
}