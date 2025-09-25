package com.eco.summaytask12.data.mock

import com.eco.summaytask12.data.model.department.Department
import com.eco.summaytask12.data.model.employee.Employee
import com.eco.summaytask12.data.model.employee.android_developer.AndroidDeveloper
import com.eco.summaytask12.data.model.employee.manger.Manager
import com.eco.summaytask12.data.model.person.Gender

object MockEmployeeData {
    val mockEmployees: MutableList<Employee> = mutableListOf(
        Employee(
            "Hoa Nguyen",
            "03/03/1993",
            Gender.FEMALE,
            "Thanh Xuan, Ha Noi",
            "0345678901",
            "hoa.nguyen@ecomobile.com",
            Department.HumanResources,
        ),
        Employee(
            "Nam Tran",
            "04/04/1994",
            Gender.MALE,
            "Dong Da, Ha Noi",
            "0456789012",
            "nam.tran@ecomobile.com",
            Department.Product,
        ),
        AndroidDeveloper(
            "Phuc Thai",
            "20/09/2004",
            Gender.MALE,
            "Ha Dong Ha Noi",
            "0345527959",
            "phucth.ecomobile@gmail.com",
            Department.Product,
            4.0,
            hashSetOf("Kotlin", "Java", "Android", "Architecture")
        ),
        AndroidDeveloper(
            "Minh Nguyen", "06/06/2006", Gender.MALE, "Cau Giay Ha Noi",
            "0987654321", "minh.nguyen@ecomobile.com",
            Department.Product,
            1.0,
            hashSetOf("Kotlin", "Java", "Android", "MVVM"),
        ),
        AndroidDeveloper(
            "Linh Pham",
            "08/08/1998",
            Gender.FEMALE,
            "Ba Dinh Ha Noi",
            "0123456789",
            "linh.pham@ecomobile.com",
            Department.Outsource,
            4.0,
            hashSetOf("Kotlin", "Java", "Android", "Architecture", "Team Lead")
        ),
        Manager(
            "Phuc Thai",
            "20/09/2004",
            Gender.MALE,
            "Ha Dong Ha Noi",
            "0345527959",
            "phucth.ecomobile@gmail.com",
            Department.Product,
            MockProject.projects,
        ),
    )
    val mockAndroidDevelopers: List<AndroidDeveloper>
        get() = mockEmployees.filterIsInstance<AndroidDeveloper>()
    val mockManagers: List<Manager> get() = mockEmployees.filterIsInstance<Manager>()
}
