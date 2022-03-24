package com.kl3jvi.payconiq.utils

import com.kl3jvi.payconiq.domain.model.UserDetails
import com.kl3jvi.payconiq.domain.model.UserSearchedData

object TestData {

    val searchDetailsUi = UserSearchedData(
        githubUsername = "kl3jvi",
        avatarUrl = "https://avatars.githubusercontent.com/u/40796367?v=4",
    )

    val userDetailsUi = UserDetails(
        avatarUrl = "https://avatars.githubusercontent.com/u/40796367?v=4",
        bio = "Android and open source software engineer. :rocket: ",
        followers = 53,
        following = 14,
        name = "kl3jvi"
    )
}