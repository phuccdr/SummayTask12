package com.eco.summaytask12.data.repository

import com.eco.summaytask12.data.mock.MockProjectData
import com.eco.summaytask12.data.model.project.Project
import java.util.Date
import java.util.Locale

class ProjectRepository {
    private val mockProjects: MutableList<Project> = MockProjectData.projects

    fun getAllProjects(): List<Project> {
        return mockProjects
    }

     fun getCompletedProjects(): List<Project> {
        val completed = mockProjects.filter { it.isCompleted }
        return completed
    }

     fun getInProgressProjects(): List<Project> {
        val inProgress = mockProjects.filter { it.progress > 0 && it.progress < 100 }
        return inProgress
    }

     fun getNotStartedProjects(): List<Project> {
        val notStarted = mockProjects.filter { it.progress == 0f }
        return notStarted
    }

    fun searchProjectByName(name: String): Project? {
        return mockProjects.find { it.name.equals(name, ignoreCase = true) }
    }

     fun getStatistics(): Map<String, Any> {
        println("Calculating project statistics...")
        val totalProjects = mockProjects.size
        val completedProjects = mockProjects.count { it.isCompleted }
        val inProgressProjects = mockProjects.count { it.progress > 0 && it.progress < 100 }
        val notStartedProjects = mockProjects.count { it.progress == 0f }
        val totalEstimatedMonths = mockProjects.sumOf { it.estimateTimeMonth.toDouble() }
        val averageEstimatedTime = totalEstimatedMonths / totalProjects
        val stats = mapOf<String, Any>(
            "totalProjects" to totalProjects,
            "completedProjects" to completedProjects,
            "inProgressProjects" to inProgressProjects,
            "notStartedProjects" to notStartedProjects,
            "completionRate" to String.format(
                Locale.getDefault(),
                "%.2f",
                (completedProjects.toDouble() / totalProjects) * 100
            ),
            "averageEstimatedTime" to String.format(
                Locale.getDefault(),
                "%.2f",
                averageEstimatedTime
            ),
        )
        return stats
    }

    // Them project vao danh sach
    fun addProjects(projects: List<Project>) {
        mockProjects.addAll(projects)
    }

}