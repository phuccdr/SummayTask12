package com.eco.summaytask12.data.model.employee.dev.androiddeveloper

import com.eco.summaytask12.data.model.department.Department
import com.eco.summaytask12.data.model.employee.Employee
import com.eco.summaytask12.data.model.employee.dev.BaseDev
import com.eco.summaytask12.data.model.employee.dev.DeveloperLevel
import com.eco.summaytask12.data.model.employee.dev.exercise.JavaExercise
import com.eco.summaytask12.data.model.employee.dev.exercise.KotlinExercise
import com.eco.summaytask12.data.model.person.Gender

open class AndroidDeveloper(
    name: String,
    birthOfDate: String,
    gender: Gender,
    address: String,
    phone: String,
    email: String,
    department: Department,
    experience: Double,
    techSkills: MutableSet<String> = mutableSetOf()
) : BaseDev(name, birthOfDate, gender, address, phone, email, department, experience, techSkills),KotlinExercise,JavaExercise {
    val level: DeveloperLevel
        get() = when {
            experience < 0.5 -> DeveloperLevel.INTERN
            experience < 1 -> DeveloperLevel.FRESHER
            experience < 3 -> DeveloperLevel.JUNIOR
            else -> DeveloperLevel.SENIOR
        }

    override fun greet() {
        println("Hello i am a Android Developer")
    }

    fun updateExperience(newExperience: Double) {
        this.experience = newExperience
    }

    override fun startWork() {
        println("Android Developer $name is coding app")
    }

    override fun finishWork() {
        println("Android Developer $name finished app")
    }

    override fun studyKotlin() {
        TODO("Not yet implemented")
    }

    override fun studyJava() {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "AndroidDeveloper(name='$name', birthOfDate='$birthOfDate', gender=$gender, address='$address', phone='$phone', email='$email', department='$department', experience=$experience, skills=$techSkills)"
    }


}