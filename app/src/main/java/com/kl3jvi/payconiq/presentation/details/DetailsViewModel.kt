package com.kl3jvi.payconiq.presentation.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.kl3jvi.payconiq.common.STATE_HANDLE_KEY
import com.kl3jvi.payconiq.domain.model.UserSearchedData
import com.kl3jvi.payconiq.domain.use_case.GetUserDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getUserDetailsUseCase: GetUserDetailsUseCase,
    private val state: SavedStateHandle
) : ViewModel() {

    private val githubUsernamePassed =
        state.get<UserSearchedData>(STATE_HANDLE_KEY)?.githubUsername.orEmpty()

    init {
        getUserDetailsUseCase(username = "test")
    }

    private fun getUserDetails() {

    }
}