package com.example.contacts.viewModelImpl.main

import com.example.contacts.navigation.ContactsDestinations
import com.example.contacts.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(interactor: MainInteractor) :
    BaseViewModel<MainScreenState, MainScreenAction, MainScreenEffect, MainScreenResult>(
        interactor = interactor,
        initialUIState = MainScreenState.Initial
    ) {
    override suspend fun handleResult(
        previousState: MainScreenState,
        result: MainScreenResult
    ): MainScreenState {
        return when(result){
            is MainScreenResult.NavigateWithDestination -> {
                emmitEffect(MainScreenEffect.NavigateWithDestination(result.destinations.route))
                previousState
            }
            MainScreenResult.PopBack -> {
                emmitEffect(MainScreenEffect.PopBack)
                previousState
            }
        }
    }
}

sealed class MainScreenState {
    object Initial : MainScreenState()
}

sealed class MainScreenResult {

    data class NavigateWithDestination(val destinations: ContactsDestinations) : MainScreenResult()
    object PopBack : MainScreenResult()
}

object MainScreenAction

sealed class MainScreenEffect {
    data class NavigateWithDestination(val route: String) : MainScreenEffect()
    object PopBack : MainScreenEffect()
}