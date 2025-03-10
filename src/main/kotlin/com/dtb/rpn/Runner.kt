package com.dtb.rpn

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.Variable
import java.util.*

object Runner {
	fun run(lines: Iterable<String>) {
		lines.forEach {
			println(run(it))
		}
	}
	fun run(line: String): Variable? {
		val stack = Parser.parse(line)
//		println("[STACK] $stack")

		val variable = stack.pop()
		if (variable !is Function)
			throw IllegalArgumentException()

		return run(stack, variable)
	}
	private fun run(stack: Stack<Variable>, func: Function): Variable? {
//		println(func)

		var args = Array<Variable?>(func.numArgs()) { null }
		for (i in args.indices) {
			val arg = stack.pop()
			if (arg is Function)
				return run(stack, arg)
			args[i] = arg
		}
		args = args.reversedArray()

		val parameterMatch = func.parameters().any {
			var out = true
			for (i in it.indices)
				out = out && it[i].isInstance(args[i])
			out
		}

		if (!parameterMatch)
			throw IllegalArgumentException("${args.contentToString()} don't match any parameter list of $func")
		return func(args = args.map{ it!! }.toTypedArray())
	}
}