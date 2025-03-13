package com.dtb.rpn.function.builtins.struct

import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable

class StructInstance(val type: StructType, val values: HashMap<String, Variable>): Variable {
	override fun stringify(): String = values.entries.toString()
	override fun type(): Type = type

	override fun toString(): String = "${type.name}(${values.toString().trim('{', '}')})"
}