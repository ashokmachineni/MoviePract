package com.example.moviepract.data.Api

import com.example.moviepract.data.MovieItem
import retrofit2.http.GET

interface MoviesApi {
    @GET("/movielist.json")
    suspend fun getAllMovies(): List<MovieItem>
}