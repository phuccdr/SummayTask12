package com.eco.summaytask12.menu.screen

import com.eco.summaytask12.handler.InputHandler
import com.eco.summaytask12.handler.OutputHandler
import com.eco.summaytask12.menu.BackStack
import com.eco.summaytask12.menu.menuitem.MenuItem
import kotlin.system.exitProcess

abstract class Screen{
    protected val menu: MutableList<MenuItem> = mutableListOf()
    protected var name: String = "Screen"
    protected val inputHandler: InputHandler = InputHandler()
    protected val outputHandler: OutputHandler = OutputHandler()
    private var isRunning = true

    protected abstract fun createMenu()
    fun handler() {
        createMenu()
        BackStack.push(this)
        showMenu()
        while (isRunning) {
            try {
                val menuItem = inputHandler.readMenuItem(menu)
                outputHandler.print(menuItem.action)
                menuItem.onSelected()
            } catch (e: Exception) {
                outputHandler.printlnException(e)
            }
        }
    }

    private fun showMenu() {
        outputHandler.printlnMenu(menu)
    }

    protected fun navigate(screen: Screen) {
        screen.handler()
    }

    protected fun back() {
        if (BackStack.size() > 1) {
            destroy()
            BackStack.pop()
            BackStack.last().showMenu()
        } else {
            BackStack.clear()
            exitProcess(0)
        }
    }

    protected fun destroy() {
        isRunning = false
    }


}