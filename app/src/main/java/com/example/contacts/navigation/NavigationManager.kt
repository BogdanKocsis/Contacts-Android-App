package com.example.contacts.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class NavigationManager {

    private val _commands = MutableSharedFlow<NavigationCommands>(extraBufferCapacity = 1)
    val navigateCommand: SharedFlow<NavigationCommands> = _commands.asSharedFlow()

    fun navigate(directions: ContactsDestinations) {
        val navCommand = NavigationCommands.NavigateCommand(directions)
        _commands.tryEmit(navCommand)
    }

    fun navigateBack() {
        val navCommand = NavigationCommands.PopBackCommand
        _commands.tryEmit(navCommand)
    }
}

sealed class NavigationCommands {
    data class NavigateCommand(val directions: ContactsDestinations) : NavigationCommands()
    object PopBackCommand : NavigationCommands()
}