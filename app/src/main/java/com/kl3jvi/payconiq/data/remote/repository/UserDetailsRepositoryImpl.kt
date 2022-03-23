package com.kl3jvi.payconiq.data.remote.repository

import com.kl3jvi.payconiq.common.Resource
import com.kl3jvi.payconiq.data.remote.GithubClient
import com.kl3jvi.payconiq.data.remote.dto.toUserDetails
import com.kl3jvi.payconiq.domain.repository.UserDetailsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserDetailsRepositoryImpl @Inject constructor(
    private val apiClient: GithubClient,
    private val ioDispatcher: CoroutineDispatcher
) : UserDetailsRepository {
    override suspend fun getUserDetails(username: String) = flow {
        emit(Resource.Loading())
        try {
            val result = apiClient.getUserDetails(username).toUserDetails()
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage))
        }
    }.flowOn(ioDispatcher)
}