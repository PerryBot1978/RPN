package com.dtb.rpn.function.builtins.function

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable

class CustomFunctionGenerator(private val parameterCount: Int) : Function {
	override fun numArgs(): Int = parameterCount * 2 + 1

	override fun parameters(): Array<Array<Type>> {
		return arrayOf(
			Array(parameterCount * 2 + 1) {
				if (it == 0)
					Type.types["String"]!!
				else if (it % 2 == 1)
					Type.types["String"]!!
				else
					Type.types["Type"]!!
			}
		)
	}

	override fun invoke(vararg args: Variable): Variable {
//		println("[ARGS] ${args.contentToString()}")

		val arguments = args.toMutableList()
		val code = arguments.removeAt(0).stringify()

		val parameters = Array<Pair<String, Type>?>(parameterCount) {
			val pair = Pair(args[2 * it + 1].stringify(), args[2 * it + 2] as Type)
//			println("[PAIR] $pair")
			pair
		}.filterNotNull().toTypedArray()
		return CustomFunction(code, parameters)
	}
}