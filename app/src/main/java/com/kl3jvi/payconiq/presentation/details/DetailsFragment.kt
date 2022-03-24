package com.kl3jvi.payconiq.presentation.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.kl3jvi.payconiq.R
import com.kl3jvi.payconiq.common.viewBinding
import com.kl3jvi.payconiq.databinding.DetailsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.details_fragment) {
    private val viewModel: DetailsViewModel by viewModels()
    private val binding: DetailsFragmentBinding by viewBinding()
    private val userDetails: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getUserData()
    }

    private fun getUserData() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.githubUsernamePassed.value = userDetails.searchData.githubUsername
                }

                launch {
                    viewModel.userDetails.collect { userDetails ->
                        userDetails?.let {
                            binding.userDetails = it
                            binding.executePendingBindings()
                        }
                    }
                }

                launch {
                    viewModel.error.collect { error ->
                        error?.let {
                            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
                            viewModel.onErrorShown()
                        }
                    }
                }
            }
        }
    }
}