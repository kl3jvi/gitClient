package com.kl3jvi.payconiq.data.remote

import com.kl3jvi.payconiq.common.Resource
import com.kl3jvi.payconiq.domain.model.UserDetails
import com.kl3jvi.payconiq.domain.repository.UserDetailsRepository
import com.kl3jvi.payconiq.utils.TestData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class   FakeUserDetailsRepository : UserDetailsRepository {
    private var shouldReturnError = false

    fun setReturnError(value: Boolean) {
        shouldReturnError = value
    }

    override fun getUserDetails(username: String): Flow<Resource<UserDetails>> {
        return flow {
            if (shouldReturnError) {
                emit(Resource.Error("No Data"))
            } else {
                emit(Resource.Success(TestData.userDetailsUi))
            }
        }
    }
}