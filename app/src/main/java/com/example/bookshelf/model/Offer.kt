package com.example.bookshelf.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Offer(
    @SerialName("finskyOfferType")
    val finskyOfferType: Int = 0,
    @SerialName("giftable")
    val giftable: Boolean? = false,
    @SerialName("listPrice")
    val listPrice: ListPriceX = ListPriceX(),
    @SerialName("rentalDuration")
    val rentalDuration: RentalDuration? = RentalDuration(),
    @SerialName("retailPrice")
    val retailPrice: RetailPrice = RetailPrice()
)