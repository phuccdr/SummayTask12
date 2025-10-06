package com.eco.summaytask12.menu

import kotlin.system.exitProcess

/**
 * Object dai dien cho stack chua cac screen ma nguoi dung dang su dung
 */
object BackStack {
    private val stack = mutableListOf<Screen>()
    fun push(screen: Screen) {
        stack.add(screen)
    }

    fun pop() {
        if (stack.size > 1) {
            stack.removeAt(stack.size - 1)
        } else {
            exitProcess(0)
        }
    }
    fun size() = stack.size
    fun clear() = stack.clear()


}