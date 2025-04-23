package pe.edu.upc.agendacompose.domain.usecase

import kotlinx.coroutines.flow.Flow
import pe.edu.upc.agendacompose.data.repository.ContactRepositoryImpl
import pe.edu.upc.agendacompose.domain.model.Contact
import pe.edu.upc.agendacompose.domain.repository.ContactRepository

class GetContactUseCase(val repository: ContactRepository = ContactRepositoryImpl()) {
    operator fun invoke(): Flow<List<Contact>>{
        return repository.getContacts()
    }
}