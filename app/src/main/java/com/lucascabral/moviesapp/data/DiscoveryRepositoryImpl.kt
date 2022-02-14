package com.lucascabral.moviesapp.data

import com.lucascabral.moviesapp.BuildConfig
import com.lucascabral.moviesapp.data.api.DiscoverApi
import com.lucascabral.moviesapp.data.model.toDomain
import com.lucascabral.moviesapp.domain.model.Movie
import javax.inject.Inject

class DiscoveryRepositoryImpl @Inject constructor(
    private val discoverService: DiscoverApi
) : DiscoveryRepository {

    override suspend fun getMovies(): List<Movie> {
        return try {
            discoverService.getMovies(BuildConfig.tokenTMDB).results.map { movieRemote ->
                movieRemote.toDomain()
            }
        } catch (exc: Exception) {
            throw DiscoveryRepositoryException()
        }
    }
}

class DiscoveryRepositoryException : Exception()