package com.deedeveloper.recyview

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PhotosApi {

    @GET("db.json")
    suspend fun getPhotos():Response<List<Photo>>

    companion object {
        operator fun invoke(): PhotosApi {
            return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://deepak5310.github.io/nmjson/")
                .build().create(PhotosApi::class.java)
        }
    }
}