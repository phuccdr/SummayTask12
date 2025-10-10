package com.eco.summaytask12.menu.screen.employeemanagement

import com.eco.summaytask12.di.AppModule
import com.eco.summaytask12.menu.menuitem.MenuItem
import com.eco.summaytask12.menu.screen.Screen
import com.eco.summaytask12.menu.screen.addemployee.AddEmployeeScreen
import com.eco.summaytask12.data.services.DataService

/**
 * EmployeeManagementScreen - Màn hình quản lý nhân viên
 * Sử dụng Dependency Injection: nhận DataService từ AppModule
 */
class EmployeeManagementScreen(
    private val dataService: DataService = AppModule.provideDataService()
) : Screen() {
    override fun createMenu() {
        menu.add(backMenuItem)
        backMenuItem.onClick = {
            back()
        }

        menu.add(statisticsOverviewEmployeeMenuItem)
        statisticsOverviewEmployeeMenuItem.onClick = {
            val statistics = dataService.getEmployeeStatistics()
            outputHandler.printlnStatistic(statistics)
            outputHandler.printSuccess()
        }

        menu.add(searchEmployeeByNameMenuItem)
        searchEmployeeByNameMenuItem.onClick = {
            outputHandler.print("Nhập tên nhân viên cần tìm: ")
            val name = inputHandler.readString()
            val employee = dataService.searchEmployeeByName(name)
            if (employee != null) {
                outputHandler.print(employee)
            } else {
                outputHandler.print("Không tìm thấy nhân viên với tên: $name")
            }
        }

        menu.add(addEmployeeMenuItem)
        addEmployeeMenuItem.onClick = {
            navigate(AddEmployeeScreen())
        }
    }
}

private val backMenuItem = MenuItem("BACK")
private val statisticsOverviewEmployeeMenuItem = MenuItem("THONG KE TONG QUAN NHAN VIEN")
private val searchEmployeeByNameMenuItem = MenuItem("TIM KIEM NHAN VIEN THEO TEN")
private val addEmployeeMenuItem = MenuItem("THEM NHAN VIEN MOI")