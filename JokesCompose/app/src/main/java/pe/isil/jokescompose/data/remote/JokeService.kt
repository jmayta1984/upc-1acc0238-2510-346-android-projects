package pe.isil.jokescompose.data.remote

import pe.isil.jokescompose.data.model.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface JokeService {

    @GET("?")
    @Headers("Accept:application/json")
    fun getRandomJoke(): Call<Joke>
}