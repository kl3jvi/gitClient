package com.kl3jvi.payconiq.presentation.home

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.kl3jvi.payconiq.R
import com.kl3jvi.payconiq.common.SearchUserQuery
import com.kl3jvi.payconiq.common.viewBinding
import com.kl3jvi.payconiq.databinding.HomeFragmentBinding
import com.kl3jvi.payconiq.presentation.adapter.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.home_fragment) {

    private val viewModel: HomeViewModel by viewModels()
    private val binding: HomeFragmentBinding by viewBinding()
    private val adapter = SearchAdapter()
    private var searchJob: Job? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.listRv.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.listRv.adapter = adapter
        binding.mainSearch.setOnQueryTextListener(object : SearchUserQuery {
            override fun onQueryTextChange(query: String): Boolean {
                search(query = query)
                return false
            }
        })
    }

    fun search(query: String) {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch { viewModel.queryString.value = query }

                launch { viewModel.searchList.collectLatest { adapter.submitList(it) } }

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