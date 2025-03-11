package com.dtb.rpn.function.builtins.variable

import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable

class PlaceholderVariable(val _name: String, val type: Type) : Variable {
	override fun type(): Type = type
	override fun stringify(): String = _name

	override fun findName(): String = _name
	override fun toString(): String = "PlaceholderVariable($_name, $type)"
}