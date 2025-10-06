package com.eco.summaytask12.menu.screen

import com.eco.summaytask12.data.service.CreateEmployeeService
import com.eco.summaytask12.data.service.CreateProjectService
import com.eco.summaytask12.data.service.DataService
import com.eco.summaytask12.menu.MenuActionType
import com.eco.summaytask12.menu.MenuItem
import com.eco.summaytask12.menu.Screen

val backMenuItem = MenuItem("QUAY LAI", actionType = MenuActionType.BACK)
val dataService = DataService()
val employeeService = CreateEmployeeService()
val projectService = CreateProjectService()

/**
 * Dai dien chi man hinh chinh, ban dau khi nguoi dung chay chuong trinh
 */
val exitMenuItem = MenuItem("KET THUC CHUONG TRINH", actionType = MenuActionType.BACK)
val statisticsOverViewMenuItem = MenuItem(
    "BAO CAO TONG QUAN",
    actionType = MenuActionType.NAVIGATE,
    navigateScreen = statisticsOverviewScreen
)
val employeeManagementMenuItem = MenuItem(
    "QUAN LY NHAN VIEN",
    actionType = MenuActionType.NAVIGATE,
    navigateScreen = employeeManagementScreen
)
val projectManagementMenuItem = MenuItem(
    "QUAN LY PROJECT",
    actionType = MenuActionType.NAVIGATE,
    navigateScreen = projectManagementScreen
)
val mainScreen = Screen(
    "Main", listOf(
        exitMenuItem,
        statisticsOverViewMenuItem,
        employeeManagementMenuItem,
        projectManagementMenuItem,
        managerReportsMenuItem
    )
)