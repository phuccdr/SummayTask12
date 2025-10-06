package com.eco.summaytask12.utils

import com.eco.summaytask12.Constant
import com.eco.summaytask12.data.model.employee.Department
import com.eco.summaytask12.data.model.person.Gender
import com.eco.summaytask12.extension.normalizeUserName
import com.eco.summaytask12.extension.toGender
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Object nay xu ly khi du lieu dau vao.
 * Xu ly cac try catch input throw cac exception de xu ly phia sau.
 */
object InputHandlerUtil {
    private fun inputString(): String {
        val input = readlnOrNull()
        if (input.isNullOrBlank()) {
            throw Exception( Constant.MUST_NOT_EMPTY)
        }
        return input
    }

    fun readString(): String {
        while (true) {
            try {
                return inputString()
            } catch (e: Exception) {
                LoggerUtil.e(exception = e)
            }
        }
    }

    fun readName(): String {
        return readString().normalizeUserName()
    }

    private fun inputDate(): Date {
        val input = inputString()
        val formatter = SimpleDateFormat(Constant.DATE_FORMAT, Locale.getDefault())
        formatter.isLenient = false
        return try {
            formatter.parse(input) ?: throw Exception(
                 Constant.PLEASE_ENTER_DATE
            )
        } catch (e: Exception) {
            throw Exception( Constant.PLEASE_ENTER_DATE)
        }
    }

    fun readDate(): Date {
        while (true) {
            try {
                return inputDate()
            } catch (e: Exception) {
                LoggerUtil.e(exception=e)
            }
        }
    }

    fun inputInt(): Int {
        val input = inputString()
        return try {
            input.toInt()
        } catch (e: Exception) {
            throw Exception(Constant.PLEASE_ENTER_NUMBER)
        }
    }

    fun readInt(): Int {
        while (true) {
            try {
                return inputInt()
            } catch (e: Exception) {
                LoggerUtil.e(exception = e)
            }
        }
    }

    private fun inputDouble(): Double {
        val input = inputString()
        return try {
            input.toDouble()
        } catch (e: Exception) {
            throw Exception( Constant.PLEASE_ENTER_NUMBER)
        }
    }

    fun readDouble(): Double {
        while (true) {
            try {
                return inputDouble()
            } catch (e: Exception) {
                LoggerUtil.e(exception = e)
            }
        }
    }

    fun readGender(): Gender {
        while (true) {
            val input = inputString()
            try {
                return input.toGender()
            } catch (e: Exception) {
                LoggerUtil.e(exception = e)
            }
        }
    }

    private fun inputDepartment(): Department {
        LoggerUtil.d(message = """
            1. Product
            2. Outsource
        """.trimIndent())
        val input = inputInt()
        return when (input) {
            1 -> Department.Product
            2 -> Department.Outsource
            else -> throw Exception(Constant.INVALID_OPTION)
        }
    }
    
    fun readDepartment(): Department {
        while (true) {
            try {
                return inputDepartment()
            } catch (e: Exception) {
                LoggerUtil.e(exception = e)
            }
        }
    }


}