package com.kl3jvi.payconiq.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kl3jvi.payconiq.databinding.ItemSearchUsersBinding
import com.kl3jvi.payconiq.domain.model.UserSearchedData
import com.kl3jvi.payconiq.presentation.home.HomeFragmentDirections

class SearchAdapter :
    ListAdapter<UserSearchedData, SearchAdapter.SearchViewHolder>(UserSearchDiffCallback()) {

    class SearchViewHolder(private val binding: ItemSearchUsersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener { view ->
                binding.searchInfo?.let { searchData ->
                    navigateToDetails(searchData, view)
                }
            }
        }

        private fun navigateToDetails(searchData: UserSearchedData, view: View) {
            val direction = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(searchData)
            view.findNavController().navigate(direction)
        }


        fun bindItem(item: UserSearchedData) {
            binding.searchInfo = item
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding: ItemSearchUsersBinding = ItemSearchUsersBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bindItem(item)
        }
    }
}

private class UserSearchDiffCallback : DiffUtil.ItemCallback<UserSearchedData>() {
    override fun areItemsTheSame(oldItem: UserSearchedData, newItem: UserSearchedData): Boolean {
        return oldItem.githubUsername == newItem.githubUsername
    }

    override fun areContentsTheSame(oldItem: UserSearchedData, newItem: UserSearchedData): Boolean {
        return oldItem == newItem
    }
}