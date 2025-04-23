package pe.edu.upc.agendacompose.domain.usecase

import pe.edu.upc.agendacompose.data.repository.ContactRepositoryImpl
import pe.edu.upc.agendacompose.domain.model.Contact
import pe.edu.upc.agendacompose.domain.repository.ContactRepository

class AddContactUseCase(val repository: ContactRepository = ContactRepositoryImpl()) {
    operator fun invoke(contact: Contact) {
        repository.addContact(contact)
    }
}