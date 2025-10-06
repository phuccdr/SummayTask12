package com.eco.summaytask12.menu

import com.eco.summaytask12.utils.LoggerUtil

class MenuItem(
    val action: String,
    val actionType: MenuActionType = MenuActionType.EXECUTE,
    val navigateScreen: Screen? = null,
    val execute: () -> Unit = {}
) {
    /**
     * La cac lua chon cua nguoi dung
     */
    fun onSelected(): MenuResult {
        LoggerUtil.d(message = "Ban da chon: $action")

        return when (actionType) {
            MenuActionType.BACK -> MenuResult.GoBack
            MenuActionType.NAVIGATE -> {
                if (navigateScreen != null) {
                    MenuResult.Navigate(navigateScreen)
                } else {
                    MenuResult.Continue
                }
            }

            MenuActionType.EXECUTE -> {
                execute()
                MenuResult.Continue
            }
        }
    }
}