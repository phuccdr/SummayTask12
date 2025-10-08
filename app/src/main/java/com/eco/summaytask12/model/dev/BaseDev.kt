package com.eco.summaytask12.model.dev

import com.eco.summaytask12.model.employee.Department
import com.eco.summaytask12.model.employee.Employee
import com.eco.summaytask12.model.dev.exercise.DevExercise
import java.util.Date

abstract class BaseDev(
    name: String,
    birthOfDate: Date,
    gender: com.eco.summaytask12.model.person.Gender,
    address: String,
    phone: String,
    email: String,
    department: Department,
    var experience: Double,
    var techSkills: MutableSet<String> = mutableSetOf()
) : Employee(
    name, birthOfDate, gender, address, phone, email, department
), DevExercise {
    val devLevel: DeveloperLevel
        get() {
            return when {
                experience < 0.5 -> DeveloperLevel.INTERN
                experience < 1 -> DeveloperLevel.FRESHER
                experience < 3 -> DeveloperLevel.JUNIOR
                else -> DeveloperLevel.SENIOR
            }
        }

    override fun study() {
        println("Developer $name is studying new technology")
    }

    override fun code() {
        println("Developer $name is coding")
    }

    override fun debug() {
        println("Developer $name is debugging")
    }

}