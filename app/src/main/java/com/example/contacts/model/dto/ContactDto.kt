package com.example.contacts.model.dto

import com.example.contacts.model.Contact
import com.squareup.moshi.Json

data class ContactDto(
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "name") val name: String?,
    @field:Json(name = "email") val email: String?,
    @field:Json(name = "gender") val gender: String?,
    @field:Json(name = "status") val status: String?

)

fun ContactDto.toContact(): Contact {
    return Contact(
        id = id!!,
        name = name.orEmpty(),
        email = email.orEmpty(),
        gender = gender.orEmpty(),
        status = status.orEmpty()
    )
}