package com.example.gamestreampriject.ui.main

import android.annotation.SuppressLint
import com.example.gamestreampriject.databinding.ItemGameThinBinding
import com.example.gamestreampriject.databinding.ItemGameWideBinding
import com.example.gamestreampriject.databinding.ItemGamesHorisontalBinding
import com.example.gamestreampriject.databinding.ItemProgressThinBinding
import com.example.gamestreampriject.databinding.ItemProgressWideBinding
import com.example.gamestreampriject.model.base.ListItem
import com.example.gamestreampriject.model.game.GameThinItem
import com.example.gamestreampriject.model.game.GameWideItem
import com.example.gamestreampriject.model.game.GamesHorisontalItem
import com.example.gamestreampriject.model.game.ProgressThinItem
import com.example.gamestreampriject.model.game.ProgressWideItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MainScreenDelegates {


    @SuppressLint("NotifyDataSetChanged")
    val gamesHorisontalDelegate =
        adapterDelegateViewBinding<GamesHorisontalItem, ListItem, ItemGamesHorisontalBinding>({ inflater, container ->
            ItemGamesHorisontalBinding.inflate(
                inflater, container, false
            )
        }) {
            //onCreateViewHolder
            val adapter = GamesCardsAdapter()
            binding.recyclerView.adapter = adapter
            bind {
                //onBindViewHolder
                binding.titleTextView.text = item.title
                adapter.items = item.games

            }

            //onViewRecycler
            onViewRecycled {
                //...
            }
        }

    val wideProgressDelegate =
        adapterDelegateViewBinding<ProgressWideItem, ListItem, ItemProgressWideBinding>({ inflater, container ->
            ItemProgressWideBinding.inflate(
                inflater,
                container,
                false
            )
        }) { }

    val wideGameDelegate =
        adapterDelegateViewBinding<GameWideItem, ListItem, ItemGameWideBinding>({ inflater, container ->
            ItemGameWideBinding.inflate(
                inflater,
                container,
                false
            )
        }) {
            bind {
                binding.imageView.setBackgroundColor(item.title.hashCode())
                binding.title = item.title
                binding.executePendingBindings()
            }
        }


    val thinProgressDelegate =
        adapterDelegateViewBinding<ProgressThinItem, ListItem, ItemProgressThinBinding>({ inflater, container ->
            ItemProgressThinBinding.inflate(
                inflater,
                container,
                false
            )
        }) { }

    val thinGameDelegate =
        adapterDelegateViewBinding<GameThinItem, ListItem, ItemGameThinBinding>({ inflater, container ->
            ItemGameThinBinding.inflate(
                inflater,
                container,
                false
            )
        }) {
            bind {
                binding.imageView.setBackgroundColor(item.title.hashCode())
                binding.title = item.title
                binding.executePendingBindings()
            }
        }


}