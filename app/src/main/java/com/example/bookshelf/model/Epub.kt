package com.example.bookshelf.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Epub(
    @SerialName("acsTokenLink")
    val acsTokenLink: String? = null,
    @SerialName("isAvailable")
    val isAvailable: Boolean = false,
    @SerialName("downloadLink")
    val downloadLink:String? = null
)