package com.dtb.rpn.function.builtins.function

import com.dtb.rpn.Runner
import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable
import kotlin.collections.HashMap

class CustomFunction(private val code: String, private val parameters: Array<Pair<String, Type>>) : Function {
	override fun numArgs(): Int = parameters.size

	override fun parameters(): Array<Array<Type>> {
		return arrayOf(
			parameters
				.map { it.second }
				.toTypedArray<Type>()
		)
	}

	override fun invoke(vararg args: Variable): Variable {
		val oldValues = HashMap<String, Variable?>()
		for (i in parameters.indices) {
			val parameter = parameters[i].first
			oldValues[parameter] = Variable.names[parameter]
			Variable.names[parameter] = args[i]
		}

		val out = Runner.run(code)

		oldValues
			.entries
			.forEach {
				if (it.value == null)
					Variable.names.remove(it.key)
				else
					Variable.names[it.key] = it.value!!
			}

		return out
	}
}