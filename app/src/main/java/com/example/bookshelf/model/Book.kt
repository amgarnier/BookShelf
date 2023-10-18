package com.example.bookshelf.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    @SerialName("accessInfo")
    val accessInfo: AccessInfo = AccessInfo(),
    @SerialName("etag")
    val etag: String = "",
    @SerialName("id")
    val id: String = "",
    @SerialName("kind")
    val kind: String = "",
    @SerialName("saleInfo")
    val saleInfo: SaleInfo = SaleInfo(),
    @SerialName("searchInfo")
    val searchInfo: SearchInfo = SearchInfo(),
    @SerialName("selfLink")
    val selfLink: String = "",
    @SerialName("volumeInfo")
    val volumeInfo: VolumeInfo = VolumeInfo()
)