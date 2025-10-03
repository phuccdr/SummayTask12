package com.eco.summaytask12.data.model.employee.dev.backenddeveloper

import com.eco.summaytask12.data.model.department.Department
import com.eco.summaytask12.data.model.employee.dev.BaseDev
import com.eco.summaytask12.data.model.employee.dev.exercise.JavaExercise
import com.eco.summaytask12.data.model.person.Gender

class BackendDeveloper(
    name: String,
    birthOfDate: String,
    gender: Gender,
    address: String,
    phone: String,
    email: String,
    department: Department,
    experience: Double,
    techSkills: MutableSet<String> = mutableSetOf()
) : BaseDev(
    name, birthOfDate, gender, address, phone, email, department, experience, techSkills
), JavaExercise {
    override fun studyJava() {
        TODO("Not yet implemented")
    }

    override fun code() {
        println("BackendDeveloper $name is coding")
    }

    override fun debug() {
        println("BackendDeveloper $name is debugging")
    }
}