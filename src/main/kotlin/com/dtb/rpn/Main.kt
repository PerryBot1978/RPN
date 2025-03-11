package com.dtb.rpn

import java.io.File
import java.lang.AssertionError
import java.nio.file.Files
import java.util.*
import kotlin.io.path.Path

object Main {
	fun assert(cond: Boolean) {
		if (!cond) throw AssertionError()
	}

	private fun runUserFile(myScan: Scanner) {
		print("File to run: ")
		val file = File(myScan.nextLine())
		Runner.run(file.readLines())
	}

	@JvmStatic
	fun main(args: Array<String>) {
		File("lib").list()!!.forEach {
			Runner.run(File(it).readLines())
		}
		System.out.flush()

		val myScan = Scanner(System.`in`)
		while (true)
			runUserFile(myScan)
	}
}