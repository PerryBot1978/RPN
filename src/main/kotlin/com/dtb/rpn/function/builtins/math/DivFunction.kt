package com.dtb.rpn.function.builtins.math

import com.dtb.rpn.function.Function
import com.dtb.rpn.variable.DecimalVariable
import com.dtb.rpn.variable.NoneVariable
import com.dtb.rpn.variable.Type
import com.dtb.rpn.variable.Variable

class DivFunction : BinaryFunction {
	override fun invoke(vararg args: Variable): Variable {
		if (args[0] is DecimalVariable && args[1] is DecimalVariable)
			return args[0] as DecimalVariable / args[1] as DecimalVariable
		return NoneVariable()
	}
}