package com.kl3jvi.payconiq.presentation.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kl3jvi.payconiq.R
import com.kl3jvi.payconiq.common.viewBinding
import com.kl3jvi.payconiq.databinding.DetailsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.details_fragment) {
    private val viewModel: DetailsViewModel by viewModels()
    private val binding: DetailsFragmentBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}