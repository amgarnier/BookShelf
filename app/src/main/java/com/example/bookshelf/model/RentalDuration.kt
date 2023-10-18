package com.example.bookshelf.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RentalDuration(
    @SerialName("count")
    val count: Int = 0,
    @SerialName("unit")
    val unit: String = ""
)