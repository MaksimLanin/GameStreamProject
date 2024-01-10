package com.example.gamestreampriject.model.game

import com.example.gamestreampriject.model.base.ListItem

class GameWideItem(
    val id : Long,
    val title: String,
    val image: String
): ListItem {
    override val itemId: Long = id
}