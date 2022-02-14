package com.lucascabral.moviesapp.data

import com.lucascabral.moviesapp.domain.model.Movie

interface DiscoveryRepository {
    suspend fun getMovies() : List<Movie>
}