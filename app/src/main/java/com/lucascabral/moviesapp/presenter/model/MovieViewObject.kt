package com.lucascabral.moviesapp.presenter.model

import com.lucascabral.moviesapp.domain.model.Movie

data class MovieViewObject(
    val name: String,
    val poster: String
) {
    constructor(movie: Movie) : this(
        name = movie.title,
        poster = movie.posterPath
    )
}
