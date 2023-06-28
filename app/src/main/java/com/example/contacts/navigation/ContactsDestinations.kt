package com.example.contacts.navigation

import androidx.compose.runtime.Composable
import com.example.contacts.composable.ui.ContactDetailsScreen

enum class ContactsDestinations(
    val route: String,
    val content: @Composable () -> Unit
) {

    Home(
        route = "home",
        content = { com.example.contacts.composable.ui.HomeScreen.Content(viewModel = androidx.hilt.navigation.compose.hiltViewModel()) }),
    Detail(
        route = "detail/{contactId}",
        content = { ContactDetailsScreen.Content(viewModel = androidx.hilt.navigation.compose.hiltViewModel()) })
}

object ContactArgumentHolder {
    var contactID: String? = null
}