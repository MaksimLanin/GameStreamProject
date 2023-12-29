package com.example.Isjdnrbbt.PetProj.core_network.model

import com.google.gson.annotations.SerializedName

data class GameDto(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val title: String,
    @SerializedName("background_image") val image: String,

)
