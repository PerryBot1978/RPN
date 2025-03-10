package com.dtb.rpn.function.builtins

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.StringVariable
import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable

class AssignmentFunction : Function {
	override fun numArgs(): Int = 2

	override fun parameters(): Array<Array<Type>> {
		return arrayOf(
			arrayOf(Type.types["Decimal"]!!,  Type.types["Decimal"]!!),
			arrayOf(Type.types["String"]!!,   Type.types["String"]!!),
			arrayOf(Type.types["Function"]!!, Type.types["Function"]!!),
			arrayOf(Type.types["Type"]!!,     Type.types["Type"]!!),

			arrayOf(Type.types["String"]!!,   Type.types["Decimal"]!!),
			arrayOf(Type.types["String"]!!,   Type.types["Function"]!!),
			arrayOf(Type.types["String"]!!,   Type.types["Type"]!!),
		)
	}

	override fun invoke(vararg args: Variable): Variable {
//		println("${args[0]} = ${args[1]}")
//		Main.assert(args[0] is PlaceholderVariable)
		Variable.assign(args[0].findName() ?: (args[0] as StringVariable).str, args[1])
		if (args[0] is Type && args[1] is Type)
			(Variable.names["typealias"] as Function)(args[0], args[1])

		return args[1]
	}
}