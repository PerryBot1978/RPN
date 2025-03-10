package com.dtb.rpn.variable

class StringVariable(val str: String) : Variable {
	operator fun plus(other: Variable): StringVariable = StringVariable(this.stringify() + other.stringify())

	override fun stringify(): String = str
	override fun toString():  String = "StringVariable($str)"
}