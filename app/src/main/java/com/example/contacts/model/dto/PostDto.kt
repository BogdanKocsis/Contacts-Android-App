package com.example.contacts.model.dto

import com.example.contacts.model.Post
import com.squareup.moshi.Json


data class PostDto(
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "user_id") val userId: Int?,
    @field:Json(name = "title") val title: String?,
    @field:Json(name = "body") val body: String?,
)

fun PostDto.toPost(): Post {
    return Post(
        id = id!!,
        userId = userId!!,
        title = title.orEmpty(),
        body = body.orEmpty()
    )
}
