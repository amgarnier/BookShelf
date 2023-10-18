package com.example.bookshelf.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchInfo(
    @SerialName("textSnippet")
    val textSnippet: String = ""
)