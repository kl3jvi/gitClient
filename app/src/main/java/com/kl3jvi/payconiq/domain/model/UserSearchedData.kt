package com.kl3jvi.payconiq.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserSearchedData(
    val githubUsername: String, // Used as Id to make call for details :)
    val avatarUrl: String
) : Parcelable