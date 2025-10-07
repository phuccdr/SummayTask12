package com.eco.summaytask12.model.device

data class Device(
    val deviceName: String,
    val osVersion: String,
    val screenSize: Double,
    val ram: Int,
    val storage: Int,
    val isEnable: Boolean
)
