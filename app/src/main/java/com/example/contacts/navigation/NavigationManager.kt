package com.example.contacts.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class NavigationManager {

    private val _commands = MutableSharedFlow<NavigationCommands>(extraBufferCapacity = 1)
    val navigateCommand: SharedFlow<NavigationCommands> = _commands.asSharedFlow()

    fun navigateBack() {
        val navCommand = NavigationCommands.PopBackCommand
        _commands.tryEmit(navCommand)
    }

    fun navigateWithArgs(directions: ContactsDestinations, argument: String) {
        val navCommand = NavigationCommands.NavigateCommandWithArgs(directions, argument)
        _commands.tryEmit(navCommand)
    }
}

sealed class NavigationCommands {
    object PopBackCommand : NavigationCommands()
    data class NavigateCommandWithArgs(val directions: ContactsDestinations, val args: String) :
        NavigationCommands()
}