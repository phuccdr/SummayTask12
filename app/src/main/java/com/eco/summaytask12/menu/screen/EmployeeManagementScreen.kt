package com.eco.summaytask12.menu.screen

import com.eco.summaytask12.menu.MenuActionType
import com.eco.summaytask12.menu.MenuItem
import com.eco.summaytask12.menu.Screen
import com.eco.summaytask12.utils.LoggerUtil

/**
 * Dai dien cho chu nang quan ly nhan vien
 */
val listAllEmployeesMenuItem = MenuItem("DANH SACH TAT CA NHAN VIEN", execute = {
    val employees = dataService.getAllEmployees()
    LoggerUtil.d(
        "ListAllEmployees", """
        DANH SACH TAT CA NHAN VIEN
        Tong so nhan vien: ${employees.size}
        ${
            employees.mapIndexed { index, employee ->
                "  ${index + 1}. ${employee.name} | Phong ban: ${employee.department} | Email: ${employee.email}"
            }.joinToString("\n")
        }
    """.trimIndent()
    )
})
val listAllManagersMenuItem = MenuItem("DANH SACH QUAN LY", execute = {
    val managers = dataService.getAllManagers()
    LoggerUtil.d(
        "ListAllManagers", """
        DANH SACH QUAN LY
        Tong so quan ly: ${managers.size}
        ${
            managers.mapIndexed { index, manager ->
                "  ${index + 1}. ${manager.name} | Phong ban: ${manager.department} | Email: ${manager.email}"
            }.joinToString("\n")
        }
    """.trimIndent()
    )
})
val listAllAndroidDevsMenuItem = MenuItem("DANH SACH ANDROID DEVELOPERS", execute = {
    val androidDevs = dataService.getAllAndroidDevelopers()
    LoggerUtil.d(
        "ListAllAndroidDevelopers", """
        DANH SACH ANDROID DEVELOPERS
        Tong so Android Developers: ${androidDevs.size}
        ${
            androidDevs.mapIndexed { index, dev ->
                "  ${index + 1}. ${dev.name} | Level: ${dev.devLevel} | Kinh nghiem: ${dev.experience} nam"
            }.joinToString("\n")
        }
        
    """.trimIndent()
    )
})
val searchEmployeeByNameMenuItem = MenuItem("TIM KIEM NHAN VIEN THEO TEN", execute = {
    LoggerUtil.d("SearchEmployee", "Nhap ten nhan vien can tim:")
    try {
        val name = com.eco.summaytask12.utils.InputHandlerUtil.readName()
        val employee = dataService.searchEmployeeByName(name)
        if (employee != null) {
            LoggerUtil.d(
                "SearchEmployee", """
                THONG TIN NHAN VIEN
                Ten: ${employee.name}
                Phong ban: ${employee.department}
                Email: ${employee.email}
                So dien thoai: ${employee.phone}
                Dia chi: ${employee.address}
            """.trimIndent()
            )
        } else {
            LoggerUtil.d("SearchEmployee", "Khong tim thay nhan vien voi ten: $name")
        }
    } catch (e: Exception) {
        LoggerUtil.e("SearchEmployee", e)
    }
})
val employeeStatisticsMenuItem = MenuItem("THONG KE NHAN VIEN", execute = {
    val statistics = dataService.getStatisticsEmployee()
    LoggerUtil.d(
        "EmployeeStatistics", """
        THONG KE NHAN VIEN
        ${statistics.entries.joinToString("\n") { "  ${it.key}: ${it.value}" }}
    """.trimIndent()
    )
})
val addEmployeeMenuItem = MenuItem(
    "THEM NHAN VIEN", actionType = MenuActionType.NAVIGATE, navigateScreen = addEmployeeScreen
)
val employeeManagementScreen = Screen(
    "EmployeeManagement", listOf(
        backMenuItem,
        listAllEmployeesMenuItem,
        listAllManagersMenuItem,
        listAllAndroidDevsMenuItem,
        searchEmployeeByNameMenuItem,
        addEmployeeMenuItem,
        employeeStatisticsMenuItem
    )
)