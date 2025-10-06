package com.eco.summaytask12.menu.screen

import com.eco.summaytask12.menu.MenuItem
import com.eco.summaytask12.menu.Screen
import com.eco.summaytask12.utils.LoggerUtil

/**
 * Dai dien cho chu nang thong ke tong quan
 */
val introductionMenuItem = MenuItem("GIOI THIEU", execute = {
    val introduction = dataService.getIntroduction()
    LoggerUtil.d("Introduction", """
               GIOI THIEU VE CONG TY
        Ten cong ty: ${introduction["companyName"]}
        CO DONG:
        ${(introduction["shareholders"] as List<*>).joinToString("\n") { shareholder ->
            val sh = shareholder as com.eco.summaytask12.data.model.shareholder.ShareHolder
            "  - ${sh.name} | Co phan: ${sh.sharesOwned}% | ${sh.vision}" }}
        THONG KE NHAN VIEN:
        ${(introduction["introduction"])}
    """.trimIndent())
})
val overviewStatisticsMenuItem = MenuItem("BAO CAO TONG QUAN", execute = {
    val statistics = dataService.getOverviewStatistics()
    LoggerUtil.d("OverviewStatistics", """
        BAO CAO TONG QUAN
        --- THONG KE NHAN VIEN ---
        ${(statistics["statisticsEmployee"] as Map<*, *>).entries.joinToString("\n") {
            "  ${it.key}: ${it.value}"
        }}
        --- THONG KE PROJECT ---
        ${(statistics["statisticsProject"] as Map<*, *>).entries.joinToString("\n") {
            "  ${it.key}: ${it.value}" }}
    """.trimIndent())
})
val statisticsOverviewScreen =
    Screen("Statistics", listOf(backMenuItem, introductionMenuItem, overviewStatisticsMenuItem))