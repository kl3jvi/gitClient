package com.kl3jvi.payconiq.domain.repository

import com.kl3jvi.payconiq.common.Resource
import com.kl3jvi.payconiq.domain.model.UserDetails
import kotlinx.coroutines.flow.Flow

interface UserDetailsRepository {
    fun getUserDetails(username: String): Flow<Resource<UserDetails>>
}