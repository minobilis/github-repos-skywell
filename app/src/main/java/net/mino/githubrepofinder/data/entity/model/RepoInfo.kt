package net.mino.githubrepofinder.data.datasource.entity

data class RepoInfo(
        val totalCount: Int? = null,
        val isIncompleteResults: Boolean? = null,
        val retrofitItems: List<RetrofitItem>? = null)
