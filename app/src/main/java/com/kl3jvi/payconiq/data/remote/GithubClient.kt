package com.kl3jvi.payconiq.data.remote

import javax.inject.Inject

open class GithubClient @Inject constructor(
    private val githubService: GithubService
) {
    suspend fun searchUser(query: String) = githubService.searchUser(query)
    suspend fun getUserDetails(username: String) = githubService.getUserDetails(username)
}