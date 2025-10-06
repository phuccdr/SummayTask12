package com.eco.summaytask12.data.service

import com.eco.summaytask12.data.model.project.Project
import com.eco.summaytask12.utils.InputHandlerUtil
import com.eco.summaytask12.utils.LoggerUtil

class CreateProjectService {
    private val inputHandler = InputHandlerUtil

    // Tao project co ban
    fun createProject(): Project {
        LoggerUtil.d("CreateProject", "=== THEM PROJECT MOI ===")
        LoggerUtil.d("CreateProject", "Nhap ten project:")
        val name = inputHandler.readString()
        LoggerUtil.d("CreateProject", "Nhap mo ta project:")
        val description = inputHandler.readString()
        LoggerUtil.d("CreateProject", "Nhap thoi gian uoc tinh (thang):")
        val estimateTimeMonth = inputHandler.readDouble().toFloat()

        return Project.createProject(
            name = name,
            description = description,
            estimateTimeMonth = estimateTimeMonth
        )
    }

}