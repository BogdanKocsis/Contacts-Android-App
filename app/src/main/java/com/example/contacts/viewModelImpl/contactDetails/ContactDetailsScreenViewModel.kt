package com.example.contacts.viewModelImpl.contactDetails

import com.example.contacts.model.Contact
import com.example.contacts.navigation.NavigationManager
import com.example.contacts.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ContactDetailsScreenViewModel @Inject constructor(
    private val navigationManager: NavigationManager, interactor: ContactDetailsScreenInteractor
) : BaseViewModel<ContactDetailsScreenState, ContactDetailsScreenAction, ContactDetailsScreenEffect, ContactDetailsScreenResult>(
    interactor = interactor,
    initialUIState = ContactDetailsScreenState.LoadingState
) {
    override suspend fun handleResult(
        previousState: ContactDetailsScreenState,
        result: ContactDetailsScreenResult
    ): ContactDetailsScreenState {
        return when (result) {
            ContactDetailsScreenResult.TopBarBackButton -> {
                navigationManager.navigateBack()
                previousState
            }

            is ContactDetailsScreenResult.ShowContactResult -> {
                ContactDetailsScreenState.ShowContactState(result.contact)
            }
        }
    }
}


sealed class ContactDetailsScreenState {
    object LoadingState : ContactDetailsScreenState()

    data class ShowContactState(val contact: Contact) : ContactDetailsScreenState()
}

sealed class ContactDetailsScreenAction {
    object TopBarBackButton : ContactDetailsScreenAction()
}

sealed class ContactDetailsScreenResult {
    object TopBarBackButton : ContactDetailsScreenResult()
    data class ShowContactResult(val contact: Contact) : ContactDetailsScreenResult()

}

object ContactDetailsScreenEffect