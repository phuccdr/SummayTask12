package com.eco.summaytask12.data.repository

import com.eco.summaytask12.data.model.device.Device
import com.eco.summaytask12.data.repository.datastorage.MockDeviceData
import java.util.Locale

class DeviceRepository( mockDevicesData: MockDeviceData) {
    private val mockDevices: MutableList<Device> = mockDevicesData.devices
    fun getAllDevices(): List<Device> {
        return mockDevices
    }

    fun getDeviceByIndex(index: List<Int>): List<Device> {
        val devices = mutableListOf<Device>()
        index.filter { it in 0 until mockDevices.size }
        index.forEach {
            devices.add(mockDevices[it])
        }
        return devices
    }

    fun searchDevicesByName(deviceName: String): List<Device> {
        return mockDevices.filter { it.deviceName.equals(deviceName, ignoreCase = true) }
    }

    // ========== SEARCH METHODS ==========
    fun searchDeviceByName(name: String): Device? {
        return mockDevices.find { it.deviceName.equals(name, ignoreCase = true) }
    }

    fun removeDevice(deviceName: String): Boolean {
        val device = searchDeviceByName(deviceName)
        return if (device != null) {
            mockDevices.remove(device)
        } else {
            false
        }
    }

    // ========== STATISTICS ==========
    fun getStatistics(): Map<String, Any> {
        val totalDevices = mockDevices.size
        val enabledDevices = mockDevices.count { it.isEnable }
        val disabledDevices = mockDevices.count { !it.isEnable }
        val androidDevices =
            mockDevices.count { it.osVersion.startsWith("Android", ignoreCase = true) }
        val iosDevices = mockDevices.count { it.osVersion.startsWith("iOS", ignoreCase = true) }
        val highEndDevices = mockDevices.count { it.ram >= 12 && it.storage >= 256 }
        val midRangeDevices = mockDevices.count { it.ram in 6..11 && it.storage >= 128 }
        val budgetDevices = mockDevices.count { it.ram <= 6 && it.storage <= 128 }

        return mapOf(
            "totalDevices" to totalDevices,
            "enabledDevices" to enabledDevices,
            "disabledDevices" to disabledDevices,
            "androidDevices" to androidDevices,
            "iosDevices" to iosDevices,
            "highEndDevices" to highEndDevices,
            "midRangeDevices" to midRangeDevices,
            "budgetDevices" to budgetDevices,
            "enabledPercentage" to String.format(
                Locale.getDefault(), "%.2f", (enabledDevices.toDouble() / totalDevices) * 100
            ),
            "androidPercentage" to String.format(
                Locale.getDefault(), "%.2f", (androidDevices.toDouble() / totalDevices) * 100
            ),
            ("All device:\n" to mockDevices.sortedBy { it.osVersion })
        )
    }


}