package com.example.bookshelf.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IndustryIdentifier(
    @SerialName("identifier")
    val identifier: String = "",
    @SerialName("type")
    val type: String = ""
)