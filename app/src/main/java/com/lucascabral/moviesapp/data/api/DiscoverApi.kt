package com.lucascabral.moviesapp.data.api

import com.lucascabral.moviesapp.data.model.BasePaginationRemote
import com.lucascabral.moviesapp.data.model.MovieRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverApi {

    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key") token: String
    ) : BasePaginationRemote<List<MovieRemote>>
}