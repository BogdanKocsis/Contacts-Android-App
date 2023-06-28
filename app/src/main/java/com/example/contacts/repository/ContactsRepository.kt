package com.example.contacts.repository

import com.example.contacts.repository.remoteDataSource.ContactRemoteDataSource
import javax.inject.Inject

class ContactsRepository @Inject constructor(
    private val contactRemoteDataSource: ContactRemoteDataSource
) {

    suspend fun getContacts() = contactRemoteDataSource.getContacts()

    suspend fun getContactById(userId: String) = contactRemoteDataSource.getContactById(userId)

    suspend fun getPosts(userId: String) = contactRemoteDataSource.getPosts(userId)
}