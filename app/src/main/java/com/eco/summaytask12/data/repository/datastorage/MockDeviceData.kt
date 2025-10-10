package com.eco.summaytask12.data.repository.datastorage

import com.eco.summaytask12.data.model.device.Device

class MockDeviceData {
    val devices = mutableListOf(
        Device(
            deviceName = "Samsung Galaxy S24 Ultra",
            osVersion = "Android 14",
            screenSize = 6.8,
            ram = 12,
            storage = 512,
            isEnable = true
        ), Device(
            deviceName = "Google Pixel 8 Pro",
            osVersion = "Android 14",
            screenSize = 6.7,
            ram = 12,
            storage = 256,
            isEnable = true
        ), Device(
            deviceName = "OnePlus 12 Pro",
            osVersion = "Android 14",
            screenSize = 6.82,
            ram = 16,
            storage = 512,
            isEnable = true
        ), Device(
            deviceName = "Xiaomi 14 Ultra",
            osVersion = "Android 14",
            screenSize = 6.73,
            ram = 16,
            storage = 512,
            isEnable = true
        ), Device(
            deviceName = "iPhone 15 Pro Max",
            osVersion = "iOS 17.2",
            screenSize = 6.7,
            ram = 8,
            storage = 512,
            isEnable = true
        ), Device(
            deviceName = "Samsung Galaxy A54",
            osVersion = "Android 13",
            screenSize = 6.4,
            ram = 8,
            storage = 256,
            isEnable = true
        ), Device(
            deviceName = "Google Pixel 7a",
            osVersion = "Android 14",
            screenSize = 6.1,
            ram = 8,
            storage = 128,
            isEnable = true
        ), Device(
            deviceName = "Xiaomi Redmi Note 13 Pro",
            osVersion = "Android 13",
            screenSize = 6.67,
            ram = 8,
            storage = 256,
            isEnable = true
        ), Device(
            deviceName = "OnePlus Nord 3",
            osVersion = "Android 13",
            screenSize = 6.74,
            ram = 12,
            storage = 256,
            isEnable = true
        ), Device(
            deviceName = "iPhone 14",
            osVersion = "iOS 17.1",
            screenSize = 6.1,
            ram = 6,
            storage = 256,
            isEnable = true
        ), Device(
            deviceName = "Realme 12 Pro+",
            osVersion = "Android 14",
            screenSize = 6.7,
            ram = 8,
            storage = 256,
            isEnable = true
        ), Device(
            deviceName = "Samsung Galaxy A15",
            osVersion = "Android 13",
            screenSize = 6.5,
            ram = 4,
            storage = 128,
            isEnable = true
        ), Device(
            deviceName = "Xiaomi Redmi 13C",
            osVersion = "Android 13",
            screenSize = 6.74,
            ram = 4,
            storage = 128,
            isEnable = true
        ), Device(
            deviceName = "Realme C55",
            osVersion = "Android 13",
            screenSize = 6.72,
            ram = 6,
            storage = 128,
            isEnable = true
        ), Device(
            deviceName = "Oppo A78",
            osVersion = "Android 13",
            screenSize = 6.56,
            ram = 8,
            storage = 256,
            isEnable = true
        ), Device(
            deviceName = "Samsung Galaxy S20",
            osVersion = "Android 12",
            screenSize = 6.2,
            ram = 8,
            storage = 128,
            isEnable = true
        ), Device(
            deviceName = "iPhone 12",
            osVersion = "iOS 16.5",
            screenSize = 6.1,
            ram = 4,
            storage = 128,
            isEnable = true
        ), Device(
            deviceName = "Xiaomi Mi 11",
            osVersion = "Android 12",
            screenSize = 6.81,
            ram = 8,
            storage = 256,
            isEnable = false
        ), Device(
            deviceName = "Samsung Galaxy S10",
            osVersion = "Android 11",
            screenSize = 6.1,
            ram = 8,
            storage = 128,
            isEnable = false
        ), Device(
            deviceName = "iPhone X",
            osVersion = "iOS 16.0",
            screenSize = 5.8,
            ram = 3,
            storage = 64,
            isEnable = false
        ), Device(
            deviceName = "Huawei P30 Pro",
            osVersion = "Android 10",
            screenSize = 6.47,
            ram = 8,
            storage = 256,
            isEnable = false
        )
    )
    val enabledDevices: List<Device>
        get() = devices.filter { it.isEnable }
    val disabledDevices: List<Device>
        get() = devices.filter { !it.isEnable }
    val androidDevices: List<Device>
        get() = devices.filter { it.osVersion.startsWith("Android", ignoreCase = true) }
    val iosDevices: List<Device>
        get() = devices.filter { it.osVersion.startsWith("iOS", ignoreCase = true) }
    val highEndDevices: List<Device>
        get() = devices.filter { it.ram >= 12 && it.storage >= 256 }
    val midRangeDevices: List<Device>
        get() = devices.filter { it.ram in 6..11 && it.storage >= 128 }
    val budgetDevices: List<Device>
        get() = devices.filter { it.ram <= 6 && it.storage <= 128 }
}