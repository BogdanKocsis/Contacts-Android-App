package com.example.contacts.repository.remoteDataSource

import com.example.contacts.model.dto.ContactDto
import retrofit2.http.GET
import retrofit2.http.Query
import okhttp3.ResponseBody

interface ContactsApi {

    @GET("users/")
    suspend fun getContacts(): List<ContactDto>

    companion object {
        const val BASE_URL = "https://gorest.co.in/public/v2/"
    }

}