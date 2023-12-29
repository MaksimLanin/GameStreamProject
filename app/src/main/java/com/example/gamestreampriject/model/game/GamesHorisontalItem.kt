package com.example.gamestreampriject.model.game

import com.example.gamestreampriject.model.base.ListItem

data class GamesHorisontalItem(
    val title: String,
    val games: List<ListItem>
) : ListItem {
    override val itemId: Long = title.hashCode().toLong()
}