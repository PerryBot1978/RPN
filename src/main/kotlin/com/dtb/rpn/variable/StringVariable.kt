package com.dtb.rpn.variable

class StringVariable(val str: String) : Variable {
	operator fun plus(other: Variable): StringVariable = StringVariable(this.str + other)

	override fun toString(): String {
		return "StringVariable($str)"
	}
}