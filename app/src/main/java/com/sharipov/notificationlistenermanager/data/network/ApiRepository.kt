package com.sharipov.notificationlistenermanager.data.network;

import javax.inject.Inject


internal class ApiRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllMovies() = apiService.getAllMovies()
}
