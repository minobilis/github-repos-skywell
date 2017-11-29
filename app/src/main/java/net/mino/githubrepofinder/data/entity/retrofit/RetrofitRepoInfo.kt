package net.mino.githubrepofinder.data.datasource.entity

import com.google.gson.annotations.SerializedName

data class RetrofitRepoInfo(
        @SerializedName("total_count")
        val totalCount: Int,
        @SerializedName("incomplete_results")
        val isIncompleteResults: Boolean,
        @SerializedName("items")
        val retrofitItems: List<RetrofitItem>)
