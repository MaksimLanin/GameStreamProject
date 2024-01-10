package com.example.Isjdnrbbt.PetProj.core_network.api

import com.example.Isjdnrbbt.PetProj.core_network.model.base.PagedResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

interface RawgApi {

    @Headers( "api_key: api = c28567b6147c44b68383680b6e7cbac7")
    @GET("/api/games")
    suspend fun games(@QueryMap params: Map<String, String>):PagedResponse
}