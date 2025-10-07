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
            outputHandler.run {
                printlnStatistic(statistics)
                printSuccess()
            }
            }

        menu.add(searchDeviceByNameMenuItem)
        searchDeviceByNameMenuItem.onClick = {
            outputHandler.print("Nhap ten thiet bi can tim: ")
            val deviceName = inputHandler.readString()
            val devices = dataService.searchDevicesByName(deviceName)
            if (devices.isNotEmpty()) {
                outputHandler.print("=== KẾT QUẢ TÌM KIẾM ===")
                devices.forEach { device ->
                    outputHandler.print(device.toString())
                }
                outputHandler.printSuccess()
            } else {
                outputHandler.print("Khong tim thay thiet bi voi ten: $deviceName")
            }
        }

        menu.add(deleteDeviceMenuItem)
        deleteDeviceMenuItem.onClick = onClick@{
            val devices = dataService.getAllDevices()
            if (devices.isEmpty()) {
                outputHandler.print("Khong co thiet bi nao de xoa.")
                return@onClick
            }

            outputHandler.print("=== DANH SACH THIET BI ===")
            outputHandler.printlnList(devices)

            outputHandler.print("Nhap so thu tu thiet bi can xoa (1-${devices.size}): ")
            val indexInput = inputHandler.readInt()

            try {
                val selectedIndex = indexInput - 1
                if (selectedIndex in 0 until devices.size) {
                    val selectedDevice = devices[selectedIndex]
                    outputHandler.print("Ban co chac chan muon xoa thiet bi '${selectedDevice.deviceName}'? (Y/N): ")
                    val confirmation = inputHandler.readString()
                    if (confirmation.uppercase() == "Y" || confirmation.uppercase() == "YES") {
                        dataService.deleteDevice(selectedDevice.deviceName)
                        outputHandler.printSuccess()
                    } else {
                        outputHandler.print("Da huy viec xoa thiet bi")
                    }
                } else {
                    outputHandler.print("So thu tu khong hop le. Vui long chon tu 1 den ${devices.size}")
                }
            } catch (e: NumberFormatException) {
                outputHandler.print("Vui long nhap mot so hop le.")
            }
        }
    }
}

private val backMenuItem = MenuItem("BACK")
private val deviceStatisticsMenuItem = MenuItem("THONG KE THIET BI")
private val searchDeviceByNameMenuItem = MenuItem("TIM KIEM THIET BI THEO TEN")
private val deleteDeviceMenuItem = MenuItem("XOA THIET BI")