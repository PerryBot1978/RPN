package com.dtb.rpn

import com.dtb.rpn.variable.DecimalVariable
import com.dtb.rpn.variable.StringVariable
import com.dtb.rpn.variable.Variable
import java.util.*

object Parser {
	private fun tokenize(str: String): Variable {
//		println("[TOKEN] $str")
		if (Variable.names.contains(str))
			return Variable.names[str]!!

		val decimal = DecimalVariable.of(str)
		if (decimal != null)
			return decimal

		return StringVariable(str)
	}

	fun parse(line: String): Stack<Variable> {
		val stack  = Stack<String>()
		var buffer = StringBuffer()
		var inQuotes = false

		line.forEachIndexed { _, char ->
			if (char == '"') {
				inQuotes = !inQuotes
			} else if (inQuotes) {
				buffer.append(char)
			} else if (char == ' ') {
				stack.push(buffer.toString())
				buffer = StringBuffer()
			} else {
				buffer.append(char)
			}
		}
		stack.push(buffer.toString())

		val out = Stack<Variable>()
		stack.toList().forEach { out.push(tokenize(it)) }
		return out
	}
}