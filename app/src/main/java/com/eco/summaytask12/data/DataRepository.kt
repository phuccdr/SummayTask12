package com.eco.summaytask12.data

import com.eco.summaytask12.data.model.AndroidDeveloper
import com.eco.summaytask12.data.model.DeveloperLevel
import com.eco.summaytask12.data.model.Employee
import com.eco.summaytask12.data.model.Gender
import com.eco.summaytask12.data.model.Student
import kotlinx.coroutines.delay

class DataRepository {

    private val mockAndroidDevelopers: List<AndroidDeveloper> get() {
       return mockEmployees.filterIsInstance<AndroidDeveloper>()
    }

    private val mockEmployees: MutableList<Employee> = mutableListOf(
        Employee(
            "Hoa Nguyen",
            "03/03/1993",
            Gender.FEMALE,
            "Thanh Xuan, Ha Noi",
            "0345678901",
            "hoa.nguyen@ecomobile.com",
            "HR Manager",
            "Human Resources",
            15_000_000.0
        ),
        Employee(
            "Nam Tran",
            "04/04/1994",
            Gender.MALE,
            "Dong Da, Ha Noi",
            "0456789012",
            "nam.tran@ecomobile.com",
            "Project Manager",
            "R&D",
            25000000.0
        ),
        AndroidDeveloper(
            "Phuc Thai", "20/09/2004", Gender.MALE, "Ha Dong Ha Noi",
            "0345527959", "phucth.ecomobile@gmail.com",
            "Intern", "R&D", 0.5,
            hashSetOf("Kotlin", "Android")
        ),
        AndroidDeveloper(
            "Minh Nguyen", "06/06/2006", Gender.MALE, "Cau Giay Ha Noi",
            "0987654321", "minh.nguyen@ecomobile.com",
            "Junior Developer", "R&D", 2.5,
            hashSetOf("Kotlin", "Java", "Android", "MVVM")
        ),
        AndroidDeveloper(
            "Linh Pham", "08/08/1998", Gender.FEMALE, "Ba Dinh Ha Noi",
            "0123456789", "linh.pham@ecomobile.com",
            "Senior Developer", "R&D", 4.0,
            hashSetOf("Kotlin", "Java", "Android", "Architecture", "Team Lead")
        )
    )

    suspend fun getAllAndroidDevelopers(): List<AndroidDeveloper> {
        println("Fetching all Android Developers.")
        delay(1500)
        println("Successfully fetched ${mockAndroidDevelopers.size} Android Developers")
        return mockAndroidDevelopers
    }

    suspend fun getAllEmployees(): List<Employee> {
        println("Fetching all Employees...")
        delay(1000)
        println("Successfully fetched ${mockEmployees.size} Employees")
        return mockEmployees
    }

    suspend fun getEmployeesByDepartment(department: String): List<Employee> {
        println("Fetching employees from department: $department")
        delay(900)
        val allEmployees = mockEmployees
        val results = allEmployees.filter { it.department.equals(department, ignoreCase = true) }
        println("Found ${results.size} employees in $department department")
        return results
    }

    suspend fun getStatistics(): Map<String, Any> {
        println("Calculating statistics...")
        delay(2000)
        val totalDevelopers = mockAndroidDevelopers.size
        val totalEmployees = mockEmployees.size
        val seniorDevs = mockAndroidDevelopers.count { it.experience >= 3.0 }
        val stats = mapOf(
            "totalAndroidDevelopers" to totalDevelopers,
            "totalEmployees" to totalEmployees,
            "seniorDevelopers" to seniorDevs,
            "totalSkills" to mockAndroidDevelopers.flatMap { it.skills }.distinct().size
        )
        println("Statistics calculated successfully")
        return stats
    }

    suspend fun addEmployees(employees: List<Employee>) {
        delay(1000)
//        mockAndroidDevelopers.addAll(employees.filterIsInstance<AndroidDeveloper>())
        mockEmployees.addAll(employees)
        println(employees[0])
        println("Successfully added ${employees.size} employees")
    }

    suspend fun getEmployeesByPosition(position: String): List<Employee> {
        println("Fetching employees by position: $position")
        delay(1000)
        return mockEmployees.filter { it.position.equals(position, ignoreCase = true) }
    }

    fun getAllInternAndroidDevelopers(): List<AndroidDeveloper> {
        return mockAndroidDevelopers.filter { it.level == DeveloperLevel.INTERN }
    }

    fun searchEmployeeByName(name: String): Employee? {
        return mockEmployees.find { it.name == name }
    }

    private var mockStudents1: MutableSet<Student> = mutableSetOf(
        Student(
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
    )

    private var mockStudents2: HashSet<Student> = hashSetOf(
        Student(
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
    )

    fun addStudent1(student: List<Student>) {
        mockStudents1.addAll(student)
    }

    fun addStudent2(student: List<Student>) {
        mockStudents2.addAll(student)
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

