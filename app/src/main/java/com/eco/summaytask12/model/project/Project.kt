package com.eco.summaytask12.model.project

import java.util.Date

data class Project(
    val name: String,
    val description: String,
    val startDate: Date = Date(),
    val estimateTimeMonth: Float,
    var endDateActual: Date? = null,
    var progress: Float
) {
    val isCompleted: Boolean get() = progress >= 100
    fun getStatus(): StatusProject {
        return when (this.progress) {
            0f -> StatusProject.NOT_STARTED
            100f -> StatusProject.COMPLETED
            else -> StatusProject.IN_PROGRESS
        }
    }

    companion object {
        fun createProject(
            name: String, description: String = "", estimateTimeMonth: Float
        ): Project {
            return Project(
                name = name,
                description = description,
                estimateTimeMonth = estimateTimeMonth,
                progress = 0f
            )
        }
    }
}
