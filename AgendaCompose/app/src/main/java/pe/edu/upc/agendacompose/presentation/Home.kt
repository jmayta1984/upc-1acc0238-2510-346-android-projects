package pe.edu.upc.agendacompose.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.agendacompose.data.repository.ContactRepositoryImpl
import pe.edu.upc.agendacompose.domain.model.Contact
import pe.edu.upc.agendacompose.domain.usecase.AddContactUseCase
import pe.edu.upc.agendacompose.domain.usecase.DeleteContactUseCase
import pe.edu.upc.agendacompose.domain.usecase.GetContactUseCase
import pe.edu.upc.agendacompose.domain.usecase.UpdateContactUseCase

@Preview
@Composable
fun Home() {
    val navController = rememberNavController()
    val repository = ContactRepositoryImpl()
    val addContactUseCase = AddContactUseCase(repository)
    val getContactUseCase = GetContactUseCase(repository)
    val updateContactUseCase = UpdateContactUseCase(repository)
    val deleteContactUseCase = DeleteContactUseCase(repository)

    val contacts =
        getContactUseCase.invoke().collectAsState(emptyList())

    val selectedContact = remember {
        mutableStateOf<Contact?>(null)
    }
    NavHost(
        navController = navController,
        startDestination = Routes.ContactList.route
    ) {

        composable(Routes.ContactList.route) {
            ContactList(
                contacts = contacts.value,
                onAdd = {
                    selectedContact.value = null
                    navController.navigate(route = Routes.ContactDetail.route)
                },
                onSelect = {
                    selectedContact.value = it
                    navController.navigate(route = Routes.ContactDetail.route)
                }
            )
        }

        composable(Routes.ContactDetail.route) {
            ContactDetail(
                contact = selectedContact.value,
                onSave = { contact ->
                    if (selectedContact.value == null) {
                        addContactUseCase(contact)
                    } else {
                        updateContactUseCase(contact)
                    }
                    navController.popBackStack()
                },
                onDelete = {
                    deleteContactUseCase(it)
                    navController.popBackStack()
                })
        }
    }
}

sealed class Routes(val route: String) {
    data object ContactList : Routes(route = "ContactList")
    data object ContactDetail : Routes(route = "ContactDetail")
}