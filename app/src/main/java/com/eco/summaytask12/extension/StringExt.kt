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
    return this.trim().split(" ").joinToString(separator = " ") {
            it.lowercase().replaceFirstChar { char ->
                char.uppercase()
            }
        }
}

fun String.toGender(): Gender = when {
    this.contains("Nam", ignoreCase = true) -> Gender.MALE
    this.contains("Nu", ignoreCase = true) -> Gender.FEMALE
    else -> throw IllegalArgumentException("Invalid gender value: $this")
}