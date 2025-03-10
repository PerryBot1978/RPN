package com.dtb.rpn.variable

class Type(private val type: Class<*>) : Variable {
	override fun stringify(): String = "TypeVariable(${type.name})"
	override fun type(): Class<*> = type

	override fun toString(): String = "Type(${type.simpleName})"
}