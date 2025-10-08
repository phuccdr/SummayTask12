package com.eco.summaytask12.menu.screen.statisticoverview

import com.eco.summaytask12.menu.menuitem.MenuItem
import com.eco.summaytask12.menu.screen.Screen
import com.eco.summaytask12.services.DataService

private val dataService = DataService()

class StatisticsOverviewScreen() : Screen() {
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