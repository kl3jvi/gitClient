package com.kl3jvi.payconiq.domain.model

data class UserDetails(
    val avatarUrl: String,
    val bio: String,
    val followers: Int,
    val following: Int,
    val name: String
) {
    fun getFollowersNum(): String {
        return followers.toString()
    }

    fun getFollowingNum(): String {
        return following.toString()
    }
}