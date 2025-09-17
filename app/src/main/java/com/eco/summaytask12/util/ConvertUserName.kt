package com.eco.summaytask12.util

fun String.normalizeUserName(): String {
    return this.trim().split(" ").map {
        it.lowercase().replaceFirstChar {
            it.uppercase()
        }
    }.joinToString(separator = " ")
}