package pe.edu.upc.mealscompose.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.mealscompose.domain.model.Meal
import pe.edu.upc.mealscompose.presentation.di.PresentationModule
import pe.edu.upc.mealscompose.presentation.viewmodel.MealListViewModel

@Composable
fun MealListView(
    mealListViewModel: MealListViewModel = PresentationModule.getMealListViewModel(),
    category: String
) {
    val meals = mealListViewModel.meals.collectAsState()

    mealListViewModel.getMealsByCategory(category)

    Scaffold { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(meals.value) { meal ->
                MealListItemView(meal)
            }
        }
    }
}

@Composable
fun MealListItemView(meal: Meal) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box {
                AsyncImage(
                    meal.poster,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(256.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .clip(CircleShape)
                        .background(Color.White)

                ) {
                    Icon(
                        Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)

                    )
                }
            }
            Text(meal.name, maxLines = 1, modifier = Modifier.padding(8.dp))
        }
    }
}
