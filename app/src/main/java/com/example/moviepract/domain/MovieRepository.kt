package com.example.moviepract.domain

import com.example.moviepract.data.MovieItem
import com.example.moviepract.data.meals.Category
import com.example.moviepract.data.meals.Meals
import retrofit2.Call

interface MovieRepository {
    suspend fun getAllMovies(): Meals
}