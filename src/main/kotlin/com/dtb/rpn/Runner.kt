package com.dtb.rpn

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.Variable
import java.util.*

object Runner {
	fun run(lines: Iterable<String>) {
		lines
			.filter { it.isNotEmpty() }
			.map { run(it) }
			.forEach {
				println(it ?: "")
				System.out.flush()
			}
	}
	fun run(line: String): Variable? {
		val stack = Parser.parse(line)
//		println("[STACK] $stack")
//		println("[VARS]  ${Variable.names}")

		if (stack.empty())
			return null

		val variable = stack.pop()
		if (variable !is Function)
			return variable

		return run(stack, variable)
	}
	private fun run(stack: Stack<Variable>, func: Function): Variable? {
		var args = Array<Variable?>(func.numArgs()) { null }
		for (i in args.indices) {
			val arg = stack.pop()
			args[i] =
				if (arg is Function) run(stack, arg)
				else arg
		}
		args = args.reversedArray()

		val parameterMatch = func.parameters().any {
			var out = true
			for (i in it.indices)
				out = out && it[i].isInstance(args[i])
			out
		}

		if (func.parameters().isNotEmpty() && !parameterMatch)
			throw IllegalArgumentException("${args.contentToString()} don't match any parameter list of $func")

//		println("[STACK] $stack")
		return func(args = args.map{ it!! }.toTypedArray())
	}
}