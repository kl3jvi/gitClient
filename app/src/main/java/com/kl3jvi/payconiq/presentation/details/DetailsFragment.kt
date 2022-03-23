package com.kl3jvi.payconiq.presentation.details

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kl3jvi.payconiq.R
import com.kl3jvi.payconiq.common.viewBinding
import com.kl3jvi.payconiq.databinding.DetailsFragmentBinding

class DetailsFragment : Fragment(R.layout.details_fragment) {
    private val viewModel: DetailsViewModel by viewModels()
    private val binding: DetailsFragmentBinding by viewBinding()

}