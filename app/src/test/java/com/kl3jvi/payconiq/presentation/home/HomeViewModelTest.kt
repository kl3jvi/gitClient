package com.kl3jvi.payconiq.presentation.home


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.kl3jvi.payconiq.MainCoroutinesRule
import com.kl3jvi.payconiq.data.remote.FakeSearchRepository
import com.kl3jvi.payconiq.domain.use_case.SearchUsersUseCase
import com.kl3jvi.payconiq.utils.TestData
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {

    private lateinit var repository: FakeSearchRepository
    private lateinit var searchUsersUseCase: SearchUsersUseCase
    private lateinit var homeViewModel: HomeViewModel

    @get:Rule
    val instantRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = MainCoroutinesRule()

    @Before
    fun setUp() {
        repository = FakeSearchRepository()
        searchUsersUseCase = SearchUsersUseCase(repository)
        homeViewModel = HomeViewModel(searchUsersUseCase, TestCoroutineDispatcher())
    }

    @Test
    fun getSearchDetails_success() = runTest {
        homeViewModel.queryString.value = "kl3jvi"
        assertThat(homeViewModel.searchList.first()).isEqualTo(
            listOf(TestData.searchDetailsUi)
        )
    }

    @Test
    fun getSearchDetailsDetails_error() = runTest {
        repository.setReturnError(true)
        homeViewModel.queryString.value = "kl3jvi"
        assertThat(homeViewModel.error.first()).isEqualTo(
            "No Data"
        )
    }
}