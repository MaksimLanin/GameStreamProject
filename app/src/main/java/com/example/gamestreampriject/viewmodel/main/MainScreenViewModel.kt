package com.example.gamestreampriject.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.Isjdnrbbt.PetProj.core_network.di.NetworkComponent
import com.example.gamestreampriject.model.base.ListItem
import com.example.gamestreampriject.model.game.GameThinItem
import com.example.gamestreampriject.model.game.GameWideItem
import com.example.gamestreampriject.model.game.GamesHorisontalItem
import com.example.gamestreampriject.model.game.ProgressThinItem
import com.example.gamestreampriject.model.game.ProgressWideItem
import com.example.gamestreampriject.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainScreenViewModel : BaseViewModel() {
    private val api = NetworkComponent.createApi()
    private val _data = MutableLiveData<List<ListItem>>()
    val data: LiveData<List<ListItem>> = _data

    init {

        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(getLoaders())
            val items = getItems()
            _data.postValue(items)
        }

    }

    private fun getLoaders(): List<ListItem> {
        return listOf(
            GamesHorisontalItem(
                title = "Wide games title",
                games = IntRange(1, 2).map { ProgressWideItem }
            ),
            GamesHorisontalItem(
                title = "Thin games title",
                games = IntRange(1, 3).map { ProgressThinItem }

            ),
            GamesHorisontalItem(
                title = "Tree games title",
                games = IntRange(1, 2).map { ProgressWideItem }

            )
        )
    }

    private suspend fun getItems(): List<ListItem> {
        val response = api.games()
        val gamesWide = response.results.map {
            GameWideItem(
                id = it.id,
                title = it.title
            )
        }

        val gamesThin = response.results.map {
            GameThinItem(
                id = it.id,
                title = it.title
            )
        }
        return listOf(
            GamesHorisontalItem(
                title = "Wide games title",
                games = gamesWide
            ),
            GamesHorisontalItem(
                title = "Thin games title",
                games = gamesThin

            ),
            GamesHorisontalItem(
                title = "Tree games title",
                games = gamesWide

            )
        )
    }
}