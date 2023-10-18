package com.example.bookshelf.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReadingModes(
    @SerialName("image")
    val image: Boolean = false,
    @SerialName("text")
    val text: Boolean = false
)