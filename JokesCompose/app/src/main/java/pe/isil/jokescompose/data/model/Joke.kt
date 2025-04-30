package pe.isil.jokescompose.data.model

import com.google.gson.annotations.SerializedName

data class Joke(

    @SerializedName("joke")
    val content: String
)
