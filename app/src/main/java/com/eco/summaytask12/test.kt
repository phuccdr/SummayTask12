package com.eco.summaytask12

import com.eco.summaytask12.model.Gender
import com.eco.summaytask12.model.Student

private val students: MutableList<Student> = mutableListOf()
fun main() {
createListStudent()
    val list1:List<Student> = students
    val list2:HashSet<Student> = students.toHashSet()


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

