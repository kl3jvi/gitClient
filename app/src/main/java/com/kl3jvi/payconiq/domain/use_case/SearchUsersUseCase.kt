package com.kl3jvi.payconiq.domain.use_case

import com.kl3jvi.payconiq.common.Resource
import com.kl3jvi.payconiq.domain.model.UserSearchedData
import com.kl3jvi.payconiq.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchUsersUseCase @Inject constructor(
    private val repository: SearchRepository
) {
    operator fun invoke(query: String): Flow<Resource<List<UserSearchedData>>> =
        repository.searchUser(query = query)
}