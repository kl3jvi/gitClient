package com.kl3jvi.payconiq.domain.use_case

import com.kl3jvi.payconiq.domain.repository.UserDetailsRepository
import javax.inject.Inject

class GetUserDetailsUseCase @Inject constructor(
    private val repository: UserDetailsRepository
) {
    operator fun invoke(username: String) = repository.getUserDetails(username = username)
}