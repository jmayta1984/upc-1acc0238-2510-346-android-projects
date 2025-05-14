package pe.edu.upc.newsly.data.remote

data class ArticleResponse(

    val author: String?,
    val content: String?,
    val description: String?,
    val publishAt: String?,
    val url: String?,
    val urlToImage: String?,
    val title: String?,
    val source: SourceResponse?
)

data class SourceResponse(
    val id: String?,
    val name: String?
)