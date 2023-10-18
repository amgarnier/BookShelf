package com.example.bookshelf.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RetailPrice(
    @SerialName("amountInMicros")
    val amountInMicros: Int = 0,
    @SerialName("currencyCode")
    val currencyCode: String = ""
)