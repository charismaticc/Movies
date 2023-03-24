package com.sharipov.movies.data.network

import com.sharipov.movies.data.model.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/shows")
    suspend fun getAllMovies() : Response<List<Movies>>

}