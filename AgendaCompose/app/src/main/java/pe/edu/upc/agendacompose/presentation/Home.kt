package pe.edu.upc.agendacompose.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun Home() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "ContactDetail") {

        composable("ContactList") {
            ContactList()
        }

        composable("ContactDetail") {
            ContactDetail()
        }
    }
}