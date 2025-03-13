package com.dtb.rpn.function.builtins.variable

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.StringVariable
import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable

class DefineVariableFunction : Function {
	override fun numArgs(): Int = 2

	override fun parameters(): Array<Array<Type>> {
		return arrayOf(
			arrayOf(Type.types["String"]!!, Type.types["Type"]!!)
		)
	}

	override fun invoke(vararg args: Variable): Variable {
		assert(args[1] is Type)

		val name = if (args[0] is StringVariable) {
			(args[0] as StringVariable).str
		} else {
			args[0].findName()!!
		}

//		println(args.contentToString())
		Variable.assign(name, PlaceholderVariable(name, args[1] as Type))
		return args[1]
	}
}