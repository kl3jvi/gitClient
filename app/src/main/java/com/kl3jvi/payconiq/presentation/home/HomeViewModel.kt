package com.kl3jvi.payconiq.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kl3jvi.payconiq.common.Resource
import com.kl3jvi.payconiq.domain.model.UserSearchedData
import com.kl3jvi.payconiq.domain.use_case.SearchUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val searchUsersUseCase: SearchUsersUseCase,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _searchList = MutableStateFlow<List<UserSearchedData>?>(null)
    val searchList: StateFlow<List<UserSearchedData>?> = _searchList

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error


    private val _loadingState = MutableStateFlow<Boolean>(false)
    val loadingState: StateFlow<Boolean> = _loadingState

    val queryString = MutableStateFlow("#")

    init {
        searchData()
    }

    private fun searchData() {
        viewModelScope.launch(ioDispatcher) {
            queryString.collect { query ->
                searchUsersUseCase(query).collect { result ->
                    when (result) {
                        is Resource.Error -> {
                            _error.value = result.message
                            _searchList.value = null
                            _loadingState.value = false
                        }
                        is Resource.Success -> {
                            _searchList.value = result.data
                            _loadingState.value = false
                        }
                        is Resource.Loading -> {
                            _loadingState.value = true
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