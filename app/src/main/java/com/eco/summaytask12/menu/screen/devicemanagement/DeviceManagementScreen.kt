package com.eco.summaytask12.menu.screen.devicemanagement

import com.eco.summaytask12.model.menuitem.MenuItem
import com.eco.summaytask12.model.screen.Screen
import com.eco.summaytask12.services.DataService

class DeviceManagementScreen : Screen() {
    private val dataService = DataService()
    override fun createMenu() {
        menu.add(backMenuItem)
        backMenuItem.onClick = {
            back()
        }

        menu.add(deviceStatisticsMenuItem)
        deviceStatisticsMenuItem.onClick = {
            val statistics = dataService.getDeviceStatistics()
            outputHandler.printlnStatistic(statistics)
        }

        menu.add(searchDeviceByNameMenuItem)
        searchDeviceByNameMenuItem.onClick = {
            outputHandler.print("Nhập tên thiết bị cần tìm: ")
            val deviceName = inputHandler.readString()
            val devices = dataService.searchDevicesByName(deviceName)
            if (devices.isNotEmpty()) {
                outputHandler.print("=== KẾT QUẢ TÌM KIẾM ===")
                devices.forEach { device ->
                    outputHandler.print(device.toString())
                }
            } else {
                outputHandler.print("Không tìm thấy thiết bị với tên: $deviceName")
            }
        }

        menu.add(deleteDeviceMenuItem)
        deleteDeviceMenuItem.onClick = onClick@{
            val devices = dataService.getAllDevices()
            if (devices.isEmpty()) {
                outputHandler.print("Không có thiết bị nào để xóa.")
                return@onClick
            }

            outputHandler.print("=== DANH SÁCH THIẾT BỊ ===")
            outputHandler.printlnList(devices)

            outputHandler.print("Nhập số thứ tự thiết bị cần xóa (1-${devices.size}): ")
            val indexInput = inputHandler.readInt()

            try {
                val selectedIndex = indexInput - 1
                if (selectedIndex in 0 until devices.size) {
                    val selectedDevice = devices[selectedIndex]
                    outputHandler.print("Bạn có chắc chắn muốn xóa thiết bị '${selectedDevice.deviceName}'? (Y/N): ")
                    val confirmation = inputHandler.readString()
                    if (confirmation.uppercase() == "Y" || confirmation.uppercase() == "YES") {
                        val result = dataService.deleteDevice(selectedDevice.deviceName)
                        outputHandler.print(result)
                    } else {
                        outputHandler.print("Đã hủy việc xóa thiết bị")
                    }
                } else {
                    outputHandler.print("Số thứ tự không hợp lệ. Vui lòng chọn từ 1 đến ${devices.size}")
                }
            } catch (e: NumberFormatException) {
                outputHandler.print("Vui lòng nhập một số hợp lệ.")
            }
        }
    }
}

private val backMenuItem = MenuItem("BACK")
private val deviceStatisticsMenuItem = MenuItem("THONG KE THIET BI")
private val searchDeviceByNameMenuItem = MenuItem("TIM KIEM THIET BI THEO TEN")
private val deleteDeviceMenuItem = MenuItem("XOA THIET BI")