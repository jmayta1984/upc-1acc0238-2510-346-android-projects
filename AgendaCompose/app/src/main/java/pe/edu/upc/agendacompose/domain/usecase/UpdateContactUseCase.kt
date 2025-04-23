package pe.edu.upc.agendacompose.domain.usecase

import pe.edu.upc.agendacompose.domain.model.Contact
import pe.edu.upc.agendacompose.domain.repository.ContactRepository

class UpdateContactUseCase(val repository: ContactRepository) {
    operator fun invoke(id: Int, name: String, company: String, phone: String) {
        val contact = Contact(id, name, company, phone)
        repository.updateContact(contact)
    }
}