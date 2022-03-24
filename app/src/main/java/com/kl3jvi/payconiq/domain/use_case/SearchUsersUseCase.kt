package com.kl3jvi.payconiq.domain.use_case

import com.kl3jvi.payconiq.domain.repository.SearchRepository
import javax.inject.Inject

class SearchUsersUseCase @Inject constructor(
    private val repository: SearchRepository,
) {
    operator fun invoke(query: String) = repository.searchUser(query = query)
}