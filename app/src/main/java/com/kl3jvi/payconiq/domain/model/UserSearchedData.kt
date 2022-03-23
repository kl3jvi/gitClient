package com.kl3jvi.payconiq.domain.model

data class UserSearchedData(
    val githubUsername: String, // Used as Id to make call for details :)
    val avatarUrl: String
)