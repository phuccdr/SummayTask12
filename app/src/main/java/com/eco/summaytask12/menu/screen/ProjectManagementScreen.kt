package com.eco.summaytask12.menu.screen

import com.eco.summaytask12.menu.MenuActionType
import com.eco.summaytask12.menu.MenuItem
import com.eco.summaytask12.menu.Screen
import com.eco.summaytask12.utils.LoggerUtil

/**
 * Dai dien cho chu nang quan ly project
 */
val listAllProjectsMenuItem = MenuItem("DANH SACH TAT CA PROJECT", execute = {
    val projects = dataService.getAllProjects()
    LoggerUtil.d(
        "ListAllProjects", """
        DANH SACH TAT CA PROJECT
        Tong so project: ${projects.size}
        ${
            projects.mapIndexed { index, project ->
                "  ${index + 1}. ${project.name}\n     Mo ta: ${project.description}\n     Tien do: ${project.progress}% | Thoi gian uoc tinh: ${project.estimateTimeMonth} thang"
            }.joinToString("\n")
        }
        
    """.trimIndent()
    )
})
val listCompletedProjectsMenuItem = MenuItem("DANH SACH PROJECT HOAN THANH", execute = {
    val completedProjects = dataService.getCompletedProjects()
    LoggerUtil.d(
        "ListCompletedProjects", """
        DANH SACH PROJECT HOAN THANH
        Tong so project hoan thanh: ${completedProjects.size}
        ${
            completedProjects.mapIndexed { index, project ->
                "  ${index + 1}. ${project.name}\n     Mo ta: ${project.description}\n     Tien do: ${project.progress}%"
            }.joinToString("\n")
        }
    """.trimIndent()
    )
})
val listInProgressProjectsMenuItem = MenuItem("DANH SACH PROJECT DANG THUC HIEN", execute = {
    val inProgressProjects = dataService.getInProgressProjects()
    LoggerUtil.d(
        "ListInProgressProjects", """
        DANH SACH PROJECT DANG THUC HIEN
        Tong so project dang thuc hien: ${inProgressProjects.size}
        ${
            inProgressProjects.mapIndexed { index, project ->
                "  ${index + 1}. ${project.name}\n     Mo ta: ${project.description}\n     Tien do: ${project.progress}% | Thoi gian uoc tinh: ${project.estimateTimeMonth} thang"
            }.joinToString("\n")
        }
    """.trimIndent()
    )
})
val listNotStartedProjectsMenuItem = MenuItem("DANH SACH PROJECT CHUA BAT DAU", execute = {
    val notStartedProjects = dataService.getNotStartedProjects()
    LoggerUtil.d(
        "ListNotStartedProjects", """
        DANH SACH PROJECT CHUA BAT DAU
        Tong so project chua bat dau: ${notStartedProjects.size}
        ${
            notStartedProjects.mapIndexed { index, project ->
                "  ${index + 1}. ${project.name}\n     Mo ta: ${project.description}\n     Tien do: ${project.progress}% | Thoi gian uoc tinh: ${project.estimateTimeMonth} thang"
            }.joinToString("\n")
        }
        
    """.trimIndent()
    )
})
val searchProjectByNameMenuItem = MenuItem("TIM KIEM PROJECT THEO TEN", execute = {
    LoggerUtil.d("SearchProject", "Nhap ten project can tim:")
    try {
        val name = com.eco.summaytask12.utils.InputHandlerUtil.readString()
        val project = dataService.searchProjectByName(name)
        if (project != null) {
            LoggerUtil.d(
                "SearchProject", """
                THONG TIN PROJECT
                Ten: ${project.name}
                Mo ta: ${project.description}
                Tien do: ${project.progress}%
                Thoi gian uoc tinh: ${project.estimateTimeMonth} thang
                Trang thai: ${project.getStatus()}
                
            """.trimIndent()
            )
        } else {
            LoggerUtil.d("SearchProject", "Khong tim thay project voi ten: $name")
        }
    } catch (e: Exception) {
        LoggerUtil.e("SearchProject", e)
    }
})
val projectStatisticsMenuItem = MenuItem("THONG KE PROJECT", execute = {
    val statistics = dataService.getStatisticsProject()
    LoggerUtil.d(
        "ProjectStatistics", """
        THONG KE PROJECT
        ${statistics.entries.joinToString("\n") { "  ${it.key}: ${it.value}" }}
        
    """.trimIndent()
    )
})


val addProjectMenuItem = MenuItem("THEM PROJECT MOI", execute = {
    try {
        val project = projectService.createProject()
        dataService.addProjects(listOf(project))
        LoggerUtil.d("AddProject", "Da them project thanh cong: ${project.name}")
    } catch (e: Exception) {
        LoggerUtil.e("AddProject", e)
    }
})




val managerProjectReportMenuItem = MenuItem("BAO CAO PROJECT CUA MANAGER", execute = {
    LoggerUtil.d("ManagerReport", "Chon manager de xem bao cao:")
    try {
        val managers = dataService.getAllManagers()
        if (managers.isEmpty()) {
            LoggerUtil.d("ManagerReport", "Khong co manager nao trong he thong!")
            return@MenuItem
        }

        LoggerUtil.d("ManagerReport", """
            DANH SACH MANAGER
            ${
            managers.mapIndexed { index, manager ->
                "  ${index + 1}. ${manager.name} | Phong ban: ${manager.department}"
            }.joinToString("\n")
        }
        """.trimIndent())
        LoggerUtil.d("ManagerReport", "Nhap STT manager:")
        val choice = com.eco.summaytask12.utils.InputHandlerUtil.readInt()

        if (choice in 1..managers.size) {
            val selectedManager = managers[choice - 1]
            val statistics = selectedManager.getStatistics()
            val projectProcess = selectedManager.checkProjectProcess()

            LoggerUtil.d("ManagerReport", """
                BAO CAO CUA MANAGER: ${selectedManager.name}
                Phong ban: ${selectedManager.department}
                Tong so project quan ly: ${selectedManager.projects.size}
                BAO CAO THEO TRANG THAI:
                ${
                statistics.entries.joinToString("\n") { (status, projects) ->
                    "  ${status}: ${projects.size} project"
                }
            }
                BAO CAO THEO TIEN DO:
                ${
                projectProcess.entries.joinToString("\n") { (status, projects) ->
                    "  ${status}: ${projects?.size ?: 0} project"
                }
            }
                CHI TIET PROJECT:
                ${
                selectedManager.projects.mapIndexed { index, project ->
                    "  ${index + 1}. ${project.name} | Tien do: ${project.progress}% | Trang thai: ${project.getStatus()}"
                }.joinToString("\n")
            }
            """.trimIndent())
        } else {
            LoggerUtil.d("ManagerReport", "Lua chon khong hop le!")
        }
    } catch (e: Exception) {
        LoggerUtil.e("ManagerReport", e)
    }
})

val managerStatisticsOverviewMenuItem = MenuItem("TONG QUAN BAO CAO MANAGER", execute = {
    val managers = dataService.getAllManagers()
    LoggerUtil.d("ManagerStatistics", """
        TONG QUAN BAO CAO TAT CA MANAGER
        Tong so manager: ${managers.size}
        ${
        managers.mapIndexed { index, manager ->
            val totalProjects = manager.projects.size
            val completedProjects = manager.projects.count { it.isCompleted }
            val inProgressProjects = manager.projects.count { it.progress > 0 && it.progress < 100 }
            val notStartedProjects = manager.projects.count { it.progress == 0f }

            """  ${index + 1}. MANAGER: ${manager.name}
     Phong ban: ${manager.department}
     Tong project: $totalProjects
     Hoan thanh: $completedProjects | Dang thuc hien: $inProgressProjects | Chua bat dau: $notStartedProjects"""
        }.joinToString("\n")
    }
    """.trimIndent())
})

val managerReportsScreen = Screen(
    "ManagerReports",
    listOf(
        backMenuItem,
        managerProjectReportMenuItem,
        managerStatisticsOverviewMenuItem
    )
)

val managerReportsMenuItem = MenuItem(
    "BAO CAO CUA MANAGER",
    actionType = MenuActionType.NAVIGATE,
    navigateScreen = managerReportsScreen
)
val projectManagementScreen = Screen(
    "ProjectManagement", listOf(
        backMenuItem,
        listAllProjectsMenuItem,
        listCompletedProjectsMenuItem,
        listInProgressProjectsMenuItem,
        listNotStartedProjectsMenuItem,
        searchProjectByNameMenuItem,
        addProjectMenuItem,
        projectStatisticsMenuItem
    )
)