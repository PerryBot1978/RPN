package com.dtb.rpn.function

import com.dtb.rpn.variable.Variable

interface Function : Variable {
	fun numArgs(): Int
	fun parameters(): Array<Array<Class<*>>>

	operator fun invoke(vararg args: Variable): Variable?
	override fun stringify(): String = this.javaClass.name
}