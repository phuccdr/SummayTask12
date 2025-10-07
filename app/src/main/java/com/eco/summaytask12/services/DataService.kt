package com.eco.summaytask12.services

import com.eco.summaytask12.repository.EmployeeRepository
import com.eco.summaytask12.model.androiddeveloper.AndroidDeveloper
import com.eco.summaytask12.model.employee.Employee
import com.eco.summaytask12.model.manger.Manager
import com.eco.summaytask12.model.project.Project
import com.eco.summaytask12.model.shareholder.ShareHolder
import com.eco.summaytask12.repository.DeviceRepository
import com.eco.summaytask12.repository.ProjectRepository

class DataService {
    private val employeeRepository = EmployeeRepository()
    private val projectRepository = ProjectRepository()
    private val deviceRepository = DeviceRepository()

    fun getAllShareholders(): List<ShareHolder> = employeeRepository.getAllShareholders()

    fun getAllManagers(): List<Manager> = employeeRepository.getAllManagers()

    fun addEmployee(employee: Employee) = employeeRepository.addEmployees(employee)


    fun searchEmployeeByName(name: String): Employee? =
        employeeRepository.searchEmployeeByName(name)

    fun getEmployeeStatistics(): Map<String, Any> = employeeRepository.getStatistics()

    fun getProjectStatistics(): Map<String, Any> = projectRepository.getStatistics()

    fun getIntroduction(): Map<String, Any> {
        val introduction = mutableMapOf<String, Any>()
        introduction["companyName"] = "EcoMobile"
        introduction["shareholders"] = getAllShareholders().joinToString {
            it.toString() + "\n"
        }
        introduction["introduction"] =
            "Eco Mobile thanh lap vao nam 2017, la mot Cong ty hoat dong trong linh vuc san xuat va phat trien ung dung di dong."
        return introduction
    }

    fun getOverviewStatistics(): Map<String, Any> {
        val statistics = mutableMapOf<String, Any>()
        statistics["statisticsEmployee"] = getEmployeeStatistics()
        statistics["statisticsProject"] = getProjectStatistics()
        return statistics
    }

    fun getAllProjects() = projectRepository.getAllProjects()

    fun getProjectsByIndex(index: List<Int>) = projectRepository.getProjectByIndex(index)

    fun updateProjectProgress(projectIndex: Int, newProgress: Float) {
        projectRepository.updateProjectProgress(projectIndex, newProgress)
    }

    fun getCompletedProjects() = projectRepository.getCompletedProjects()

    fun searchProjectByName(name: String) = projectRepository.searchProjectByName(name)

    fun addProjects(projects: List<Project>) = projectRepository.addProjects(projects)

    fun getDevicesByIndex(index: List<Int>) = deviceRepository.getDeviceByIndex(index)
    fun getDeviceStatistics() = deviceRepository.getStatistics()
    fun searchDevicesByName(deviceName: String) = deviceRepository.searchDevicesByName(deviceName)
    fun getAllDevices() = deviceRepository.getAllDevices()
    fun deleteDevice(deviceName: String): String {
        val result = deviceRepository.removeDevice(deviceName)
        return if (result) {
            "Đã xóa thiết bị '$deviceName' thành công!"
        } else {
            "Không tìm thấy thiết bị '$deviceName' để xóa."
        }
    }


}

