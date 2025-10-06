package com.eco.summaytask12.menu

import com.eco.summaytask12.utils.InputHandlerUtil
import com.eco.summaytask12.utils.LoggerUtil
import kotlin.system.exitProcess

class Screen(val name: String, val menu: List<MenuItem>) {
    
    /**
     * Dai dien giong nhu 1 man hinh, co xu ly khi nguoi dung chon cac
     * true neu muon duy tri screen, false neu muon thoat screen
     */
    fun handle(): Boolean {
        BackStack.push(this)
        introductions()
        var shouldContinue = true
        while (shouldContinue) {
            try {
                val input = InputHandlerUtil.readInt()
                if (input !in 0..<menu.size) {
                    throw Exception(
                         "Vui long nhap so trong khoang tu 0 den ${menu.size - 1}"
                    )
                }
                val result = menu[input].onSelected()
                when (result) {
                    is MenuResult.Continue -> {
                        shouldContinue = true
                    }
                    
                    is MenuResult.GoBack -> {
                        handleBack()
                       shouldContinue = false
                    }
                    is MenuResult.Navigate -> {
                       result.screen.handle() // neu tra ve true thi tiep tuc handler
                            introductions()
                           shouldContinue = true
                    }
                }
            } catch (e: Exception) {
                LoggerUtil.e(name, e)
            }
        }
        return true
    }
    /**
     * Xu ly khi nguoi dung nhan back
     */
    private fun handleBack() {
        if (BackStack.size() > 1) {
            BackStack.pop()
        } else {
            // Stack chỉ còn 1 screen (main screen), back = exit
            LoggerUtil.d(name, "Cam on ban da su dung chuong trinh!")
            BackStack.clear()
            exitProcess(0)
        }
    }
    /**
     * Hien thi menu
     */
    private fun introductions() {
        val menuText = menu.mapIndexed { index, menuItem ->
            "Chon $index: ${menuItem.action}"
        }.joinToString("\n")
        LoggerUtil.d(name, menuText)
    }


}