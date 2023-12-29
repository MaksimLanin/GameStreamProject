package com.example.gamestreampriject.ui.base

import androidx.recyclerview.widget.DiffUtil
import com.example.gamestreampriject.model.base.ListItem

open class BaseDiffUtilItemCallback: DiffUtil.ItemCallback<ListItem>() {
    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem.itemId == newItem.itemId
    }

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem.equals(newItem)
    }
}