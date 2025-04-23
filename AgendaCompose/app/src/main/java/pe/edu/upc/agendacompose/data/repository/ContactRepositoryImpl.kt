package pe.edu.upc.agendacompose.data.repository

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import pe.edu.upc.agendacompose.domain.model.Contact
import pe.edu.upc.agendacompose.domain.repository.ContactRepository

class ContactRepositoryImpl: ContactRepository {

    private val contacts = mutableListOf<Contact>()
    private val contactsFlow = MutableStateFlow<List<Contact>>(emptyList())

    override fun getContacts(): Flow<List<Contact>> = contactsFlow

    override fun addContact(contact: Contact) {
        contacts.add(contact)
        contactsFlow.value = contacts
    }

    override fun deleteContact(id: Int) {
        TODO("Not yet implemented")
    }

    override fun updateContact(contact: Contact) {
        TODO("Not yet implemented")
    }
}