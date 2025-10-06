package com.eco.summaytask12.menu

/**
 * Result la ket qua tra ve de quyet dinh screen co duoc tiep tuc handler hay khong va navigate den screen khac
 */
sealed class MenuResult {
    object Continue : MenuResult()
    object GoBack : MenuResult()
    data class Navigate(val screen: Screen) : MenuResult()
}