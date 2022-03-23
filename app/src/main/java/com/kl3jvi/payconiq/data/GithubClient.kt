package com.kl3jvi.payconiq.data

import javax.inject.Inject

class GithubClient @Inject constructor(
    private val githubService: GithubService
) {
    suspend fun searchUser(query: String) = githubService.searchUser(query)
    suspend fun getUserDetails(username: String) = githubService.getUserDetails(username)
}