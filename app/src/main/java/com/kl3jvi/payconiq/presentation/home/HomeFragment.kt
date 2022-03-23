package com.kl3jvi.payconiq.presentation.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kl3jvi.payconiq.R
import com.kl3jvi.payconiq.common.viewBinding
import com.kl3jvi.payconiq.databinding.HomeFragmentBinding

class HomeFragment : Fragment(R.layout.home_fragment) {

    private val viewModel: HomeViewModel by viewModels()
    private val binding: HomeFragmentBinding by viewBinding()


}