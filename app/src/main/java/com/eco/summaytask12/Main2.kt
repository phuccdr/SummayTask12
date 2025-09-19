package com.eco.summaytask12

import com.eco.summaytask12.datamockup.DataRepository
import com.eco.summaytask12.extension.toGender
import com.eco.summaytask12.model.AndroidDeveloper
import com.eco.summaytask12.model.Employee

private val dataRepository = DataRepository()
private val listChoose: List<String> = listOf(
    "Quay lai",
    "Thêm nhân viên",
    "Tìm kiem nhân viên theo tên",
    "In ra danh sach thông tin nhân viên",
    "In ra danh sach nhân viên theo phòng ban",
    "In ra thống kê báo cáo nhân viên",
    "In ra danh sách thông tin Android dev theo level",
    "Thêm Android developer."
)

suspend fun main() {
    println("")
    while (true) {
        println(
            """
            Nhập 1 để thực hiện thêm nhân viên
            Nhập 2 để thực hiện tìm kiếm nhân viên theo tên
            Nhập 3 để thực hiện in ra danh sách thông tin nhân viên
            Nhập 4 để thực hiện in ra danh sách nhân viên theo phòng ban
            Nhập 5 để thực hiện in ra thống kê báo cáo nhân viên
            Nhập 6 để thực hiện in ra danh sách thông tin Android dev theo level
            Nhập 7 để thực hiện thêm Android developer.
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
                getEmployeesByDepartment()
            }

            5 -> {
                getStatistics()
            }

            6 -> {
                getAndroidDeveloperByLevel()
            }

            7 -> {
                addAndroidDeveloper()
            }

            0 -> {
                println("Quay lai")
                break
            }
        }

    }

}

fun createAndroidDeveloper(): AndroidDeveloper {
    println("Nhap thong tin cua Android Dev")
    println("Nhap ten: ")
    val name = readlnOrNull()
    println("Nhap ngay sinh: ")
    val birthOfDate = readlnOrNull()
    println("Nhap gioi tinh: ")
    val gender = readlnOrNull()
    println("Nhap dia chi: ")
    val address = readlnOrNull()
    println("Nhap so dien thoai: ")
    val phone = readlnOrNull()
    println("Nhap email: ")
    val email = readlnOrNull()
    println("Nhap chuc vu: ")
    val position = readlnOrNull()
    println("Nhap phong ban: ")
    val department = readlnOrNull()
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
        position,
        department,
        experience.toDouble(),
        skills.split(",").toHashSet()
    )

}

suspend fun addAndroidDeveloper() {
    val newAndroidDeveloper = createAndroidDeveloper()
    dataRepository.addEmployees(listOf(newAndroidDeveloper))

}

suspend fun getAndroidDeveloperByLevel() {
    val androidDevelopers = dataRepository.getAllAndroidDevelopers()
    androidDevelopers.groupBy { it.level }.forEach(action = {
        //   println(it)
        println(it.key.toString() + ":")
        println(it.value)
    })

}

suspend fun getStatistics() {
    val statistics = dataRepository.getStatistics()
    println(statistics)
}

suspend fun getEmployeesByDepartment() {
    println("Nhập tên phòng ban:")
    val department = readlnOrNull()
    val getEmployeesByDepartment = dataRepository.getEmployeesByDepartment(department)
    getEmployeesByDepartment.forEach {
        println(it)
    }
}

suspend fun getAllEmployees() {
    val allEmployee = dataRepository.getAllEmployees()
    allEmployee.forEach {
        println(it)
    }
}


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

fun searchEmployeeByName() {
    val name = readlnOrNull()
    val employee = dataRepository.searchEmployeeByName(name)
    employee?.let {
        println(it)
        return
    }
    println("Không tìm thấy nhân viên với tên $name")
}


suspend fun addEmployee() {
    val newEmployee: Employee = createEmployee()
    dataRepository.addEmployees(listOf(newEmployee))
}

fun createEmployee(): Employee {
    println("Nhập tên nhân viên:")
    val name = readlnOrNull()
    println("Nhập ngày sinh nhân viên (dd/MM/yyyy): ")
    val birthOfDate = readlnOrNull()
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
    val department = readlnOrNull()
    println("Nhập lương nhân viên: ")
    val salary = readlnOrNull().toDouble()
    return Employee(
        name, birthOfDate, gender.toGender(), address, phone, email, position, department, salary
    )

}

