package com.sumyat.newsapp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class SourceDto(
    val id: String?,
    val name: String?
)