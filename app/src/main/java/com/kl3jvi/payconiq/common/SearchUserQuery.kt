package com.kl3jvi.payconiq.common

import androidx.appcompat.widget.SearchView

/**
 * Emmiting onQueryTextSubmit() because I don't like
 * implementing things I don't use on view :)
 */
interface SearchUserQuery : SearchView.OnQueryTextListener {
    override fun onQueryTextSubmit(newText: String?): Boolean = false

}