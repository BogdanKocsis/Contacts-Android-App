package com.example.contacts.viewModelImpl.contactDetails

import com.example.contacts.navigation.NavigationManager
import com.example.contacts.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ContactDetailsScreenViewModel @Inject constructor(
    private val navigationManager: NavigationManager
) : BaseViewModel<ContactDetailsScreenState, ContactDetailsScreenAction, ContactDetailsScreenEffect, ContactDetailsScreenResult>(
    interactor = ContactDetailsScreenInteractor,
    initialUIState = ContactDetailsScreenState
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
        }
    }
}


object ContactDetailsScreenState
sealed class ContactDetailsScreenAction {
    object TopBarBackButton : ContactDetailsScreenAction()
}

sealed class ContactDetailsScreenResult {
    object TopBarBackButton : ContactDetailsScreenResult()
}

object ContactDetailsScreenEffect