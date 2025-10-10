package com.eco.summaytask12.handler.input

import com.eco.summaytask12.data.model.androiddeveloper.AndroidDeveloper
import com.eco.summaytask12.data.model.backenddeveloper.BackendDeveloper
import com.eco.summaytask12.data.model.employee.Employee
import com.eco.summaytask12.data.model.manger.Manager
import com.eco.summaytask12.data.services.DataService
import com.eco.summaytask12.di.AppModule
import com.eco.summaytask12.utils.LoggerUtil

/**
 * CreateEmployeeUtil - Utility class để tạo Employee
 *
 * Sử dụng Dependency Injection: nhận dependencies từ bên ngoài
 */
class InputHandlerEmployeeExt(
    private val inputHandler: InputHandler,
    private val dataService: DataService = AppModule.provideDataService()
) {
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
        LoggerUtil.d(
            "CreateManager", "Nhap cac du an quan ly ( theo so thu tu cach nhau dau phay):"
        )
        val projectIds = inputHandler.readString().split(',').mapNotNull { it.toIntOrNull() }
        val projects = dataService.getProjectsByIndex(projectIds).toMutableList()

        return Manager(
            name, birthOfDate, gender, address, phone, email, department, projects
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
        LoggerUtil.d(
            "CreateAndroidDev",
            "Nhap index cac testing device (cach nhau boi dau phay ',')"
        )
        val testingDevices = inputHandler.readString().split(',').mapNotNull { it.toIntOrNull() }
        val devices = dataService.getDevicesByIndex(testingDevices).toMutableList()

        return AndroidDeveloper(
            name,
            birthOfDate,
            gender,
            address,
            phone,
            email,
            department,
            experience,
            skills,
            devices
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
        LoggerUtil.d("CreateBackendDev", "Nhap cac cloudService (cach nhau boi dau phay ',')")
        val cloudService =
            inputHandler.readString().split(',').filter { it.isNotBlank() }.toMutableList()

        return BackendDeveloper(
            name,
            birthOfDate,
            gender,
            address,
            phone,
            email,
            department,
            experience,
            skills,
            cloudService
        )
    }

}