package com.eco.summaytask12.utils

/**
 * Object nay xu ly in ra log
 */
object LoggerUtil {
    fun d(tag: String = "", message: String) {
        if (tag.isBlank()) {
            println("$message")
        } else {
            println("$tag: $message")
        }
    }

    fun e(tag: String = "", exception: Exception) {
        println("$tag ${exception.message} ")
    }
}