package com.kl3jvi.payconiq.presentation.details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.kl3jvi.payconiq.MainCoroutinesRule
import com.kl3jvi.payconiq.data.remote.FakeUserDetailsRepository
import com.kl3jvi.payconiq.domain.use_case.GetUserDetailsUseCase
import com.kl3jvi.payconiq.utils.TestData
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailsViewModelTest {

    private lateinit var repository: FakeUserDetailsRepository
    private lateinit var getUserDetailsUseCase: GetUserDetailsUseCase
    private lateinit var detailsViewModel: DetailsViewModel

    @get:Rule
    val instantRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = MainCoroutinesRule()

    @Before
    fun setUp() {
        repository = FakeUserDetailsRepository()
        getUserDetailsUseCase = GetUserDetailsUseCase(repository)
        detailsViewModel = DetailsViewModel(getUserDetailsUseCase, TestCoroutineDispatcher())
    }


    @Test
    fun getUserDetails_success() = runTest {
        detailsViewModel.githubUsernamePassed.value = "kl3jvi"
        assertThat(detailsViewModel.userDetails.first()).isEqualTo(
            TestData.userDetailsUi
        )
    }

    @Test
    fun getUserDetails_error() = runTest {
        repository.setReturnError(true)
        detailsViewModel.githubUsernamePassed.value = "kl3jvi"
        assertThat(detailsViewModel.error.first()).isEqualTo(
            "No Data"
        )
    }

}