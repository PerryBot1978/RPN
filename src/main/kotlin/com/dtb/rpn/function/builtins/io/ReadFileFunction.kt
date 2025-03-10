package com.dtb.rpn.function.builtins.io

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.StringVariable
import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable
import java.io.File

class ReadFileFunction : Function {
	override fun numArgs(): Int = 1

	override fun parameters(): Array<Array<Type>> {
		return arrayOf(arrayOf(Type.types["String"]!!))
	}

	override fun invoke(vararg args: Variable): Variable {
		return StringVariable(
			File(args[0].stringify())
				.readText()
		)
	}
}