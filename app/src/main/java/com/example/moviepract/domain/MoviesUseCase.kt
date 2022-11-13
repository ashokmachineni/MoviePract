package com.example.moviepract.domain

import com.example.moviepract.constants.Resource
import com.example.moviepract.data.MovieItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(): Flow<Resource<List<MovieItem>>> = flow {
        try {
            emit(Resource.Loading())
            val movies = movieRepository.getAllMovies()
            emit(Resource.Success(movies))
        }catch (e: IOException){
            emit(Resource.Error("network error"))
        }catch (e: HttpException){
            emit(Resource.Error("something went wrong"))
        }

    }
}