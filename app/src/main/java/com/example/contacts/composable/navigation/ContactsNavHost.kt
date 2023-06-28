package com.example.contacts.composable.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.contacts.navigation.ContactsDestinations

@Composable
fun ContactsNavHost(
    navController: NavHostController,
    startRoute: String,
) {
    NavHost(
        navController = navController, startDestination = startRoute
    ) {
        ContactsDestinations.values().forEach { destination ->
            composable(destination.route) {
                destination.content()
            }
        }
    }
}