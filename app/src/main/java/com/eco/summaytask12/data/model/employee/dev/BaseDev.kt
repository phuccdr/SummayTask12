package com.eco.summaytask12.data.model.employee.dev

import com.eco.summaytask12.data.model.department.Department
import com.eco.summaytask12.data.model.employee.Employee
import com.eco.summaytask12.data.model.employee.dev.exercise.DevExercise
import com.eco.summaytask12.data.model.person.Gender

abstract class BaseDev(
    name: String,
    birthOfDate: String,
    gender: Gender,
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

    fun addSkill(skill: String) {
        techSkills.add(skill)
    }

    fun removeSkill(skill: String) {
        techSkills.remove(skill)
    }

    override fun code() {
        println("Developer $name is coding")
    }

    override fun debug() {
        println("Developer $name is debugging")
    }

}