package com.example.contacts.viewModelImpl.main

import com.example.contacts.navigation.NavigationCommands
import com.example.contacts.navigation.NavigationManager
import com.example.contacts.viewModel.BaseInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MainInteractor @Inject constructor(private val navigationManager: NavigationManager) :
    BaseInteractor<MainScreenAction, MainScreenResult> {
    override fun actionToResult(action: MainScreenAction): Flow<MainScreenResult> = emptyFlow()

    override fun initResults(): Flow<MainScreenResult> {

        val navigationFlow = navigationManager.navigateCommand.map {
            when (it) {
                is NavigationCommands.PopBackCommand -> MainScreenResult.PopBack
                is NavigationCommands.NavigateCommandWithArgs -> MainScreenResult.NavigateWithArgs(
                    it.directions,
                    it.args
                )
            }
        }
        return navigationFlow
    }
}