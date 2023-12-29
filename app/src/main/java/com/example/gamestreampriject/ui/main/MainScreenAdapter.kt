package com.example.gamestreampriject.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.example.gamestreampriject.model.base.ListItem
import com.example.gamestreampriject.ui.base.BaseDiffUtilItemCallback
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MainScreenAdapter : AsyncListDifferDelegationAdapter<ListItem>(BaseDiffUtilItemCallback()) {
    init {
        delegatesManager.addDelegate(MainScreenDelegates.gamesHorisontalDelegate)
    }


}