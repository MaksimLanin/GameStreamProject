package com.example.Isjdnrbbt.PetProj.core_network.di

import com.example.Isjdnrbbt.PetProj.core_network.BuildConfig
import com.example.Isjdnrbbt.PetProj.core_network.api.RawgApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface NetworkComponent {

    companion object {
        private const val BASE_URL = "https://api.rawg.io/"


        fun createApi(): RawgApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                        else HttpLoggingInterceptor.Level.NONE
                    })
                    .build()
            )
            .build()
            .create(RawgApi::class.java)

    }
}