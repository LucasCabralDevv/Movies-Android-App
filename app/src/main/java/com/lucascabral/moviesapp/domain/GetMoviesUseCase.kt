package com.lucascabral.moviesapp.domain

import com.lucascabral.moviesapp.data.DiscoveryRepository
import com.lucascabral.moviesapp.domain.model.Movie
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: DiscoveryRepository
) {

    suspend operator fun invoke() : Result<List<Movie>> {
        return try {
            Result.success(repository.getMovies())
        } catch (exc: Exception) {
            Result.failure(exc)
        }
    }
}