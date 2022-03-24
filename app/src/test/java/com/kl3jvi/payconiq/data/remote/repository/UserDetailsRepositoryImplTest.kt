package com.kl3jvi.payconiq.data.remote.repository

import com.google.common.truth.Truth.assertThat
import com.kl3jvi.payconiq.MainCoroutinesRule
import com.kl3jvi.payconiq.common.Resource
import com.kl3jvi.payconiq.data.remote.GithubClient
import com.kl3jvi.payconiq.data.remote.GithubService
import com.kl3jvi.payconiq.utils.MockData
import com.kl3jvi.payconiq.utils.MockData.mockUserDetails
import com.kl3jvi.payconiq.utils.MockData.mockUserDetailsDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class UserDetailsRepositoryImplTest {
    private lateinit var repository: UserDetailsRepositoryImpl
    private lateinit var client: GithubClient
    private val service = mock(GithubService::class.java)

    @get:Rule
    var coroutinesRule = MainCoroutinesRule()

    @Before
    fun setup() {
        client = GithubClient(service)
        repository = UserDetailsRepositoryImpl(client, Dispatchers.IO)
    }

    @Test
    fun getUserDetails_success() = runTest {
        val mockData = mockUserDetailsDto()
        `when`(client.getUserDetails("kl3jvi")).thenReturn(mockData)
        val userDetails = repository.getUserDetails("kl3jvi").first()
        assertThat(userDetails is Resource.Success)
        if (userDetails is Resource.Success) {
            assertThat(userDetails.data).isEqualTo(mockUserDetails())
        }
    }

    @Test
    fun getUserDetails_error() = runTest {
        `when`(client.getUserDetails("kl3jvi")).thenThrow(
            RuntimeException("No data")
        )
        val userDetails = repository.getUserDetails("kl3jvi").first()
        assertThat(userDetails is Resource.Error)
        if (userDetails is Resource.Error) {
            assertThat(userDetails.message).isEqualTo("No data")
        }
    }
}