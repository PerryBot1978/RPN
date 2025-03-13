package com.dtb.rpn.variable

open class Type(private val name: String) : Variable {
	companion object {
		val types = HashMap<String, Type>()

		init {
			types["Decimal"]  = Type("Decimal")
			types["String"]   = Type("String")
			types["Function"] = Type("Function")
			types["Type"]     = Type("Type")
			types["None"]     = Type("None")
		}
	}


	override fun type(): Type = types["Type"]!!
	override fun toString(): String = "Type($name)"
	override fun stringify(): String = name

	override fun equals(other: Any?): Boolean = other is Type && this.name == other.name
	override fun hashCode(): Int = name.hashCode()
}