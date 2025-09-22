package com.eco.summaytask12

import com.eco.summaytask12.data.model.Gender
import com.eco.summaytask12.data.model.Student
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private val students: MutableList<Student> = mutableListOf()
fun main() {
//createListStudent()
//    val list1:List<Student> = students
//    val list2:HashSet<Student> = students.toHashSet()
//
//
    runBlocking {
        val task1 = async {
            task1()
        }

        val task2 = async {
            task2()
        }
        println("task2: ${task2.await()}")
        println("task1: ${task1.await()}")

    }
}


suspend fun task1(): String {
    delay(4000)
    println("task1 done")
    return "return task1"
}

suspend fun task2(): String {
    delay(1000)
    println("task2 done")
    return "return task2"
}

fun createListStudent() {
    for (i in 0..1000000) {
        students.add(
            Student(
                "Student$i", "09/09/2009",
                Gender.MALE,
                "Ha Noi",
                "1234567",
                "l@gmail.com",
                "Posts and Telecommunications Institute of Technology",
                "Software engineer",
                1.0f
            )
        )
    }
}

