package com.eco.summaytask12.handler

import com.eco.summaytask12.menu.menuitem.MenuItem
import com.eco.summaytask12.model.androiddeveloper.AndroidDeveloper

class OutputHandler {
    private fun printlnLine() {
        println("--------------------------------------------")
    }

    fun printlnTitle(title: String) {
        printlnLine()
        println(title.uppercase())
    }

    fun printlnMenu(menu: List<MenuItem>) {
        printlnLine()
        menu.forEachIndexed { index, menuItem ->
            println("${index}. ${menuItem.action}")
        }
        println("Moi ban chon: (0-${menu.size-1})")
    }

    fun printlnListAndroidDeveloper(androidDevelopers: List<AndroidDeveloper>) {
        printlnLine()
        androidDevelopers.forEachIndexed { index, androidDev ->
            println("${index + 1}. $androidDev")
        }
    }

    fun printlnStatistic(statistics: Map<String, Any>) {
        printlnLine()
        statistics.forEach { (key, value) ->
            println("$key: ${(value)}")
        }
    }
//    fun printlnStatistic(statistics: Map<String, String>) {
//        statistics.forEach { (key, value) ->
//            println("$key: ${value}")
//        }
//    }
    fun printlnProjectStatistic(statistics: Map<String, String>) {
        statistics.forEach { (key, value) ->
            println("$key:\n$value")
        }
    }

    fun printlnException(e: Exception) {
        println(e.message)
    }

    fun print(any: Any) {
        println(any.toString())
    }

    fun printSuccess() {
        println("-----------------Success----------------")
        printlnLine()
    }

    fun <T> printlnList(list: List<T>) {
        list.forEachIndexed { index, t ->
            println("${index + 1}. $t")
        }
    }

}