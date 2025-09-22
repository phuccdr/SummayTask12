package com.eco.summaytask12.extension

import com.eco.summaytask12.data.model.Gender
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Convert String to Date (format dd/MM/yyyy)
 */
fun String?.stringToDate(): Date {
    val date = this?.let {
        val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        format.parse(this)
    }
    return date ?: Date()
}

/**
 * Normalize String to name
 */
fun String.normalizeUserName(): String {
    return this.trim().split(" ").joinToString(separator = " ") {
        it.lowercase().replaceFirstChar { char ->
            char.uppercase()
        }
    }
}

/**
 * Convert String to Gender
 */

fun String.toGender(): Gender = when {
    this.contains("Nam", ignoreCase = true) -> Gender.MALE
    this.contains("Nu", ignoreCase = true) -> Gender.FEMALE
    else -> throw IllegalArgumentException("Invalid gender value: $this")
}


/**
 *
 */

