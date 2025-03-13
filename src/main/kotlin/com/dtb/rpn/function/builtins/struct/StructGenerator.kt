package com.dtb.rpn.function.builtins.struct

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable

class StructGenerator(private val fields: Int) : Function {
	override fun numArgs(): Int = 2 * fields + 1

	override fun parameters(): Array<Array<Type>> {
		return arrayOf(
			Array(this.numArgs()) {
				Type.types["String"]!!
			}
		)
	}

	override fun invoke(vararg args: Variable): Variable {
		val name = args.last().stringify()
		val fields = HashMap<String, Type>()
		val order = ArrayList<String>()

		lateinit var field_name: String
		for (i in 0..<args.size-1) {
			if (i % 2 == 0) {
				field_name = args[i].stringify()
				order.add(field_name)
			} else {
				val type_name = args[i].stringify()
//				println("Types: ${Type.types}")
//				println("Type Name: $type_name")
				fields[field_name] = Type.types[type_name]!!
			}
		}

		Type.types[name] = StructType(name, fields, order)
		return Type.types[name]!!
	}
}