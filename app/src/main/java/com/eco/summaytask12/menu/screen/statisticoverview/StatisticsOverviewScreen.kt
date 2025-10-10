package com.eco.summaytask12.menu.screen.statisticoverview

import com.eco.summaytask12.di.AppModule
import com.eco.summaytask12.menu.menuitem.MenuItem
import com.eco.summaytask12.menu.screen.Screen
import com.eco.summaytask12.data.services.DataService

/**
 * StatisticsOverviewScreen - Màn hình thống kê tổng quan
 * Sử dụng Dependency Injection: nhận DataService từ AppModule
 */
class StatisticsOverviewScreen(
    private val dataService: DataService = AppModule.provideDataService()
) : Screen() {
    override fun createMenu() {
        menu.add(backMenuItem)
        backMenuItem.onClick = {
            back()
        }
        menu.add(introductionsCompanyMenuItem)
        introductionsCompanyMenuItem.onClick = {
            val statistics = dataService.getIntroduction()
            outputHandler.printlnStatistic(statistics)
            outputHandler.printSuccess()
        }

        menu.add(statisticsOverViewMenuItem)
        statisticsOverViewMenuItem.onClick = {
            val statistics = dataService.getOverviewStatistics()
            outputHandler.printlnStatistic(statistics)
            outputHandler.printSuccess()
        }

    }
}

private val backMenuItem = MenuItem("BACK")
private val introductionsCompanyMenuItem = MenuItem("GIỚI THIỆU CÔNG TY")
private val statisticsOverViewMenuItem = MenuItem("TỔNG QUAN CÔNG TY")