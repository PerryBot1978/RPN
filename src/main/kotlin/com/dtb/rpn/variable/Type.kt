package com.dtb.rpn.variable

import com.dtb.rpn.variable.Variable

class Type(private val type: Class<*>) : Variable {
	override fun stringify(): String = "TypeVariable(${type.name})"
	override fun type(): Class<*> = type

	override fun toString(): String = "Type(${type.simpleName})"
}