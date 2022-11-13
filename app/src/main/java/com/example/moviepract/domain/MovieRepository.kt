package com.example.moviepract.domain

import com.example.moviepract.data.MovieItem

interface MovieRepository {
    suspend fun getAllMovies():List<MovieItem>
}