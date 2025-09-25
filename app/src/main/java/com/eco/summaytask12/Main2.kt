package com.eco.summaytask12

import com.eco.summaytask12.data.model.company.Company
import com.eco.summaytask12.data.service.DataService
import com.eco.summaytask12.extension.toGender
import com.eco.summaytask12.data.model.employee.androiddeveloper.AndroidDeveloper
import com.eco.summaytask12.data.model.employee.Employee
import com.eco.summaytask12.data.model.student.Student
import com.eco.summaytask12.data.model.founder.Founder
import com.eco.summaytask12.utils.readlnOrNullDate
import com.eco.summaytask12.utils.readlnOrNullDepartment
import com.eco.summaytask12.utils.readlnOrNullFloat
import com.eco.summaytask12.utils.readlnOrNullGender

private val dataService = DataService()
private val listChoose: List<String> = listOf(
    "Quay lai",
    "Thêm nhân viên",
    "Tìm kiem nhân viên theo tên",
    "In ra danh sach thông tin nhân viên",
    "In ra thống kê báo cáo nhân viên",
    "In ra danh sách thông tin Android dev theo level",
    "Thêm Android developer.",
    "Thêm sinh viên và ",
    "Khởi tạo công ty startup",
    "Danh sach Manager",
    "Bao cao cua Manager"
)

suspend fun main() {
    println("")
    while (true) {
        println(
            """
            Nhập 1 để thực hiện thêm nhân viên
            Nhập 2 để thực hiện tìm kiếm nhân viên theo tên
            Nhập 3 để thực hiện in ra danh sách thông tin nhân viên
            Nhập 4 để thực hiện in ra thống kê báo cáo nhân viên
            Nhập 5 để thực hiện in ra danh sách thông tin Android dev theo level
            Nhập 6 để thực hiện thêm Android developer.
            Nhập 7 để thực hiện tạo sinh viên và them sinh vien vao danh sach
            Nhập 8 để thực hiện tạo company và them company vao co so du lieu
            Nhập 9 để thực hiện in ra danh sach manager
            Nhập 10 để thực hiện in ra bao cao cua manager
            Nhập 0 để quay lại
        """.trimIndent()
        )
        // co nen de try catch cho nay khong
        val choose = readlnOrNull().trim().toInt()
        println(listChoose[choose])
        when (choose) {
            1 -> {
                addEmployee()
            }

            2 -> {
                searchEmployeeByName()
            }

            3 -> {
                getAllEmployees()
            }

            4 -> {
                getStatistics()
            }

            5 -> {
                getAndroidDeveloperByLevel()
            }

            6 -> {
                addAndroidDeveloper()
            }

            7 -> {
                addStudent()
            }
            8 -> {
                createCompanyStartup()
            }
            9 -> {
                getAllManagers()
            }

            10 ->{
                getStatisticsManagerByProjectCompleted()
            }

            0 -> {
                println("Quay lai")
                break
            }
        }
    }
}


/**
 * 1
 */
suspend fun addEmployee() {
    val newEmployee: Employee = createEmployee()
    dataService.addEmployees(listOf(newEmployee))
}

fun createEmployee(): Employee {
    println("Nhập tên nhân viên:")
    val name = readlnOrNull()
    println("Nhập ngày sinh nhân viên (dd/MM/yyyy): ")
    val birthOfDate = readlnOrNullDate()
    println("Nhập giới tính nhân viên (Nam/Nu): ")
    val gender = readlnOrNull()
    println("Nhập địa chỉ nhân viên: ")
    val address = readlnOrNull()
    println("Nhập số điện thoại nhân viên: ")
    val phone = readlnOrNull()
    println("Nhập email nhân viên: ")
    val email = readlnOrNull()
    println("Nhập chức vụ nhân viên: ")
    val position = readlnOrNull()
    println("Nhập phòng ban nhân viên: ")
    val department = readlnOrNullDepartment()
    println("Nhập lương nhân viên: ")
    return Employee(
        name, birthOfDate, gender.toGender(), address, phone, email, department
    )

}

/**
 * 2
 */
fun searchEmployeeByName() {
    val name = readlnOrNull()
    val employee = dataService.searchEmployeeByName(name)
    employee?.let {
        println(it)
        return
    }
    println("Không tìm thấy nhân viên với tên $name")
}

/**
 * 3
 */
suspend fun getAllEmployees() {
    val allEmployee = dataService.getAllEmployees()
    allEmployee.forEach {
        println(it)
    }
}

/**
 * 4
 */

suspend fun getStatistics() {
    val statistics = dataService.getStatistics()
    println(statistics)
}

/**
 * 5
 */
suspend fun getAndroidDeveloperByLevel() {
    val androidDevelopers = dataService.getAllAndroidDevelopers()
    androidDevelopers.groupBy { it.level }.forEach(action = {
        //   println(it)
        println(it.key.toString() + ":")
        println(it.value)
    })

}

/**
 * 6
 */
suspend fun addAndroidDeveloper() {
    val newAndroidDeveloper = createAndroidDeveloper()
    dataService.addEmployees(listOf(newAndroidDeveloper))
}

fun createAndroidDeveloper(): AndroidDeveloper {
    println("Nhap thong tin cua Android Dev")
    println("Nhap ten: ")
    val name = readlnOrNull()
    println("Nhap ngay sinh: ")
    val birthOfDate = readlnOrNullDate()
    println("Nhap gioi tinh: ")
    val gender = readlnOrNull()
    println("Nhap dia chi: ")
    val address = readlnOrNull()
    println("Nhap so dien thoai: ")
    val phone = readlnOrNull()
    println("Nhap email: ")
    val email = readlnOrNull()
    println("Nhap phong ban: ")
    val department = readlnOrNullDepartment()
    println("Nhap kinh nghiem: ")
    val experience = readlnOrNull()
    println("Nhap skills: ")
    val skills = readlnOrNull()
    return AndroidDeveloper(
        name,
        birthOfDate,
        gender.toGender(),
        address,
        phone,
        email,
        department,
        experience.toDouble(),
        skills.split(",").toHashSet()
    )

}

/**
 * 7
 */
fun addStudent() {
    val student = createStudent()
    student.studyKotlin()
    student.study("Coroutine")
    dataService.addStudent1(listOf(student))
    println("Them thanh cong: $student")
}

/**
 * 8
 */
 suspend fun createCompanyStartup() {
    // Tạo founder cho startup
    val founder = createFounder()
    println("Nhập tên công ty startup:")
    val companyName = readlnOrNull()
    println("Nhập địa chỉ công ty:")
    val companyAddress = readlnOrNull()
    val employees = dataService.getAllEmployees()
    val startup = Company.createStartup(companyName, companyAddress, founder)
    startup.addEmployees(employees)
    println("Thông tin công ty startup:")
    println(startup)
    founder.greet()
}


suspend fun getStatisticsManagerByProjectCompleted() {
    val manager = dataService.getAllManagers()
    manager.groupBy{
        it.projects.count{project ->
            project.isCompleted
        }
    }.forEach{
        println(it)
    }
}


suspend fun getAllManagers() {
    val managers = dataService.getAllManagers()
    managers.forEach {
        println(it)
    }
}

/**
 * Yeu cau nhap du lieu khong duoc de trong
 */
fun readlnOrNull(): String {
    while (true) {
        val string = kotlin.io.readlnOrNull()
        if (string.isNullOrEmpty()) {
            println("Không được để trống")
            continue
        }
        return string
    }
}



fun createStudent(): Student {
    println("------------- Nhập thông tin sinh viên -------------------")
    println("Nhập tên sinh viên:")
    val name = readlnOrNull()
    println("Nhập ngày sinh sinh viên (dd/MM/yyyy):")
    val birthOfDate = readlnOrNull()
    println("Nhập giới tính sinh viên (Nam/Nu):")
    val gender = readlnOrNullGender()
    println("Nhập địa chỉ sinh viên:")
    val address = readlnOrNull()
    println("Nhập số điện thoại sinh viên:")
    val phone = readlnOrNull()
    println("Nhập email sinh viên:")
    val email = readlnOrNull()
    println("Nhập tên trường đại học:")
    val university = readlnOrNull()
    println("Nhập chuyên ngành:")
    val major = readlnOrNull()
    println("Nhập điểm GPA (0.0 - 4.0):")
    val gpa = readlnOrNullFloat()
    println("Nhập kỹ năng (cách nhau bởi dấu phẩy):")
    val skillsInput = readlnOrNull()
    val skills = skillsInput.split(",").map { it.trim() }.toHashSet()
    
    return Student(
        name, birthOfDate, gender, address, phone, email,
        university, major, gpa, skills
    )
}

fun createFounder(): Founder {
    println("=== Nhập thông tin founder ===")
    println("Nhập tên founder:")
    val name = readlnOrNull()
    println("Nhập ngày sinh founder (dd/MM/yyyy):")
    val birthOfDate = readlnOrNullDate()
    println("Nhập giới tính founder (Nam/Nu):")
    val gender = readlnOrNullGender()
    println("Nhập địa chỉ founder:")
    val address = readlnOrNull()
    println("Nhập số điện thoại founder:")
    val phone = readlnOrNull()
    println("Nhập email founder:")
    val email = readlnOrNull()
    println("Nhập tên công ty:")
    val companyName = readlnOrNull()
    println("Nhập tầm nhìn của founder (vision):")
    val vision = readlnOrNull()
    
    return Founder(
        name, birthOfDate, gender, address, phone, email,
        companyName, vision
    )
}









