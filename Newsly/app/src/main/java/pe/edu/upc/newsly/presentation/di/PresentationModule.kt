object PresentationModule {
    fun getArticleSearchViewModel() : ArticleSearchViewModel {
        return ArticleSearchViewModel(DataModule.getArticleRepository())
    }
}