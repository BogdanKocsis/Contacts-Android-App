package com.example.contacts.viewModelImpl.home

import com.example.contacts.repository.ContactsRepository
import com.example.contacts.viewModel.BaseInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeScreenInteractor @Inject constructor(private val contactsRepository: ContactsRepository) :
    BaseInteractor<HomeScreenAction, HomeScreenResult> {

    override fun actionToResult(action: HomeScreenAction): Flow<HomeScreenResult> = emptyFlow()

    override fun initResults(): Flow<HomeScreenResult> = flow {
        contactsRepository.getContacts().let { result ->
            result.data?.filter { it.status != "inactive" }
                .let { contacts ->
                    if (contacts != null) {
                        emit(HomeScreenResult.ShowContactsResult(contacts))
                    }
                }
        }
    }

}
