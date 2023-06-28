package com.example.contacts.repository.remoteDataSource

import com.example.contacts.model.dto.ContactDto
import com.example.contacts.model.dto.PostDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ContactsApi {

    @GET("users/")
    suspend fun getContacts(): List<ContactDto>

    @GET("users/{userId}")
    suspend fun getContact(@Path("userId") userId: String): ContactDto

    @GET("users/{userId}/posts")
    suspend fun getPosts(@Path("userId") userId: String): List<PostDto>

    companion object {
        const val BASE_URL = "https://gorest.co.in/public/v2/"
    }

}