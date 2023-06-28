package com.example.contacts.util

object CommonUtils {
    fun provideNameInitials(name: String?) =
        if (name.isNullOrBlank()) "Not Assigned" else
            name.split(' ')
                .map { it.first().toString() }
                .reduce { acc, s -> acc + s }
                .take(2)
                .uppercase()
}