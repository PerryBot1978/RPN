package com.dtb.rpn.function.builtins

import com.dtb.rpn.Main
import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.Variable

class AssignmentFunction : Function {
	override fun numArgs(): Int = 2

	override fun parameters(): Array<Array<Class<*>>> {
		return arrayOf(
			arrayOf(Variable::class.java, Variable::class.java)
		)
	}

	override fun invoke(vararg args: Variable): Variable {
//		println("${args[0]} = ${args[1]}")
//		Main.assert(args[0] is PlaceholderVariable)
		Variable.assign(args[0].findName()!!, args[1])
		return args[1]
	}
}