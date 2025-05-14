
@Composable
fun ArticleSearchView(viewModel: ArticleSearchViewModel) {
    val description = remember {
        mutableStateOf("")
    }
    val articles = viewModel.articles.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        OutlineTextField(
            value = description.value,
            onValueChanged = { description.value = it},
            trailingIcon = {
                IconButton (
                    onClick = {
                        viewModel.searchArticles(description.value)
                    }
                ){
                   Icon(Icons.Default.Search, contentDescription = null)
                }
            }
        )
        LazyColum {
            items(articles.value) { article ->
                Text(article.title)
            }
        }
    }
}