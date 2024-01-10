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
                title = "The most anticipated",
                games = IntRange(1, 2).map { ProgressWideItem }
            ),
            GamesHorisontalItem(
                title = "Latest realeases ",
                games = IntRange(1, 3).map { ProgressThinItem }

            ),
            GamesHorisontalItem(
                title = "Tree games title",
                games = IntRange(1, 2).map { ProgressWideItem }

            )
        )
    }

    private suspend fun getItems(): List<ListItem> {
        val mostAnticipatedResponse = api.games(
            mapOf(
                "dates" to "2024-01-10,2025-01-10",
                "ordering" to "-added"
            )
        )
        val latesReleasesResponse = api.games(
            mapOf(
                "dates" to "2023-12-01,024-01-10"
            )
        )
        val mostRatedResponse = api.games(
            mapOf(
                "dates" to "2024-01-10,2025-01-10",
                "ordering" to "rated"
            )
        )
        val mostAnticipatedItem = mostAnticipatedResponse.results.map {
            GameWideItem(
                id = it.id,
                title = it.title,
                image = it.image
            )
        }

        val latestReleasesItems = latesReleasesResponse.results.map {
            GameThinItem(
                id = it.id,
                title = it.title,
                image = it.image
            )
        }
        val mostRatedItem = mostAnticipatedResponse.results.map {
            GameWideItem(
                id = it.id,
                title = it.title,
                image = it.image
            )
        }
        return listOf(
            GamesHorisontalItem(
                title = "The most anticipated",
                games = mostAnticipatedItem
            ),
            GamesHorisontalItem(
                title = "Latest realeases",
                games = latestReleasesItems

            ),
            GamesHorisontalItem(
                title = "Tree games title",
                games = mostRatedItem

            )
        )
    }
}