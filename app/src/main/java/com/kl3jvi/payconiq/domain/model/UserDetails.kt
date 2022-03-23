package com.kl3jvi.payconiq.domain.model

data class UserDetails(
    val avatarUrl: String,
    val bio: String,
    val followers: Int,
    val following: Int,
    val name: String
)