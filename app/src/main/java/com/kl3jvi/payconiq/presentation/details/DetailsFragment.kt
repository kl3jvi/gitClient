package com.kl3jvi.payconiq.presentation.details

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
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
                    viewModel.userDetails.collect { userDetails ->
                        Log.e("Data", userDetails.toString())

                        userDetails?.let {
                            Log.e("Data", it.toString())
                            binding.userDetails = it
                            binding.executePendingBindings()
                        }
                    }
                }
            }
        }
    }
}