package com.dtb.rpn.variable

class NoneVariable : Variable {
	override fun stringify(): String = "none"
	override fun type(): Type = Type.types["None"]!!

	override fun toString(): String = "None"
}