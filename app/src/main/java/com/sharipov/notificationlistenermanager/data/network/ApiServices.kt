package com.sharipov.notificationlistenermanager.data.network

import com.sharipov.notificationlistenermanager.data.model.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/shows")
    suspend fun getAllMovies() : Response<List<Movies>>

}