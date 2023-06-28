package com.example.contacts.viewModelImpl.home

import com.example.contacts.viewModel.BaseInteractor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

object HomeScreenInteractor : BaseInteractor<HomeScreenAction, HomeScreenResult> {

    override fun actionToResult(action: HomeScreenAction): Flow<HomeScreenResult> = emptyFlow()

    override fun initResults(): Flow<HomeScreenResult> = emptyFlow()
}
