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
        return when (result) {
            is MainScreenResult.PopBack -> {
                emmitEffect(MainScreenEffect.PopBack)
                previousState
            }

            is MainScreenResult.NavigateWithArgs -> {
                emmitEffect(
                    MainScreenEffect.NavigateWithArgs(
                        result.destination.route,
                        result.args
                    )
                )
                previousState
            }
        }
    }
}

sealed class MainScreenState {
    object Initial : MainScreenState()
}

sealed class MainScreenResult {

    object PopBack : MainScreenResult()

    data class NavigateWithArgs(val destination: ContactsDestinations, val args: String) :
        MainScreenResult()
}

object MainScreenAction

sealed class MainScreenEffect {
    object PopBack : MainScreenEffect()

    data class NavigateWithArgs(val route: String, val args: String) : MainScreenEffect()

}