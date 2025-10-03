package com.eco.summaytask12.utils

import com.eco.summaytask12.data.model.department.Department
import com.eco.summaytask12.data.model.person.Gender
import com.eco.summaytask12.extension.isValidDate

/**
 * Yeu cau nhap du lieu la so Double
 */
fun readlnOrNullDouble(): Double {
    while (true) {
        val string = com.eco.summaytask12.readlnOrNull()
        if (string.isEmpty()) {
            println("Không được để trống")
            continue
        } else if (string.toDoubleOrNull() == null) {
            println("Phải là số nguyên")
            continue
        } else {
            return string.toDouble()
        }
    }
}

/**
 * Yeu cau nhap du lieu la so Float
 */
fun readlnOrNullFloat(): Float {
    while (true) {
        val string = com.eco.summaytask12.readlnOrNull()
        if (string.isEmpty()) {
            println("Không được để trống")
            continue
        } else if (string.toFloatOrNull() == null) {
            println("Phải là số thực")
            continue
        } else {
            return string.toFloat()
        }
    }
}

/**
 * Yeu cau nhap dung dinh dang dd/mm/yyyy
 */
fun readlnOrNullDate(): String {
    var date = com.eco.summaytask12.readlnOrNull()
    while (!date.isValidDate()) {
        println("Yeu cau nhap dung dinh dang dd/mm/yyyy")
        date = com.eco.summaytask12.readlnOrNull()
    }
    return date
}

fun readlnOrNullDepartment(): Department {
    val input = com.eco.summaytask12.readlnOrNull()
    when {
        input.equals("Product", ignoreCase = true) -> return Department.Product
        input.equals("Outsource", ignoreCase = true) -> return Department.Outsource
        else -> {
            println("Phòng ban không hợp lệ")
            return readlnOrNullDepartment()
        }
    }
}

fun readlnOrNullGender(): Gender {
    val input = com.eco.summaytask12.readlnOrNull()
    when {
        input.equals("Nam", ignoreCase = true) -> return Gender.MALE
        input.equals("Nu", ignoreCase = true) -> return Gender.FEMALE
    }
    println("Gioi tinh khong hop le")
    return readlnOrNullGender()
}
