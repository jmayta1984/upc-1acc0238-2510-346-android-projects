class ArticleRepository(private val articleService: ArticleService) {

    suspend fun searchArticles(description: String): List<Article> = withContext(Dispatchers.IO){

        val response = articleService.searchArticles(description)

        if (response.isSuccesfull) {
            response.body?.let {
                return@withContext it.map { articleResponse ->
                    articleResponse.toArticle()
                }
            }
        }
        return@withContext emptyList()
    }
}