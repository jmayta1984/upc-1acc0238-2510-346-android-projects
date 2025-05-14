class ArticleSearchViewModel (private val articleRepository: ArticleRepository): ViewModel() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> = _articles

    fun searchArticles(description: String) {
        viewModelScope.launch {
            _articles.value = articleRepository.searchArticles(description)
        }
    }
}