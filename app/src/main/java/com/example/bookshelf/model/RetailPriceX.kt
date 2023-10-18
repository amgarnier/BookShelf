package com.example.bookshelf.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RetailPriceX(
    @SerialName("amount")
    val amount: Double = 0.0,
    @SerialName("currencyCode")
    val currencyCode: String = ""
)