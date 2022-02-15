package com.lucascabral.moviesapp.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucascabral.moviesapp.domain.GetMoviesUseCase
import com.lucascabral.moviesapp.presenter.model.MovieViewObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
 private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    private val _movies = MutableLiveData<List<MovieViewObject>>()
    val movies = _movies as LiveData<List<MovieViewObject>>

    fun getMovies() {

        viewModelScope.launch(Dispatchers.IO) {
            getMoviesUseCase().onSuccess { movies ->
                _movies.postValue(movies.map { movie ->
                    MovieViewObject(movie)
                })
            }.onFailure {

            }
        }
    }
}