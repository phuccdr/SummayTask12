package com.eco.summaytask12.data.model.androiddeveloper

import com.eco.summaytask12.data.model.device.Device
import com.eco.summaytask12.data.model.employee.Department
import com.eco.summaytask12.data.model.dev.BaseDev
import com.eco.summaytask12.data.model.person.Gender
import com.eco.summaytask12.data.model.dev.exercise.JavaExercise
import com.eco.summaytask12.data.model.dev.exercise.KotlinExercise
import java.util.Date

open class AndroidDeveloper(
    name: String,
    birthOfDate: Date,
    gender: Gender,
    address: String,
    phone: String,
    email: String,
    department: Department,
    experience: Double,
    techSkills: MutableSet<String> = mutableSetOf(),
    val deviceTesting: MutableList<Device> = mutableListOf(),
) : BaseDev(name, birthOfDate, gender, address, phone, email, department, experience, techSkills),
    KotlinExercise, JavaExercise {
    override fun greet() {
        println("Hello, my name is $name i am  a ${devLevel} Android Developer")
    }

    override fun startWork() {
        println("Android Developer $name is coding app")
    }

    override fun finishWork() {
        println("Android Developer $name finished app")
    }

    // overloading
    fun studyKotlin(topic: String) {
        println("Android Developer $name is studying $topic")
    }

    override fun studyKotlin() {
        println("Android Developer $name is studying Kotlin")
    }

    fun studyJava(topic: String) {
        println("Android Developer $name is studying $topic")
    }

    override fun studyJava() {
        println("Android Developer $name is studying Java")
    }

    override fun toString(): String {
        return "AndroidDeveloper(name='$name', birthOfDate='$birthOfDate', gender=$gender, address='$address', phone='$phone', email='$email', department='$department', experience=$experience, skills=$techSkills)"
    }


}