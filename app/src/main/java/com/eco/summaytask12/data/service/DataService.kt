package com.eco.summaytask12.data.service

import com.eco.summaytask12.data.repository.EmployeeRepository
import com.eco.summaytask12.data.model.employee.Employee
import com.eco.summaytask12.data.model.androiddeveloper.AndroidDeveloper
import com.eco.summaytask12.data.model.manger.Manager
import com.eco.summaytask12.data.model.shareholder.ShareHolder
import com.eco.summaytask12.data.repository.ProjectRepository

class DataService {
    private val employeeRepository = EmployeeRepository()
    private val projectRepository = ProjectRepository()

    fun getAllShareholders(): List<ShareHolder> = employeeRepository.getAllShareholders()

    fun getAllManagers(): List<Manager> = employeeRepository.getAllManagers()

    fun getAllEmployees(): List<Employee> = employeeRepository.getAllEmployees()

    fun getAllAndroidDevelopers(): List<AndroidDeveloper> =
        employeeRepository.getAllAndroidDevelopers()

    fun addEmployees(employees: List<Employee>) = employeeRepository.addEmployees(employees)

    fun getAllInternAndroidDevelopers(): List<AndroidDeveloper> =
        employeeRepository.getAllInternAndroidDevelopers()

    fun searchEmployeeByName(name: String): Employee? =
        employeeRepository.searchEmployeeByName(name)

    fun getStatisticsEmployee(): Map<String, Any> = employeeRepository.getStatistics()

    fun getStatisticsProject(): Map<String, Any> = projectRepository.getStatistics()

    fun getIntroduction(): Map<String, Any> {
        val introduction = mutableMapOf<String, Any>()
        introduction["companyName"] = "EcoMobile"
        introduction["shareholders"] = getAllShareholders()
        introduction["introduction"] =
            "Eco Mobile thành lập vào năm 2017, là một Công ty hoạt động trong lĩnh vực sản xuất và phát triển ứng dụng di động."
        return introduction
    }

    fun getOverviewStatistics(): Map<String, Any> {
        val statistics = mutableMapOf<String, Any>()
        statistics["statisticsEmployee"] = getStatisticsEmployee()
        statistics["statisticsProject"] = getStatisticsProject()
        return statistics
    }

    fun getAllProjects() = projectRepository.getAllProjects()

    fun getCompletedProjects() = projectRepository.getCompletedProjects()

    fun getInProgressProjects() = projectRepository.getInProgressProjects()

    fun getNotStartedProjects() = projectRepository.getNotStartedProjects()

    fun searchProjectByName(name: String) = projectRepository.searchProjectByName(name)

    fun addProjects(projects: List<com.eco.summaytask12.data.model.project.Project>) = projectRepository.addProjects(projects)


}

