package com.eco.summaytask12.di

import com.eco.summaytask12.data.repository.DeviceRepository
import com.eco.summaytask12.data.repository.EmployeeRepository
import com.eco.summaytask12.data.repository.ProjectRepository
import com.eco.summaytask12.data.repository.datastorage.MockDeviceData
import com.eco.summaytask12.data.repository.datastorage.MockEmployeeData
import com.eco.summaytask12.data.repository.datastorage.MockProjectData
import com.eco.summaytask12.data.services.DataService
import com.eco.summaytask12.handler.input.InputHandler
import com.eco.summaytask12.handler.OutputHandler

/**
 * AppModule - Dependency Injection Container
 *
 * Quản lý tất cả dependencies như singleton để:
 * - Giảm số lượng objects được tạo ra (tăng hiệu suất)
 * - Dễ dàng test và maintain
 * - Tránh việc tạo nhiều instances không cần thiết
 */
object AppModule {
    private val mockProjectData: MockProjectData by lazy {
        MockProjectData()
    }
    private val mockDeviceData: MockDeviceData by lazy {
        MockDeviceData()
    }
    private val mockEmployeeData: MockEmployeeData by lazy {
        MockEmployeeData(mockProjectData, mockDeviceData)
    }
    private val employeeRepository: EmployeeRepository by lazy {
        EmployeeRepository(mockEmployeeData)
    }
    private val projectRepository: ProjectRepository by lazy {
        ProjectRepository(mockProjectData)
    }
    private val deviceRepository: DeviceRepository by lazy {
        DeviceRepository(
            mockDeviceData,
        )
    }
    private val dataService: DataService by lazy {
        DataService(
            employeeRepository = employeeRepository,
            projectRepository = projectRepository,
            deviceRepository = deviceRepository
        )
    }
    private val inputHandler: InputHandler by lazy {
        InputHandler()
    }
    private val outputHandler: OutputHandler by lazy {
        OutputHandler()
    }

    fun provideDataService(): DataService = dataService

    fun provideInputHandler(): InputHandler = inputHandler

    fun provideOutputHandler(): OutputHandler = outputHandler


}

