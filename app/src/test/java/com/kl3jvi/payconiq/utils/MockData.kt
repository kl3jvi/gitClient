package com.kl3jvi.payconiq.utils

import com.kl3jvi.payconiq.data.remote.dto.UserDetailsDto
import com.kl3jvi.payconiq.data.remote.dto.UserSearchedDataDto
import com.kl3jvi.payconiq.domain.model.UserDetails
import com.kl3jvi.payconiq.domain.model.UserSearchedData

object MockData {
    /**
     * Search Details mock data
     */

    fun mockUserSearchData() = UserSearchedData(
        "kl3jvi",
        "https://avatars.githubusercontent.com/u/40796367?v=4"
    )

    fun mockUserSearchDataDto() = UserSearchedDataDto(
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
    fun mockUserSearchDataListDto() = listOf(mockUserSearchDataDto())


    /**
     * User Details mock data
     */
    fun mockUserDetails() = UserDetails(
        avatarUrl = "https://avatars.githubusercontent.com/u/40796367?v=4",
        bio = "Android and open source software engineer. :rocket: ",
        followers = 53,
        following = 14,
        name = "Klejvi Kapaj",
    )

    fun mockUserDetailsDto() = UserDetailsDto(
        avatarUrl = "https://avatars.githubusercontent.com/u/40796367?v=4",
        bio = "Android and open source software engineer. :rocket: ",
        blog = "",
        company = "@EpicGames",
        createdAt = "2018-07-03T12:38:07Z",
        email = null,
        eventsUrl = "https://api.github.com/users/kl3jvi/events{/privacy}",
        following = 14,
        followersUrl = "https://api.github.com/users/kl3jvi/followers",
        followingUrl = "https://api.github.com/users/kl3jvi/following{/other_user}",
        gistsUrl = "https://api.github.com/users/kl3jvi/gists{/gist_id}",
        gravatarId = "",
        hireable = true,
        htmlUrl = "https://github.com/kl3jvi",
        id = 40796367,
        followers = 53,
        location = "Tirane, Albania",
        login = "kl3jvi",
        name = "Klejvi Kapaj",
        nodeId = "MDQ6VXNlcjQwNzk2MzY3",
        organizationsUrl = "https://api.github.com/users/kl3jvi/orgs",
        publicGists = 0,
        publicRepos = 53,
        receivedEventsUrl = "https://api.github.com/users/kl3jvi/received_events",
        reposUrl = "https://api.github.com/users/kl3jvi/repos",
        siteAdmin = false,
        starredUrl = "https://api.github.com/users/kl3jvi/starred{/owner}{/repo}",
        subscriptionsUrl = "https://api.github.com/users/kl3jvi/subscriptions",
        twitterUsername = "kl3jvi",
        type = "User",
        updatedAt = "2022-03-21T15:53:06Z",
        url = "https://api.github.com/users/kl3jvi",
    )


}