package com.example.bookshelf.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PanelizationSummary(
    @SerialName("containsEpubBubbles")
    val containsEpubBubbles: Boolean = false,
    @SerialName("containsImageBubbles")
    val containsImageBubbles: Boolean = false
)