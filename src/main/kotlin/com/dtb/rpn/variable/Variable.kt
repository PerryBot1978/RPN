package com.dtb.rpn.variable

import com.dtb.rpn.function.builtins.*
import com.dtb.rpn.function.builtins.math.DivFunction
import com.dtb.rpn.function.builtins.math.MinusFunction
import com.dtb.rpn.function.builtins.math.MultiplyFunction
import com.dtb.rpn.function.builtins.math.PlusFunction

interface Variable {
	fun stringify(): String

	companion object {
		val names = HashMap<String, Variable>()

		init {
			names["+"] = PlusFunction()
			names["-"] = MinusFunction()
			names["*"] = MultiplyFunction()
			names["/"] = DivFunction()

			names["="] = AssignmentFunction()
			names["newline"] = NewLineFunction()
		}
	}
}