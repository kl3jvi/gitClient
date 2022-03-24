package com.kl3jvi.payconiq.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kl3jvi.payconiq.common.Resource
import com.kl3jvi.payconiq.domain.model.UserDetails
import com.kl3jvi.payconiq.domain.use_case.GetUserDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getUserDetailsUseCase: GetUserDetailsUseCase,
    private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {


    private val _userDetails = MutableStateFlow<UserDetails?>(null)
    val userDetails: StateFlow<UserDetails?> = _userDetails

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    val githubUsernamePassed = MutableStateFlow("")

    init {
        getUserDetails()
    }

    private fun getUserDetails() {
        viewModelScope.launch(ioDispatcher) {
            githubUsernamePassed.collect { usernamePassed ->
                getUserDetailsUseCase(usernamePassed).collect { result ->
                    when (result) {
                        is Resource.Error -> {
                            _error.value = result.message
                        }
                        is Resource.Success -> {
                            _userDetails.value = result.data
                        }
                    }
                }
            }
        }
    }

    fun onErrorShown() {
        _error.value = null
    }
}