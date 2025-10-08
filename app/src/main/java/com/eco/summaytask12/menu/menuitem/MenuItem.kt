package com.eco.summaytask12.menu.menuitem

open class MenuItem(
    val action: String,
) {
    var onClick: (() -> Unit)={}

    /**
     * La cac lua chon cua nguoi dung
     */
    fun onSelected() {
        onClick.invoke()
    }
}