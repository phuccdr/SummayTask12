package com.eco.summaytask12.data.repository

import com.eco.summaytask12.data.mock.MockStudentData
import com.eco.summaytask12.data.model.employee.dev.androiddeveloper.internandroid.InternAndroidDeveloper

class StudentRepository {

    private val mockStudents1: MutableSet<InternAndroidDeveloper> = MockStudentData.mockStudents1
    private val mockStudents2: HashSet<InternAndroidDeveloper> = MockStudentData.mockStudents2

    fun addStudent1(students: List<InternAndroidDeveloper>) {
        mockStudents1.addAll(students)
    }

    fun addStudent2(students: List<InternAndroidDeveloper>) {
        mockStudents2.addAll(students)
    }

    fun searchStudent1(name: String): InternAndroidDeveloper? {
        return mockStudents1.find { it.name == name }
    }

    fun searchStudent2(name: String): InternAndroidDeveloper? {
        return mockStudents2.find { it.name == name }
    }

    fun checkContainStudent1(student: InternAndroidDeveloper): Boolean {
        return mockStudents1.contains(student)
    }

    fun checkContainStudent2(student: InternAndroidDeveloper): Boolean {
        return mockStudents2.contains(student)
    }
}
