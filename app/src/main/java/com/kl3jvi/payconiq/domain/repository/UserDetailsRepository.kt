package com.kl3jvi.payconiq.domain.repository

import com.kl3jvi.payconiq.common.Resource
import kotlinx.coroutines.flow.Flow

interface UserDetailsRepository {
    suspend fun getUserDetails(username: String): Flow<Resource<>>

}