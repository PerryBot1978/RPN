package com.dtb.rpn.function.builtins

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable

class RunReturnFunction : Function {
	override fun numArgs(): Int = 2
	override fun parameters(): Array<Array<Type>> = arrayOf(arrayOf(Type.types["Any"]!!, Type.types["Any"]!!))
	override fun invoke(vararg args: Variable): Variable = args[1]
}