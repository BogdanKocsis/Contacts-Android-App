package com.example.contacts.navigation

import androidx.compose.runtime.Composable

enum class ContactsDestinations(
    val route: String,
    val content: @Composable () -> Unit
) {

    Home(
        route = "home",
        content = { com.example.contacts.composable.ui.HomeScreen.Content(viewModel = androidx.hilt.navigation.compose.hiltViewModel()) }),
    Detail(route = "detail", content = {})
}