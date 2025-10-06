package com.eco.summaytask12.data.service

import com.eco.summaytask12.data.model.androiddeveloper.AndroidDeveloper
import com.eco.summaytask12.data.model.backenddeveloper.BackendDeveloper
import com.eco.summaytask12.data.model.employee.Employee
import com.eco.summaytask12.data.model.internandroid.InternAndroidDeveloper
import com.eco.summaytask12.data.model.manger.Manager
import com.eco.summaytask12.utils.InputHandlerUtil
import com.eco.summaytask12.utils.LoggerUtil

class CreateEmployeeService {
    private val inputHandler = InputHandlerUtil

    // Nhap thong tin co ban cho employee
    fun createEmployee(): Employee {
        LoggerUtil.d("CreateEmployee", "Nhap ten:")
        val name = inputHandler.readName()
        LoggerUtil.d("CreateEmployee", "Nhap ngay sinh (dd/MM/yyyy):")
        val birthOfDate = inputHandler.readDate()
        LoggerUtil.d("CreateEmployee", "Nhap gioi tinh (Nam/Nu):")
        val gender = inputHandler.readGender()
        LoggerUtil.d("CreateEmployee", "Nhap dia chi:")
        val address = inputHandler.readString()
        LoggerUtil.d("CreateEmployee", "Nhap so dien thoai:")
        val phone = inputHandler.readString()
        LoggerUtil.d("CreateEmployee", "Nhap email:")
        val email = inputHandler.readString()
        LoggerUtil.d("CreateEmployee", "Chon phong ban:")
        val department = inputHandler.readDepartment()

        return Employee(name, birthOfDate, gender, address, phone, email, department)
    }

    // Nhap thong tin manager
    fun createManager(): Manager {
        LoggerUtil.d("CreateManager", "=== THEM MANAGER ===")
        LoggerUtil.d("CreateManager", "Nhap ten:")
        val name = inputHandler.readName()
        LoggerUtil.d("CreateManager", "Nhap ngay sinh (dd/MM/yyyy):")
        val birthOfDate = inputHandler.readDate()
        LoggerUtil.d("CreateManager", "Nhap gioi tinh (Nam/Nu):")
        val gender = inputHandler.readGender()
        LoggerUtil.d("CreateManager", "Nhap dia chi:")
        val address = inputHandler.readString()
        LoggerUtil.d("CreateManager", "Nhap so dien thoai:")
        val phone = inputHandler.readString()
        LoggerUtil.d("CreateManager", "Nhap email:")
        val email = inputHandler.readString()
        LoggerUtil.d("CreateManager", "Chon phong ban:")
        val department = inputHandler.readDepartment()

        return Manager(
            name, birthOfDate, gender, address, phone, email, department, mutableListOf()
        )
    }

    // Nhap thong tin android developer
    fun createAndroidDeveloper(): AndroidDeveloper {
        LoggerUtil.d("CreateAndroidDev", "=== THEM ANDROID DEVELOPER ===")
        LoggerUtil.d("CreateAndroidDev", "Nhap ten:")
        val name = inputHandler.readName()
        LoggerUtil.d("CreateAndroidDev", "Nhap ngay sinh (dd/MM/yyyy):")
        val birthOfDate = inputHandler.readDate()
        LoggerUtil.d("CreateAndroidDev", "Nhap gioi tinh (Nam/Nu):")
        val gender = inputHandler.readGender()
        LoggerUtil.d("CreateAndroidDev", "Nhap dia chi:")
        val address = inputHandler.readString()
        LoggerUtil.d("CreateAndroidDev", "Nhap so dien thoai:")
        val phone = inputHandler.readString()
        LoggerUtil.d("CreateAndroidDev", "Nhap email:")
        val email = inputHandler.readString()
        LoggerUtil.d("CreateAndroidDev", "Chon phong ban:")
        val department = inputHandler.readDepartment()
        LoggerUtil.d("CreateAndroidDev", "Nhap so nam kinh nghiem:")
        val experience = inputHandler.readDouble()

        LoggerUtil.d("CreateAndroidDev", "Nhap cac skill (cach nhau boi dau phay ','):")
        val skills = inputHandler.readString().split(',').filter { it.isNotBlank() }.toMutableSet()
        return AndroidDeveloper(
            name, birthOfDate, gender, address, phone, email, department, experience, skills
        )
    }

    // Nhap thong tin backend developer
    fun createBackendDeveloper(): BackendDeveloper {
        LoggerUtil.d("CreateBackendDev", "=== THEM BACKEND DEVELOPER ===")
        LoggerUtil.d("CreateBackendDev", "Nhap ten:")
        val name = inputHandler.readName()
        LoggerUtil.d("CreateBackendDev", "Nhap ngay sinh (dd/MM/yyyy):")
        val birthOfDate = inputHandler.readDate()
        LoggerUtil.d("CreateBackendDev", "Nhap gioi tinh (Nam/Nu):")
        val gender = inputHandler.readGender()
        LoggerUtil.d("CreateBackendDev", "Nhap dia chi:")
        val address = inputHandler.readString()
        LoggerUtil.d("CreateBackendDev", "Nhap so dien thoai:")
        val phone = inputHandler.readString()
        LoggerUtil.d("CreateBackendDev", "Nhap email:")
        val email = inputHandler.readString()
        LoggerUtil.d("CreateBackendDev", "Chon phong ban:")
        val department = inputHandler.readDepartment()
        LoggerUtil.d("CreateBackendDev", "Nhap so nam kinh nghiem:")
        val experience = inputHandler.readDouble()

        LoggerUtil.d("CreateBackendDev", "Nhap cac skill (cach nhau boi dau phay ','):")
        val skills = inputHandler.readString().split(',').filter { it.isNotBlank() }.toMutableSet()

        return BackendDeveloper(
            name, birthOfDate, gender, address, phone, email, department, experience, skills
        )
    }

    // Nhap thong tin intern android developer
    fun createInternAndroidDeveloper(): InternAndroidDeveloper {
        LoggerUtil.d("CreateIntern", "=== THEM INTERN ANDROID DEVELOPER ===")
        LoggerUtil.d("CreateIntern", "Nhap ten:")
        val name = inputHandler.readName()
        LoggerUtil.d("CreateIntern", "Nhap ngay sinh (dd/MM/yyyy):")
        val birthOfDate = inputHandler.readDate()
        LoggerUtil.d("CreateIntern", "Nhap gioi tinh (Nam/Nu):")
        val gender = inputHandler.readGender()
        LoggerUtil.d("CreateIntern", "Nhap dia chi:")
        val address = inputHandler.readString()
        LoggerUtil.d("CreateIntern", "Nhap so dien thoai:")
        val phone = inputHandler.readString()
        LoggerUtil.d("CreateIntern", "Nhap email:")
        val email = inputHandler.readString()
        LoggerUtil.d("CreateIntern", "Nhap ten truong dai hoc:")
        val university = inputHandler.readString()
        LoggerUtil.d("CreateIntern", "Nhap chuyen nganh:")
        val major = inputHandler.readString()
        LoggerUtil.d("CreateIntern", "Nhap diem GPA:")
        val gpa = inputHandler.readDouble().toFloat()
        LoggerUtil.d("CreateIntern", "Chon phong ban:")
        val department = inputHandler.readDepartment()
        LoggerUtil.d("CreateIntern", "Nhap so nam kinh nghiem:")
        val experience = inputHandler.readDouble()

        return InternAndroidDeveloper(
            name,
            birthOfDate,
            gender,
            address,
            phone,
            email,
            university,
            major,
            gpa,
            department,
            experience
        )
    }

}