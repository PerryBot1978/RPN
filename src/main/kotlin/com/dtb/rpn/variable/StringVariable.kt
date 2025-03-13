package com.dtb.rpn.variable

class StringVariable(val str: String) : Variable {
	operator fun plus(other: Variable): StringVariable = StringVariable(this.stringify() + other.stringify())

	override fun type(): Type = Type.types["String"]!!
	override fun stringify(): String = str
	override fun toString():  String = "String($str)"
}