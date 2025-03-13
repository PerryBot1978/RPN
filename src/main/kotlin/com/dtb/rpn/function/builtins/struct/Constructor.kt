package com.dtb.rpn.function.builtins.struct

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable

class Constructor(private val struct: StructType, private val order: List<String>) : Function {
	override fun numArgs(): Int = struct.fields.size
	override fun parameters(): Array<Array<Type>> = arrayOf(struct.fields.map { it.value }.toTypedArray())

	override fun invoke(vararg args: Variable): Variable {
		val out = HashMap<String, Variable>()
		for (i in args.indices)
			out[order[i]] = args[i]
		return StructInstance(struct, out)
	}
}