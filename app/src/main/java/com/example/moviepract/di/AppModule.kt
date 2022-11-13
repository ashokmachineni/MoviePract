package com.example.moviepract.di

import com.example.moviepract.data.Api.MoviesApi
import com.example.moviepract.data.repository.MovieRepositoryImpl
import com.example.moviepract.domain.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoviesApi():MoviesApi{
        return Retrofit.Builder()
            .baseUrl("https://howtodoandroid.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMoviesRepository(api: MoviesApi):MovieRepository{
        return MovieRepositoryImpl(api)
    }
}