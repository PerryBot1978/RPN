package com.dtb.rpn

import java.io.File
import java.util.*

object Main {
	@JvmStatic
	fun main(args: Array<String>) {
		val myScan = Scanner(System.`in`)
		print("File to run: ")
		val file = File(myScan.nextLine())
		Runner.run(file.readLines())
	}
}