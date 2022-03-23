package com.kl3jvi.payconiq.utils

import com.kl3jvi.payconiq.data.remote.dto.UserSearchedDataDto
import com.kl3jvi.payconiq.domain.model.UserDetails

object MockData {

    fun mockUserSearchData() = UserSearchedDataDto(
        "https://avatars.githubusercontent.com/u/40796367?v=4",
        "https://api.github.com/users/kl3jvi/events{/privacy}",
        "https://api.github.com/users/kl3jvi/followers",
        "https://api.github.com/users/kl3jvi/following{/other_user}",
        "https://api.github.com/users/kl3jvi/gists{/gist_id}",
        "",
        "https://github.com/kl3jvi",
        40796367,
        "kl3jvi",
        "MDQ6VXNlcjQwNzk2MzY3",
        "https://api.github.com/users/kl3jvi/orgs",
        "https://api.github.com/users/kl3jvi/received_events",
        "https://api.github.com/users/kl3jvi/repos",
        1.0,
        false,
        "https://api.github.com/users/kl3jvi/starred{/owner}{/repo}",
        "https://api.github.com/users/kl3jvi/subscriptions",
        "User",
        "https://api.github.com/users/kl3jvi"
    )

    fun mockUserSearchDataList() = listOf(mockUserSearchData())

    fun mockUserDetails() = UserDetails(
        avatarUrl = "https://avatars.githubusercontent.com/u/40796367?v=4",
        bio = "Android and open source software engineer. :rocket: ",
        followers = 53,
        following = 14,
        name = "kl3jvi"
    )
}