package com.example.contacts.composable.ui

import androidx.compose.runtime.Composable
import com.example.contacts.composable.baseScreen.BaseScreen
import com.example.contacts.viewModelImpl.home.HomeScreenAction
import com.example.contacts.viewModelImpl.home.HomeScreenEffect
import com.example.contacts.viewModelImpl.home.HomeScreenState
import com.example.contacts.viewModelImpl.home.HomeScreenViewModel
import kotlinx.coroutines.flow.SharedFlow

object HomeScreen :
    BaseScreen<HomeScreenState, HomeScreenAction, HomeScreenEffect, HomeScreenViewModel>() {

    @Composable
    override fun Screen(
        state: HomeScreenState,
        effect: SharedFlow<HomeScreenEffect>,
        processUiAction: (action: HomeScreenAction) -> Unit
    ) {
        TODO("Not yet implemented")
    }
}