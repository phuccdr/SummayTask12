package com.eco.summaytask12.menu.screen

import com.eco.summaytask12.menu.MenuItem
import com.eco.summaytask12.menu.Screen
import com.eco.summaytask12.utils.LoggerUtil

/**
 * Dai dien cho chu nang them Employee
 * Xu ly logic khi nguoi dung chon cac item trong menu khi dang thu hien chuc nang them Employee
 */
val addEmployeeDefaultMenuItem = MenuItem("THEM NHAN VIEN", execute = {
    try {
        val employee = employeeService.createEmployee()
        dataService.addEmployees(listOf(employee))
        LoggerUtil.d("AddEmployee", "Da them nhan vien thanh cong: ${employee.name}")
    } catch (e: Exception) {
        LoggerUtil.e("AddEmployee", e)
    }
})
val addManagerMenuItem = MenuItem("THEM MANAGER", execute = {
    try {
        val manager = employeeService.createManager()
        dataService.addEmployees(listOf(manager))
        LoggerUtil.d("AddManager", "Da them manager thanh cong: ${manager.name}")
    } catch (e: Exception) {
        LoggerUtil.e("AddManager", e)
    }
})
val addAndroidDevMenuItem = MenuItem("THEM ANDROID DEVELOPER", execute = {
    try {
        val androidDev = employeeService.createAndroidDeveloper()
        dataService.addEmployees(listOf(androidDev))
        LoggerUtil.d("AddAndroidDev", "Da them Android Developer thanh cong: ${androidDev.name}")
    } catch (e: Exception) {
        LoggerUtil.e("AddAndroidDev", e)
    }
})
val addBackendDevMenuItem = MenuItem("THEM BACKEND DEVELOPER", execute = {
    try {
        val backendDev = employeeService.createBackendDeveloper()
        dataService.addEmployees(listOf(backendDev))
        LoggerUtil.d("AddBackendDev", "Da them Backend Developer thanh cong: ${backendDev.name}")
    } catch (e: Exception) {
        LoggerUtil.e("AddBackendDev", e)
    }
})
val addInternAndroidMenuItem = MenuItem("THEM INTERN ANDROID DEVELOPER", execute = {
    try {
        val intern = employeeService.createInternAndroidDeveloper()
        dataService.addEmployees(listOf(intern))
        LoggerUtil.d("AddIntern", "Da them Intern Android Developer thanh cong: ${intern.name}")
    } catch (e: Exception) {
        LoggerUtil.e("AddIntern", e)
    }
})
val addEmployeeScreen = Screen(
    "AddEmployee", listOf(
        backMenuItem,
        addEmployeeDefaultMenuItem,
        addManagerMenuItem,
        addAndroidDevMenuItem,
        addBackendDevMenuItem,
        addInternAndroidMenuItem
    )
)