package com.example.contacts.viewModelImpl.contactDetails

import com.example.contacts.viewModel.BaseInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOf

object ContactDetailsScreenInteractor :
    BaseInteractor<ContactDetailsScreenAction, ContactDetailsScreenResult> {
    override fun actionToResult(action: ContactDetailsScreenAction): Flow<ContactDetailsScreenResult> {
        return when (action) {
            ContactDetailsScreenAction.TopBarBackButton -> {
                flowOf(ContactDetailsScreenResult.TopBarBackButton)
            }
        }
    }

    override fun initResults(): Flow<ContactDetailsScreenResult> = emptyFlow()
}