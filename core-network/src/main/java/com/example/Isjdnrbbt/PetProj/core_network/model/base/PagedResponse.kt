package com.example.Isjdnrbbt.PetProj.core_network.model.base

import com.example.Isjdnrbbt.PetProj.core_network.model.GameDto
import com.google.gson.annotations.SerializedName

data class PagedResponse (
    @SerializedName("count") val count: Int,
    @SerializedName("next") val nextPageUrl: String,
    @SerializedName("previous") val previousPageUrl: String,
    @SerializedName("results") val results: List<GameDto>,
)
