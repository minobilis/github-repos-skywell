package net.mino.githubrepofinder.data.datasource.entity

import com.google.gson.annotations.SerializedName


data class Owner(
        val login: String? = null,
        val id: Int? = null,
        val avatarUrl: String? = null,
        val gravatarId: String? = null,
        val url: String? = null,
        val htmlUrl: String? = null,
        val followersUrl: String? = null,
        val followingUrl: String? = null,
        val gistsUrl: String? = null,
        val starredUrl: String? = null,
        val subscriptionsUrl: String? = null,
        val organizationsUrl: String? = null,
        val reposUrl: String? = null,
        val eventsUrl: String? = null,
        val receivedEventsUrl: String? = null,
        val type: String? = null,
        val isSiteAdmin: Boolean? = null)