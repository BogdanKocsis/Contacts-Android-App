package com.example.contacts.viewModelImpl.home

import com.example.contacts.model.Contact
import com.example.contacts.navigation.ContactsDestinations
import com.example.contacts.navigation.NavigationManager
import com.example.contacts.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val navigationManager: NavigationManager,
    interactor: HomeScreenInteractor
) :
    BaseViewModel<HomeScreenState, HomeScreenAction, HomeScreenEffect, HomeScreenResult>(
        interactor = interactor, initialUIState = HomeScreenState.LoadingState
    ) {

    override suspend fun handleResult(
        previousState: HomeScreenState,
        result: HomeScreenResult
    ): HomeScreenState {
        return when (result) {
            HomeScreenResult.LoadingResult -> {
                previousState
            }

            is HomeScreenResult.NavigateToContactDetailsResult -> {
                previousState
            }

            is HomeScreenResult.ShowContactsResult -> {
                HomeScreenState.ShowContactsState(result.contactsList)
            }
        }
    }
}


sealed class HomeScreenState {
    object LoadingState : HomeScreenState()

    data class ShowContactsState(val contactsList: List<Contact>) : HomeScreenState()
}

sealed class HomeScreenAction {
    data class NavigateToContactDetails(val contactId: String) : HomeScreenAction()
}

sealed class HomeScreenResult {
    data class ShowContactsResult(val contactsList: List<Contact>) : HomeScreenResult()

    data class NavigateToContactDetailsResult(val destination: ContactsDestinations) :
        HomeScreenResult()

    object LoadingResult : HomeScreenResult()
}

object HomeScreenEffect

