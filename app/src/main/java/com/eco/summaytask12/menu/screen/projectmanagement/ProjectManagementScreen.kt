package com.eco.summaytask12.menu.screen.projectmanagement

import com.eco.summaytask12.handler.InputHandler
import com.eco.summaytask12.model.menuitem.MenuItem
import com.eco.summaytask12.model.screen.Screen
import com.eco.summaytask12.services.DataService
import com.eco.summaytask12.utils.CreateProjectUtil

class ProjectManagementScreen : Screen() {
    private val dataService = DataService()
    private val projectService = CreateProjectUtil(InputHandler())
    override fun createMenu() {
        menu.add(backMenuItem)
        backMenuItem.onClick = {
            back()
        }

        menu.add(statisticsOverViewProjectMenuItem)
        statisticsOverViewProjectMenuItem.onClick = {
            val statistics = dataService.getProjectStatistics()
            outputHandler.printlnStatistic(statistics)
            outputHandler.printSuccess()
        }

        menu.add(updateProcessProjectMenuItem)
        updateProcessProjectMenuItem.onClick = onClick@{
            val projects = dataService.getAllProjects()
            if (projects.isEmpty()) {
                outputHandler.print("Không có dự án nào để cập nhật.")
                return@onClick
            }

            outputHandler.print("=== DANH SÁCH DỰ ÁN ===")
            outputHandler.printlnList(projects)

            outputHandler.print("Nhập số thứ tự dự án cần cập nhật tiến độ (1-${projects.size}): ")
            val indexInput = inputHandler.readIndex(projects.size)
            val selectedProject = projects[indexInput - 1]
            outputHandler.print("Dự án hiện tại: ${selectedProject.name} - Tiến độ: ${selectedProject.progress}%")
            outputHandler.print("Nhập tiến độ mới (0-100): ")
            val progress = inputHandler.readProgress()
            dataService.updateProjectProgress(indexInput - 1, progress)
            outputHandler.printSuccess()
        }

        menu.add(addProjectMenuItem)
        addProjectMenuItem.onClick = {
            val newProject = projectService.createProject()
            dataService.addProjects(listOf(newProject))
            outputHandler.printSuccess()
        }

        menu.add(managerStatisticProgressProjectMenuItem)
        managerStatisticProgressProjectMenuItem.onClick = {
            val managers = dataService.getAllManagers()
            managers.forEach {
                outputHandler.print("Manager: ${it.name}")
                outputHandler.printlnStatistic(it.getStatistics())
            }
            outputHandler.printSuccess()
        }

        menu.add(showProjectCompletedMenuItem)
        showProjectCompletedMenuItem.onClick = {
            val completedProjects = dataService.getCompletedProjects()
            outputHandler.printlnList(completedProjects)
            outputHandler.printSuccess()
        }
    }
}

private val backMenuItem = MenuItem("BACK")
private val statisticsOverViewProjectMenuItem = MenuItem("THONG KE TONG QUAN DU AN")
private val updateProcessProjectMenuItem = MenuItem("CAP NHAT TIEN DO DU AN")
private val addProjectMenuItem = MenuItem("THEM DU AN MOI")
private val managerStatisticProgressProjectMenuItem = MenuItem("THONG KE TIEN DO DU AN")
private val showProjectCompletedMenuItem = MenuItem("HIEN THI DU AN HOAN THANH")