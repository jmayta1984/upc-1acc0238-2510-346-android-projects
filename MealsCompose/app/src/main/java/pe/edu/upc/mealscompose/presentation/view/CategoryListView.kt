package pe.edu.upc.mealscompose.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.mealscompose.presentation.PresentationModule
import pe.edu.upc.mealscompose.presentation.viewmodel.CategoryListViewModel

@Composable
fun CategoryListView(viewModel: CategoryListViewModel = PresentationModule.getCategoryListViewModel()) {
    val categories = viewModel.categories.collectAsState()
    viewModel.getCategories()

    Scaffold { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(categories.value) { category ->
                Card(modifier = Modifier.padding(8.dp)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        AsyncImage(category.poster ?: "", contentDescription = null)
                        Column (modifier = Modifier.padding(start = 8.dp)) {
                            Text(category.name ?: "", fontWeight = FontWeight.Bold)
                            Text(category.description ?: "", maxLines = 1)

                        }
                    }
                }

            }
        }

    }
}