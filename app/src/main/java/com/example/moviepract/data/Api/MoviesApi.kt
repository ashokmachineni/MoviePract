package com.example.moviepract.data.Api

import com.example.moviepract.data.MovieItem
import com.example.moviepract.data.meals.Category
import com.example.moviepract.data.meals.Meals
import retrofit2.Call
import retrofit2.http.GET

interface MoviesApi {
    @GET("categories.php")
    suspend fun getAllMovies(): Meals
}