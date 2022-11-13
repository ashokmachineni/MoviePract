package com.example.moviepract.presentation

import com.example.moviepract.data.MovieItem

data class MoviesDataState(
    val isLoading: Boolean = false,
    val isError: String = "",
    val isSuccess: List<MovieItem> = emptyList()
)