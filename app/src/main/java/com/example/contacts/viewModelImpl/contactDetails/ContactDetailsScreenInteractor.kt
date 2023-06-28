package com.example.contacts.viewModelImpl.contactDetails

import com.example.contacts.navigation.ContactArgumentHolder
import com.example.contacts.repository.ContactsRepository
import com.example.contacts.viewModel.BaseInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class ContactDetailsScreenInteractor @Inject constructor(private val contactsRepository: ContactsRepository) :
    BaseInteractor<ContactDetailsScreenAction, ContactDetailsScreenResult> {
    override fun actionToResult(action: ContactDetailsScreenAction): Flow<ContactDetailsScreenResult> {
        return when (action) {
            ContactDetailsScreenAction.TopBarBackButton -> {
                flowOf(ContactDetailsScreenResult.TopBarBackButton)
            }
        }
    }

    override fun initResults(): Flow<ContactDetailsScreenResult> = flow {

        ContactArgumentHolder.contactID?.let {
            contactsRepository.getContactById(
                it
            ).data
        }?.let { ContactDetailsScreenResult.ShowContactResult(it) }?.let { emit(it) }
    }
}