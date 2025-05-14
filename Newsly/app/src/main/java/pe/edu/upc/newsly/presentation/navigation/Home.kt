package pe.edu.upc.newsly.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Home(){

    val navController = rememberNavController()

    val navigationItems = listOf(
        NavigationItem(
            icon = Icons.Default.Search,
            title = "Search",
            route = "search"
        ),
        NavigationItem(
            icon = Icons.Default.Favorite,
            title = "Favorites",
            route = "favorites"
        )
    )

    val selectedIndex = remember {
        mutableStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                navigationItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedIndex.value == index,
                        onClick = {
                            selectedIndex.value = index
                            navController.navigate(item.route)
                        },
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        label = {
                            Text(item.title)
                        }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(navController, startDestination = "search", modifier = Modifier.padding(padding)) {

            composable("search") {  }
            composable("article") {  }
            composable("favorites") {  }

        }
    }

}

data class NavigationItem(
    val icon: ImageVector,
    val title: String,
    val route: String
)