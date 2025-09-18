package com.eco.summaytask12.extension

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun String?.stringToDate(): Date {
    val date = this?.let {
        val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        format.parse(this)
    }
    return date ?: Date()
}

fun String.normalizeUserName(): String {
    return this.trim().split(" ").map {
        it.lowercase().replaceFirstChar {
            it.uppercase()
        }
    }.joinToString(separator = " ")
}
