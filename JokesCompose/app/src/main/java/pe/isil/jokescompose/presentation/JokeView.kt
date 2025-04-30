package pe.isil.jokescompose.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.isil.jokescompose.data.remote.ApiClient
import pe.isil.jokescompose.data.repository.JokeRepository

@Preview
@Composable
fun JokeView(){

    val service = ApiClient.getJokeService()
    val repository = JokeRepository(service)

    val content = remember {
        mutableStateOf("")
    }
    Scaffold { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding),
            verticalArrangement = Arrangement.Center) {
            Text(content.value)
            Button(
                onClick = {
                    repository.getRandomJoke { joke ->
                        content.value = joke.content
                    }
                }
            ) {
                Text("Random")
            }
        }
    }

}