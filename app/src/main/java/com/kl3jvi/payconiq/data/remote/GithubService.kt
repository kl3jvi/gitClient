package com.kl3jvi.payconiq.data.remote

import com.kl3jvi.payconiq.data.remote.dto.SearchDetailsDto
import com.kl3jvi.payconiq.data.remote.dto.UserDetailsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {
    @GET("/search/users")
    suspend fun searchUser(@Query("q") query: String): SearchDetailsDto

    @GET("/users/{username}")
    suspend fun getUserDetails(@Path("username") username: String): UserDetailsDto
}