package com.example.bookshelf.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Books(
    @SerialName("items")
    val items: List<Book> = listOf(),
    @SerialName("kind")
    val kind: String = "",
    @SerialName("totalItems")
    val totalItems: Int = 0
)