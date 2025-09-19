package com.eco.summaytask12.extension

import com.eco.summaytask12.model.Gender
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
fun String.toGender(): Gender = when (this.toInt()) {
    0 -> Gender.MALE
    1 -> Gender.FEMALE
    else -> throw IllegalArgumentException("Invalid gender value: $this")
}