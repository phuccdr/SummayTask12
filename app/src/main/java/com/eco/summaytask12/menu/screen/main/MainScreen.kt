package com.eco.summaytask12.menu.screen.main

import com.eco.summaytask12.menu.screen.devicemanagement.DeviceManagementScreen
import com.eco.summaytask12.menu.screen.employeemanagement.EmployeeManagementScreen
import com.eco.summaytask12.menu.screen.projectmanagement.ProjectManagementScreen
import com.eco.summaytask12.menu.menuitem.MenuItem
import com.eco.summaytask12.menu.screen.Screen
import com.eco.summaytask12.menu.screen.statisticoverview.StatisticsOverviewScreen

class MainScreen : Screen() {
    override fun createMenu() {
        menu.add(exitMenuItem)
        exitMenuItem.onClick = {
            back()
        }
        menu.add(statisticsOverViewMenuItem)
        statisticsOverViewMenuItem.onClick = {
            navigate(StatisticsOverviewScreen())
        }
        menu.add(employeeManagementMenuItem)
        employeeManagementMenuItem.onClick = {
            navigate(EmployeeManagementScreen())
        }
        menu.add(projectManagementMenuItem)
        projectManagementMenuItem.onClick = {
            navigate(ProjectManagementScreen())
        }
        menu.add(deviceManagementMenuItem)
        deviceManagementMenuItem.onClick = {
            navigate(DeviceManagementScreen())
        }
    }

}

private val exitMenuItem = MenuItem("KET THUC CHUONG TRINH")
private val statisticsOverViewMenuItem = MenuItem(
    "BAO CAO TONG QUAN CONG TY",
)
private val employeeManagementMenuItem = MenuItem(
    "QUAN LY NHAN VIEN",
)
private val projectManagementMenuItem = MenuItem(
    "QUAN LY PROJECT",
)
private val deviceManagementMenuItem = MenuItem(
    "QUAN LY THIET BI",
)
