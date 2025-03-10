package com.dtb.rpn.variable

import java.lang.NumberFormatException
import java.math.BigDecimal

class DecimalVariable(private var value: BigDecimal) : Variable {
	companion object {
		fun of(str: String): DecimalVariable? {
			return try {
				DecimalVariable(BigDecimal(str))
			} catch (e: NumberFormatException) {
				null
			}
		}
	}

	operator fun plus(other: DecimalVariable): DecimalVariable {
		return DecimalVariable(this.value + other.value)
	}
	operator fun minus(other: DecimalVariable): DecimalVariable {
		return DecimalVariable(this.value - other.value)
	}
	operator fun times(other: DecimalVariable): DecimalVariable {
		return DecimalVariable(this.value * other.value)
	}
	operator fun div(other: DecimalVariable): DecimalVariable {
		return DecimalVariable(this.value / other.value)
	}

	operator fun plusAssign(other: DecimalVariable) {
		this.value += other.value
	}
	operator fun minusAssign(other: DecimalVariable) {
		this.value -= other.value
	}
	operator fun timesAssign(other: DecimalVariable) {
		this.value *= other.value
	}
	operator fun divAssign(other: DecimalVariable) {
		this.value /= other.value
	}

	override fun stringify(): String = value.toString()
	override fun toString():  String = "DecimalVariable($value)"
}