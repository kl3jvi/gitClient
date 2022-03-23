package com.kl3jvi.payconiq.domain.repository

import com.kl3jvi.payconiq.common.Resource
import com.kl3jvi.payconiq.data.remote.dto.UserSearchedDataDto
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun searchUser(query: String): Flow<Resource<List<UserSearchedDataDto>>>
}