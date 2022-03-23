package com.kl3jvi.payconiq.data.remote.repository

import com.kl3jvi.payconiq.common.Resource
import com.kl3jvi.payconiq.data.remote.GithubClient
import com.kl3jvi.payconiq.data.remote.dto.toUserSearchedData
import com.kl3jvi.payconiq.domain.repository.SearchRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val apiClient: GithubClient,
    private val ioDispatcher: CoroutineDispatcher
) : SearchRepository {
    override fun searchUser(query: String) = flow {
        emit(Resource.Loading())
        try {
            val result =
                apiClient.searchUser(query = query).items.map { it.toUserSearchedData() }
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage))
        }
    }.flowOn(ioDispatcher)
}