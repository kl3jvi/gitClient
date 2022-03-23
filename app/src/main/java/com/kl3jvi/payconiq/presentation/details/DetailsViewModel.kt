package com.kl3jvi.payconiq.presentation.details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kl3jvi.payconiq.common.Resource
import com.kl3jvi.payconiq.common.STATE_HANDLE_KEY
import com.kl3jvi.payconiq.domain.model.UserDetails
import com.kl3jvi.payconiq.domain.model.UserSearchedData
import com.kl3jvi.payconiq.domain.use_case.GetUserDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getUserDetailsUseCase: GetUserDetailsUseCase,
    private val state: SavedStateHandle
) : ViewModel() {

    private val githubUsernamePassed =
        state.get<UserSearchedData>(STATE_HANDLE_KEY)?.githubUsername.orEmpty()

    init {
        Log.e("git", githubUsernamePassed)
    }

    private val _userDetails = MutableStateFlow<UserDetails?>(null)
    val userDetails: StateFlow<UserDetails?> = _userDetails

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error


    private val _loadingState = MutableStateFlow<Boolean>(false)
    val loadingState: StateFlow<Boolean> = _loadingState


    init {
        getUserDetails()
    }

    private fun getUserDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            getUserDetailsUseCase(githubUsernamePassed).collect { result ->
                when (result) {
                    is Resource.Error -> {
                        Log.e("Error", result.message.toString())
                    }
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        _userDetails.value = result.data
                    }
                }
            }
        }

    }
}