package com.example.contacts.repository.remoteDataSource

import com.example.contacts.model.Contact
import com.example.contacts.model.Post
import com.example.contacts.model.dto.toContact
import com.example.contacts.model.dto.toPost
import com.example.contacts.util.Resources
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class ContactRemoteDataSource @Inject constructor(
    private val api: ContactsApi
) {

    suspend fun getContacts(): Resources<List<Contact>> {
        return try {
            val result = api.getContacts()
            val contacts = result.map { contactDto ->
                contactDto.toContact()
            }
            Resources.Success(contacts)
        } catch (e: IOException) {
            e.printStackTrace()
            Resources.Error(message = "Couldn't load contacts")
        } catch (e: HttpException) {
            e.printStackTrace()
            Resources.Error("Couldn't load contacts")
        }
    }

    suspend fun getContactById(userId: String): Resources<Contact> {
        return try {
            val result = api.getContact(userId)
            Resources.Success(result.toContact())
        } catch (e: IOException) {
            e.printStackTrace()
            Resources.Error(message = "Couldn't load user")
        } catch (e: HttpException) {
            e.printStackTrace()
            Resources.Error("Couldn't load user")
        }
    }

    suspend fun getPosts(userId: String): Resources<List<Post>> {
        return try {
            val result = api.getPosts(userId)
            val posts = result.map { postDto ->
                postDto.toPost()
            }
            Resources.Success(posts)
        } catch (e: IOException) {
            e.printStackTrace()
            Resources.Error(message = "Couldn't load posts")
        } catch (e: HttpException) {
            e.printStackTrace()
            Resources.Error("Couldn't load posts")
        }
    }
}