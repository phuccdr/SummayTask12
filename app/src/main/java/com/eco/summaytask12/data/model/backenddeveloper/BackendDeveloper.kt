package com.eco.summaytask12.data.model.backenddeveloper

import com.eco.summaytask12.data.model.employee.Department
import com.eco.summaytask12.data.model.dev.BaseDev
import com.eco.summaytask12.data.model.dev.exercise.JavaExercise
import com.eco.summaytask12.data.model.person.Gender
import java.util.Date

class BackendDeveloper(
    name: String,
    birthOfDate: Date,
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
    override fun greet() {
        println("Hello, my name is $name i am  a $devLevel Backend Developer")
    }

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