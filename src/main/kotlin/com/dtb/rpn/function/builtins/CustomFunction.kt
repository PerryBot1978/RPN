package com.dtb.rpn.function.builtins

import com.dtb.rpn.Runner
import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.StringVariable
import com.dtb.rpn.variable.Variable
import java.util.*
import kotlin.collections.HashMap

class CustomFunction(private val code: String, private val parameters: Array<Pair<String, Class<*>>>) : Function {
	override fun numArgs(): Int = parameters.size

	override fun parameters(): Array<Array<Class<*>>> {
		val out = arrayOf(
			parameters
				.map { it.second }
				.toTypedArray()
		)
//		println("[PARAMETERS] ${out.contentDeepToString()}")
		return out
	}

	override fun invoke(vararg args: Variable): Variable? {
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

	override fun type(): Class<*> {
		return CustomFunction::class.java
	}
}