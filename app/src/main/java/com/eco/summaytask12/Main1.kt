package com.eco.summaytask12

import com.eco.summaytask12.data.model.department.Department
import com.eco.summaytask12.data.service.DataService
import com.eco.summaytask12.data.model.employee.dev.androiddeveloper.AndroidDeveloper
import com.eco.summaytask12.data.model.employee.Employee
import com.eco.summaytask12.data.model.person.Gender
import com.eco.summaytask12.data.model.employee.dev.androiddeveloper.internandroid.InternAndroidDeveloper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

private val dataService = DataService()
fun main() {

//    val founderGg = Founder(
//        "Larry Page",
//        "26/03/1973",
//        Gender.MALE,
//        "Ha Dong Ha Noi",
//        "0123456789",
//        "phucthecomobile@gmail.com",
//        "Google"
//    )
    runBlocking {
        try {
            val addEmployees = launch(Dispatchers.IO) {
                dataService.addEmployees(createListEmployee())
            }
            val addAndroidDevelopers = launch(Dispatchers.IO) {
                dataService.addEmployees(createListAndroidDeveloper())
            }
            addEmployees.join()
            addAndroidDevelopers.join()
        } catch (e: Exception) {
            println("Error adding employees: ${e.message}")
            return@runBlocking
        }


        // Fetch multiple data sources concurrently
        println("-----Fetching all data concurrently-----")
        val getAllEmployees = async(Dispatchers.IO) { dataService.getAllEmployees() }
        val getAllAndroidDevelopers = async(Dispatchers.IO) { dataService.getAllAndroidDevelopers() }
        val getStatistics = async(Dispatchers.IO) { dataService.getStatistics() }
        
        println("-----Thông tin tất cả nhân viên -----")
        getAllEmployees.await().forEach {
            println(it)
        }
        
        println("-----Android Developers-----")
        getAllAndroidDevelopers.await().forEach {
            println(it)
        }

        println("-----Statistics-----")
        println(getStatistics.await())

        val getContactInfo = async(Dispatchers.IO) {
            dataService.getAllEmployees()
        }
        getContactInfo.await().forEach {
            println(it.contactInfo)
            println("---------------------------------------------------------")
        }


        println("Intern Android Developers:")
        val internAndroidDevelopers = dataService.getAllInternAndroidDevelopers()
        internAndroidDevelopers.forEach {
            println(it)
        }
    }

    checkPerformanceAddStudent()

}

fun checkPerformanceAddStudent() {
    val students = createListStudents()

    val timeAddStudent1 = measureTimeMillis {
        dataService.addStudent1(students)
    }
    println("TimeAddStudent1:$timeAddStudent1")

    val timeAddStudent2 = measureTimeMillis {
        dataService.addStudent2(students)
    }
    println("TimeAddStudent2:$timeAddStudent2")

    val timeSearchStudent1 = measureTimeMillis {
        println(dataService.searchStudent1("Thai Phuc").toString())
    }
    println("TimeSearchStudent1:$timeSearchStudent1")

    val timeSearchStudent2 = measureTimeMillis {
        println(dataService.searchStudent2("Thai Phuc").toString())
    }
    println("TimeSearchStudent2:$timeSearchStudent2")

    val studentCheckContain = InternAndroidDeveloper(
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
        println(dataService.checkContainStudent1(studentCheckContain))
    }
    println("TimeCheckContainStudent1:$timeCheckContainStudent1")

    val timeCheckContainStudent2 = measureTimeMillis {
        println(dataService.checkContainStudent2(studentCheckContain))
    }
    println("TimeCheckContainStudent2:$timeCheckContainStudent2")
}

fun createListStudents(): List<InternAndroidDeveloper> {
    val students = mutableListOf<InternAndroidDeveloper>()
    for (i in 0..1000) {
        students.add(
            InternAndroidDeveloper(
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
                Department.Outsource,
                10.0,
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
                Department.HumanResources
            )
        )
    }
    return employees
}
