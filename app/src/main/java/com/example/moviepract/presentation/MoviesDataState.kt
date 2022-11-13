package com.example.moviepract.presentation

import com.example.moviepract.data.meals.Category

data class MoviesDataState(
    val isLoading: Boolean = false,
    val isError: String = "",
    val isSuccess: List<Category> = emptyList()
)