package com.example.bookshelf.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccessInfo(
    @SerialName("accessViewStatus")
    val accessViewStatus: String = "",
    @SerialName("country")
    val country: String = "",
    @SerialName("embeddable")
    val embeddable: Boolean = false,
    @SerialName("epub")
    val epub: Epub = Epub(),
    @SerialName("pdf")
    val pdf: Pdf = Pdf(),
    @SerialName("publicDomain")
    val publicDomain: Boolean = false,
    @SerialName("quoteSharingAllowed")
    val quoteSharingAllowed: Boolean = false,
    @SerialName("textToSpeechPermission")
    val textToSpeechPermission: String = "",
    @SerialName("viewability")
    val viewability: String = "",
    @SerialName("webReaderLink")
    val webReaderLink: String = ""
)