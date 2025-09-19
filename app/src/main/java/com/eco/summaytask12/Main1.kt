package com.eco.summaytask12

import com.eco.summaytask12.datamockup.DataRepository
import com.eco.summaytask12.model.AndroidDeveloper
import com.eco.summaytask12.model.Employee
import com.eco.summaytask12.model.Founder
import com.eco.summaytask12.model.Gender
import com.eco.summaytask12.model.Student
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

private val dataRepository = DataRepository()
fun main() {

    val founderGg = Founder(
        "Larry Page",
        "26/03/1973",
        Gender.MALE,
        "Ha Dong Ha Noi",
        "0123456789",
        "phucthecomobile@gmail.com",
        "Google"
    )
    runBlocking {
        val addEmployees = launch(Dispatchers.IO) {
            dataRepository.addEmployees(createListEmployee())
        }
        val addAndroidDevelopers = launch(Dispatchers.IO) {
            dataRepository.addEmployees(createListAndroidDeveloper())
        }
        addEmployees.join()
        addAndroidDevelopers.join()


        println("-----Thông tin tất cả nhân viên -----")
        val getAllEmployees = async(Dispatchers.IO) { dataRepository.getAllEmployees() }
        getAllEmployees.await().forEach {
            println(it)
        }

        println("-----Thông tin nhân viên theo phòng ban  -----")
        println("Nhập tên phòng ban:")

        val department: String? = readlnOrNull()
        val getEmployeesByDepartment = async(Dispatchers.IO) {
            department?.let {
                dataRepository.getEmployeesByDepartment(department.toString())
            }
        }
        getEmployeesByDepartment.await()?.forEach {
            println(it)
        }
        val getAllAndroidDevelopers = async(Dispatchers.IO) {
            dataRepository.getAllAndroidDevelopers()
        }
        getAllAndroidDevelopers.await().forEach {
            println(it)
        }

        val getStatistics = async(Dispatchers.IO) { dataRepository.getStatistics() }
        println(getStatistics.await())

        val getContactInfo = async(Dispatchers.IO) {
            dataRepository.getAllEmployees()
        }
        getContactInfo.await().forEach {
            println(it.contactInfo)
            println("---------------------------------------------------------")
        }

        println("Employee by position: Developer")
        val employeesByPosition = dataRepository.getEmployeesByPosition("Developer")
        employeesByPosition.forEach {
            println(it)
        }

        println("Intern Android Developers:")
        val internAndroidDevelopers = dataRepository.getAllInternAndroidDevelopers()
        internAndroidDevelopers.forEach {
            println(it)
        }
    }

    checkPerformanceAddStudent()

}

fun checkPerformanceAddStudent() {
    val students = createListStudents()

    val timeAddStudent1 = measureTimeMillis {
        dataRepository.addStudent1(students)
    }
    println("TimeAddStudent1:$timeAddStudent1")

    val timeAddStudent2 = measureTimeMillis {
        dataRepository.addStudent2(students)
    }
    println("TimeAddStudent2:$timeAddStudent2")

    val timeSearchStudent1 = measureTimeMillis {
        println(dataRepository.searchStudent1("Thai Phuc").toString())
    }
    println("TimeSearchStudent1:$timeSearchStudent1")

    val timeSearchStudent2 = measureTimeMillis {
        println(dataRepository.searchStudent2("Thai Phuc").toString())
    }
    println("TimeSearchStudent2:$timeSearchStudent2")

    val studentCheckContain = Student(
        "Thai Phuc",
        "20/09/2004",
        Gender.MALE,
        "Ha Noi",
        "0345527959",
        "thaiphuca1pdl@gmail.com",
        "Posts and Telecommunications Institute of Technology",
        "Software engineer",
        3.2f,
    )
    val timeCheckContainStudent1 = measureTimeMillis {
        println(dataRepository.checkContainStudent1(studentCheckContain))
    }
    println("TimeCheckContainStudent1:$timeCheckContainStudent1")

    val timeCheckContainStudent2 = measureTimeMillis {
        println(dataRepository.checkContainStudent2(studentCheckContain))
    }
    println("TimeCheckContainStudent2:$timeCheckContainStudent2")
}

fun createListStudents(): List<Student> {
    val students = mutableListOf<Student>()
    for (i in 0..100000) {
        students.add(
            Student(
                "Student $i",
                "18/09/2025",
                Gender.MALE,
                "Ha Noi",
                "0123456789",
                "thaiphuca1pdl@gmail.com",
                "Posts and Telecommunications Institute of Technology",
                "Software engineer"
            )
        )
    }
    return students
}


fun createListAndroidDeveloper(): List<AndroidDeveloper> {
    val androidDevelopers = mutableListOf<AndroidDeveloper>()
    for (i in 0..1000) {
        androidDevelopers.add(
            AndroidDeveloper(
                "AndroidDeveloper $i",
                "18/09/2025",
                Gender.MALE,
                "Ha Noi",
                "0123456789",
                "thaiphuca1pdl@gmail.com",
                "Developer",
                "R&D",
                1.0,
                hashSetOf("Kotlin", "Android")
            )
        )
    }
    return androidDevelopers
}

fun createListEmployee(): List<Employee> {
    val employees = mutableListOf<Employee>()
    for (i in 0..1000) {
        employees.add(
            Employee(
                "Employee $i",
                "18/09/2025",
                Gender.MALE,
                "Ha Noi",
                "0123456789",
                "thaiphuca1pdl@gmail.com",
                "Developer",
                "R&D",
                10000000.0
            )
        )
    }
    return employees
}
