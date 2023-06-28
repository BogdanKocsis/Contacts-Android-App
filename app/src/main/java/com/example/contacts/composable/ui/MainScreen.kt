package com.example.contacts.composable.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.example.contacts.composable.baseScreen.BaseScreen
import com.example.contacts.composable.navigation.ContactsNavHost
import com.example.contacts.navigation.ContactsDestinations
import com.example.contacts.viewModelImpl.main.MainScreenAction
import com.example.contacts.viewModelImpl.main.MainScreenEffect
import com.example.contacts.viewModelImpl.main.MainScreenState
import com.example.contacts.viewModelImpl.main.MainViewModel
import kotlinx.coroutines.flow.SharedFlow

object MainScreen :
    BaseScreen<MainScreenState, MainScreenAction, MainScreenEffect, MainViewModel>() {
    @Composable
    override fun Screen(
        state: MainScreenState,
        effect: SharedFlow<MainScreenEffect>,
        processUiAction: (action: MainScreenAction) -> Unit
    ) {
        val navController = rememberNavController()

        ContactsNavHost(
            navController = navController,
            startRoute = ContactsDestinations.Home.route
        )

        LaunchedEffect(Unit) {
            effect.collect {
                when (it) {
                       MainScreenEffect.PopBack -> {
                        navController.popBackStack()
                    }

                    is MainScreenEffect.NavigateWithArgs -> {
                        navController.navigate(it.route + it.args)
                    }
                }
            }
        }
    }
}