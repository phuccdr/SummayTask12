package com.eco.summaytask12.menu.screen.addemployee

import com.eco.summaytask12.di.AppModule
import com.eco.summaytask12.menu.menuitem.MenuItem
import com.eco.summaytask12.menu.screen.Screen
import com.eco.summaytask12.data.services.DataService
import com.eco.summaytask12.handler.input.InputHandlerEmployeeExt

/**
 * AddEmployeeScreen - Màn hình thêm nhân viên
 * Sử dụng Dependency Injection: nhận dependencies từ AppModule
 */
class AddEmployeeScreen(
    private val dataService: DataService = AppModule.provideDataService(),
    private val employeeService: InputHandlerEmployeeExt = InputHandlerEmployeeExt(inputHandler = AppModule.provideInputHandler())
) : Screen() {
    override fun createMenu() {
        menu.add(backMenuItem)
        backMenuItem.onClick = {
            back()
        }

        menu.add(addEmployeeDefaultMenuItem)
        addEmployeeDefaultMenuItem.onClick = {
            addEmployeeDefault()
        }

        menu.add(addManagerMenuItem)
        addManagerMenuItem.onClick = {
            addManager()
        }

        menu.add(addAndroidDeveloperMenuItem)
        addAndroidDeveloperMenuItem.onClick = {
            addAndroidDeveloper()
        }

        menu.add(addBackendDeveloperMenuItem)
        addBackendDeveloperMenuItem.onClick = {
            addBackendDeveloper()
        }
    }

    private fun addEmployeeDefault() {
        val employeeData = employeeService.createEmployee()
        dataService.addEmployee(employeeData)
        outputHandler.printSuccess()
    }

    private fun addManager() {
        val managerData = employeeService.createManager()
        dataService.addEmployee(managerData)
        outputHandler.printSuccess()
    }

    private fun addAndroidDeveloper() {
        val androidDeveloper = employeeService.createAndroidDeveloper()
        dataService.addEmployee(androidDeveloper)
        outputHandler.printSuccess()
    }

    private fun addBackendDeveloper() {
        val backendDeveloper = employeeService.createBackendDeveloper()
        dataService.addEmployee(backendDeveloper)
        outputHandler.printSuccess()
    }
}

private val backMenuItem = MenuItem("QUAY LAI")
private val addEmployeeDefaultMenuItem = MenuItem("THEM NHAN VIEN THUONG")
private val addManagerMenuItem = MenuItem("THEM MANAGER")
private val addAndroidDeveloperMenuItem = MenuItem("THEM ANDROID DEVELOPER")
private val addBackendDeveloperMenuItem = MenuItem("THEM BACKEND DEVELOPER")