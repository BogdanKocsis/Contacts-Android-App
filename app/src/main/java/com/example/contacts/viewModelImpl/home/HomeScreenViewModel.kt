package com.example.contacts.viewModelImpl.home

import com.example.contacts.viewModel.BaseViewModel

class HomeScreenViewModel :
    BaseViewModel<HomeScreenState, HomeScreenAction, HomeScreenEffect, HomeScreenResult>(
        interactor = HomeScreenInteractor, initialUIState = HomeScreenState
    ) {

    override suspend fun handleResult(
        previousState: HomeScreenState,
        result: HomeScreenResult
    ): HomeScreenState {
        return HomeScreenState
    }
}


object HomeScreenState

object HomeScreenAction

object HomeScreenResult

object HomeScreenEffect