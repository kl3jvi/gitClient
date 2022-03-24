package com.kl3jvi.payconiq.data.remote

import com.kl3jvi.payconiq.common.Resource
import com.kl3jvi.payconiq.domain.model.UserSearchedData
import com.kl3jvi.payconiq.domain.repository.SearchRepository
import com.kl3jvi.payconiq.utils.TestData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeSearchRepository : SearchRepository {

    private var shouldReturnError = false

    fun setReturnError(value: Boolean) {
        shouldReturnError = value
    }

    override fun searchUser(query: String): Flow<Resource<List<UserSearchedData>>> {
        return flow {
            if (shouldReturnError) {
                emit(Resource.Error("No Data"))
            } else {
                emit(Resource.Success(listOf(TestData.searchDetailsUi)))
            }
        }
    }
}