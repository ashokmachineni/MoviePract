package com.example.moviepract.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviepract.constants.Resource
import com.example.moviepract.data.MovieItem
import com.example.moviepract.domain.MovieRepository
import com.example.moviepract.domain.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesUseCase: MoviesUseCase
) : ViewModel() {
    private val _moviesList = mutableStateOf(MoviesDataState())
    val moviesList: State<MoviesDataState> = _moviesList

    init {
        getMovies()
    }

    private fun getMovies(){
        moviesUseCase().onEach { result ->
            when(result){
                is Resource.Loading -> {
                    _moviesList.value = MoviesDataState(isLoading = true)
                }
                is Resource.Error -> {
                    _moviesList.value = MoviesDataState(isError = "some error")
                }
                is Resource.Success -> {
                    _moviesList.value = MoviesDataState(isSuccess = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}