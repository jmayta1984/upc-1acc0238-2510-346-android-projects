object DataModule {

    fun getArticleRepository(): ArticleRepository {
        return ArticleRepository(getArticleService())
    }

    fun getArticleService(): ArticleService {
        return getRetrofit().create(ArticleService::class.java)
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}