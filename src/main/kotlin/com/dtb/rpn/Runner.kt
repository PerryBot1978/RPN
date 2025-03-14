package com.dtb.rpn

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.NoneVariable
import com.dtb.rpn.variable.Variable
import java.util.*

object Runner {
	fun run(lines: Iterable<String>) {
		var i = 1
		lines.forEach() {
				if (it.isNotEmpty()) {
					val out = run(it)
					if (out !is NoneVariable)
						println("\t${i}: $out")
					System.out.flush()
				}
				i++
			}
	}
	fun run(line: String): Variable {
		val stack = Parser.parse(line)
//		println("[STACK] $stack")
//		println("[VARS]  ${Variable.names}")

		if (stack.empty())
			return NoneVariable()

		val variable = stack.pop()
		if (variable !is Function)
			return variable

		return run(stack, variable)
	}
	private fun run(stack: Stack<Variable>, func: Function): Variable {
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
			for (i in it.indices) {
//				println("${it[i]} == ${args[i]!!.type()}")
				out = out && it[i].equals(args[i]!!.type())
			}
			out
		}

//		println(parameterMatch)
//		if (!parameterMatch)
//			println(args.contentToString())

//		if (func.parameters().isNotEmpty() && !parameterMatch)
//			throw IllegalArgumentException("${args.contentToString()} don't match any of ${func.parameters().contentDeepToString()}")

//		println("[STACK] $stack")
		return func(args = args.map{ it!! }.toTypedArray())
	}
}