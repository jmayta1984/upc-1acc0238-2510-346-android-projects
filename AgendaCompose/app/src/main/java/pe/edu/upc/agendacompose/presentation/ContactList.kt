package pe.edu.upc.agendacompose.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.agendacompose.domain.model.Contact
import pe.edu.upc.agendacompose.domain.usecase.AddContactUseCase
import pe.edu.upc.agendacompose.domain.usecase.GetContactUseCase

@Preview
@Composable
fun ContactList(
    modifier: Modifier = Modifier,
    //addContactUseCase: AddContactUseCase = AddContactUseCase(),
    //getContactUseCase: GetContactUseCase = GetContactUseCase(),
    contacts: List<Contact> = emptyList(),
    onAdd: () -> Unit = { }
) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                    onAdd()
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }
    ) { padding ->
        LazyColumn(modifier = modifier.padding(padding)) {
            items(contacts) { contact ->
                ContactListItem(contact)
            }
        }
    }
}

@Composable
fun ContactListItem(contact: Contact, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(8.dp)) {
        Row(
            modifier = modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(contact.name, fontWeight = FontWeight.Bold)
                Text(contact.company)
            }
            Text(contact.phone)
        }
    }


}