package com.example.moviepract

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviepract.data.MovieItem
import com.example.moviepract.presentation.MoviesViewModel
import com.example.moviepract.ui.theme.MoviePractTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviePractTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   MovieScreen()
                }
            }
        }
    }
}

@Composable
fun MovieScreen(
    moviesViewModel: MoviesViewModel = hiltViewModel()
){
    val moviesData = moviesViewModel.moviesList.value
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(moviesData.isSuccess){movie ->
                MoviesListUI(movie = movie)
            }
        }
    }

}

@Composable
fun MoviesListUI(movie: MovieItem){

        Card(modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 4.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()){
                Text(text = movie.name)
            }
        }


}
