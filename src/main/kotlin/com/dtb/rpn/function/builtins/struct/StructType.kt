package com.dtb.rpn.function.builtins.struct

import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable

class StructType(val name: String, val fields: HashMap<String, Type>, order: List<String>) : Type(name) {
	init {
		Variable.names["new_${name}"] = Constructor(this, order)
		fields.entries.forEach {
			Variable.names["get_${name}_${it.key}"] = GetField(this, it.key)
			Variable.names["set_${name}_${it.key}"] = SetField(this, it.key, it.value)
		}
	}

	override fun toString(): String {
		return "$name(${fields.toString().trim('{', '}')})"
	}
}