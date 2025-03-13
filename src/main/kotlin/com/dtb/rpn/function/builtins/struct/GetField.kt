package com.dtb.rpn.function.builtins.struct

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable

class GetField(val struct: StructType, val field_name: String) : Function {
	override fun numArgs(): Int = 1
	override fun parameters(): Array<Array<Type>> = arrayOf(arrayOf(struct.type()))

	override fun invoke(vararg args: Variable): Variable = (args[0] as StructInstance).values[field_name]!!
}