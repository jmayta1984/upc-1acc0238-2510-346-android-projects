package pe.edu.upc.agendacompose.domain.repository

import kotlinx.coroutines.flow.Flow
import pe.edu.upc.agendacompose.domain.model.Contact

interface ContactRepository {
    fun getContacts(): Flow<List<Contact>>
    fun addContact(contact: Contact)
    fun deleteContact(id: Int)
    fun updateContact(contact: Contact)
}