package pe.edu.upc.agendacompose.domain.usecase

import pe.edu.upc.agendacompose.data.repository.ContactRepositoryImpl
import pe.edu.upc.agendacompose.domain.model.Contact
import pe.edu.upc.agendacompose.domain.repository.ContactRepository
import kotlin.random.Random

class AddContactUseCase(val repository: ContactRepository = ContactRepositoryImpl()) {
    operator fun invoke(name: String, phone: String, company: String) {
        val contact =
            Contact(
                id = Random.nextInt(10000),
                name = name,
                company = company,
                phone = phone
            )
        repository.addContact(contact)
    }
}