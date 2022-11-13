package com.example.moviepract.data.repository

import com.example.moviepract.data.Api.MoviesApi
import com.example.moviepract.data.MovieItem
import com.example.moviepract.domain.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val moviesApi: MoviesApi
): MovieRepository {
    override suspend fun getAllMovies(): List<MovieItem> {
        return moviesApi.getAllMovies()
    }
}