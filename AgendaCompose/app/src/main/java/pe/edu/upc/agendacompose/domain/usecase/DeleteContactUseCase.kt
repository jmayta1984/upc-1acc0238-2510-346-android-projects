package pe.edu.upc.agendacompose.domain.usecase

import pe.edu.upc.agendacompose.domain.repository.ContactRepository

class DeleteContactUseCase(val repository: ContactRepository) {
    operator fun invoke(id: Int) {
        repository.deleteContact(id)
    }
}