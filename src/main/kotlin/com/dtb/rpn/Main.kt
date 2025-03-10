package com.dtb.rpn

import java.io.File
import java.lang.AssertionError
import java.util.*

object Main {
	fun assert(cond: Boolean) {
		if (!cond) throw AssertionError()
	}

	@JvmStatic
	fun main(args: Array<String>) {
		Runner.run(File("lib/std.rpn").readLines())
		System.out.flush()

		val myScan = Scanner(System.`in`)
		print("File to run: ")
		val file = File(myScan.nextLine())
		Runner.run(file.readLines())
	}
}