package com.example.contacts.navigation

import androidx.compose.runtime.Composable

enum class ContactsDestinations(
    val route: String,
    val content: @Composable () -> Unit
) {

    Home(route = "home", content = {}),
    Detail(route = "detail", content = {})
}