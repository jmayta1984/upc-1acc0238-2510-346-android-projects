package pe.edu.upc.agendacompose.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.agendacompose.domain.model.Contact
import kotlin.random.Random

@Preview
@Composable
fun ContactDetail(
    modifier: Modifier = Modifier,
    contact: Contact? = null,
    onSave: (Contact) -> Unit = {},
    onDelete: (Int) -> Unit = {}
) {

    val name = remember {
        mutableStateOf(contact?.name ?: "")
    }

    val phone = remember {
        mutableStateOf(contact?.phone ?: "")
    }

    val company = remember {
        mutableStateOf(contact?.company ?: "")
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    val id = contact?.id ?: (0..999).random()

                    onSave(
                        Contact(
                            id = id,
                            name = name.value,
                            company = company.value,
                            phone = phone.value
                        )
                    )
                }
            ) {
                Icon(Icons.Default.Save, contentDescription = null)
            }
        }
    )


    { padding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = {
                    Text("Name")
                },
                value = name.value,
                onValueChange = {
                    name.value = it
                })

            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = {
                    Text("Phone")
                },
                value = phone.value,
                onValueChange = {
                    phone.value = it
                })

            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholder = {
                    Text("Company")
                },
                value = company.value,
                onValueChange = {
                    company.value = it
                })

            TextButton(
                enabled = contact != null,
                onClick = {
                    contact?.id?.let { onDelete(it) }
                }) {
                Text("Delete contact")
            }
        }
    }
}