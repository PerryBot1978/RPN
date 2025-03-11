package com.dtb.rpn.variable

import com.dtb.rpn.function.builtins.function.CustomFunction

class Type(private val type: Class<*>) : Variable {
	companion object {
		val types = HashMap<String, Type>()

		init {
			types["Decimal"]  = Type(DecimalVariable::class.java)
			types["String"]   = Type(StringVariable ::class.java)
			types["Function"] = Type(CustomFunction ::class.java)
			types["Type"]     = Type(Type           ::class.java)
			types["None"]     = Type(NoneVariable   ::class.java)
		}
	}

	override fun stringify(): String = "TypeVariable(${type.name})"

	override fun type(): Type = types["Type"]!!
	override fun toString(): String = "Type(${type.simpleName})"

	override fun equals(other: Any?): Boolean = other is Type && this.type == other.type
	override fun hashCode(): Int = type.hashCode()
}