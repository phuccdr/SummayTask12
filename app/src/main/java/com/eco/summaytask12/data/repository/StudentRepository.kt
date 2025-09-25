package com.eco.summaytask12.data.repository

import com.eco.summaytask12.data.mock.MockStudentData
import com.eco.summaytask12.data.model.student.Student

class StudentRepository {

    private val mockStudents1: MutableSet<Student> = MockStudentData.mockStudents1
    private val mockStudents2: HashSet<Student> = MockStudentData.mockStudents2

    fun addStudent1(students: List<Student>) {
        mockStudents1.addAll(students)
    }

    fun addStudent2(students: List<Student>) {
        mockStudents2.addAll(students)
    }

    fun searchStudent1(name: String): Student? {
        return mockStudents1.find { it.name == name }
    }

    fun searchStudent2(name: String): Student? {
        return mockStudents2.find { it.name == name }
    }

    fun checkContainStudent1(student: Student): Boolean {
        return mockStudents1.contains(student)
    }

    fun checkContainStudent2(student: Student): Boolean {
        return mockStudents2.contains(student)
    }
}
