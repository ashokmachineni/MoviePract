package com.example.moviepract.data.repository

import com.example.moviepract.data.Api.MoviesApi
import com.example.moviepract.data.MovieItem
import com.example.moviepract.data.meals.Category
import com.example.moviepract.data.meals.Meals
import com.example.moviepract.domain.MovieRepository
import retrofit2.Call
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val moviesApi: MoviesApi
): MovieRepository {
    override suspend fun getAllMovies(): Meals {
        return moviesApi.getAllMovies()
    }
}