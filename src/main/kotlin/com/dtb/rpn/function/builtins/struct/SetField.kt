package com.dtb.rpn.function.builtins.struct

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable

class SetField(val struct: StructType, val field_name: String, val type: Type) : Function {
	override fun numArgs(): Int = 2
	override fun parameters(): Array<Array<Type>> = arrayOf(arrayOf(struct.type(), type))

	override fun invoke(vararg args: Variable): Variable {
		(args[0] as StructInstance).values[field_name] = args[1]
		return args[1]
	}
}