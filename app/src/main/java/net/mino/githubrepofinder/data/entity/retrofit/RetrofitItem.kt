package net.mino.githubrepofinder.data.datasource.entity

import com.google.gson.annotations.SerializedName


data class RetrofitItem(
        @SerializedName("id")
        val id: Int? = null,
        @SerializedName("name")
        val name: String? = null,
        @SerializedName("full_name")
        val fullName: String? = null,
        @SerializedName("owner")
        val retrofitOwner: RetrofitOwner? = null,
        @SerializedName("private")
        val isPrivate: Boolean? = null,
        @SerializedName("html_url")
        val htmlUrl: String? = null,
        @SerializedName("description")
        val description: String? = null,
        @SerializedName("fork")
        val isFork: Boolean? = null,
        @SerializedName("url")
        val url: String? = null,
        @SerializedName("forks_url")
        val forksUrl: String? = null,
        @SerializedName("keys_url")
        val keysUrl: String? = null,
        @SerializedName("collaborators_url")
        val collaboratorsUrl: String? = null,
        @SerializedName("teams_url")
        val teamsUrl: String? = null,
        @SerializedName("hooks_url")
        val hooksUrl: String? = null,
        @SerializedName("issue_events_url")
        val issueEventsUrl: String? = null,
        @SerializedName("events_url")
        val eventsUrl: String? = null,
        @SerializedName("assignees_url")
        val assigneesUrl: String? = null,
        @SerializedName("branches_url")
        val branchesUrl: String? = null,
        @SerializedName("tags_url")
        val tagsUrl: String? = null,
        @SerializedName("blobs_url")
        val blobsUrl: String? = null,
        @SerializedName("git_tags_url")
        val gitTagsUrl: String? = null,
        @SerializedName("git_refs_url")
        val gitRefsUrl: String? = null,
        @SerializedName("trees_url")
        val treesUrl: String? = null,
        @SerializedName("statuses_url")
        val statusesUrl: String? = null,
        @SerializedName("languages_url")
        val languagesUrl: String? = null,
        @SerializedName("stargazers_url")
        val stargazersUrl: String? = null,
        @SerializedName("contributors_url")
        val contributorsUrl: String? = null,
        @SerializedName("subscribers_url")
        val subscribersUrl: String? = null,
        @SerializedName("subscription_url")
        val subscriptionUrl: String? = null,
        @SerializedName("commits_url")
        val commitsUrl: String? = null,
        @SerializedName("git_commits_url")
        val gitCommitsUrl: String? = null,
        @SerializedName("comments_url")
        val commentsUrl: String? = null,
        @SerializedName("issue_comment_url")
        val issueCommentUrl: String? = null,
        @SerializedName("contents_url")
        val contentsUrl: String? = null,
        @SerializedName("compare_url")
        val compareUrl: String? = null,
        @SerializedName("merges_url")
        val mergesUrl: String? = null,
        @SerializedName("archive_url")
        val archiveUrl: String? = null,
        @SerializedName("downloads_url")
        val downloadsUrl: String? = null,
        @SerializedName("issues_url")
        val issuesUrl: String? = null,
        @SerializedName("pulls_url")
        val pullsUrl: String? = null,
        @SerializedName("milestones_url")
        val milestonesUrl: String? = null,
        @SerializedName("notifications_url")
        val notificationsUrl: String? = null,
        @SerializedName("labels_url")
        val labelsUrl: String? = null,
        @SerializedName("releases_url")
        val releasesUrl: String? = null,
        @SerializedName("deployments_url")
        val deploymentsUrl: String? = null,
        @SerializedName("created_at")
        val createdAt: String? = null,
        @SerializedName("updated_at")
        val updatedAt: String? = null,
        @SerializedName("pushed_at")
        val pushedAt: String? = null,
        @SerializedName("git_url")
        val gitUrl: String? = null,
        @SerializedName("ssh_url")
        val sshUrl: String? = null,
        @SerializedName("clone_url")
        val cloneUrl: String? = null,
        @SerializedName("svn_url")
        val svnUrl: String? = null,
        @SerializedName("homepage")
        val homepage: String? = null,
        @SerializedName("size")
        val size: Int? = null,
        @SerializedName("stargazers_count")
        val stargazersCount: Int? = null,
        @SerializedName("watchers_count")
        val watchersCount: Int? = null,
        @SerializedName("language")
        val language: String? = null,
        @SerializedName("has_issues")
        val isHasIssues: Boolean? = null,
        @SerializedName("has_projects")
        val isHasProjects: Boolean? = null,
        @SerializedName("has_downloads")
        val isHasDownloads: Boolean,
        @SerializedName("has_wiki")
        val isHasWiki: Boolean,
        @SerializedName("has_pages")
        val isHasPages: Boolean,
        @SerializedName("forks_count")
        val forksCount: Int,
        @SerializedName("mirror_url")
        val mirrorUrl: Any,
        @SerializedName("archived")
        val isArchived: Boolean,
        @SerializedName("open_issues_count")
        val openIssuesCount: Int,
        @SerializedName("forks")
        val forks: Int,
        @SerializedName("open_issues")
        val openIssues: Int,
        @SerializedName("watchers")
        val watchers: Int,
        @SerializedName("default_branch")
        val defaultBranch: String,
        @SerializedName("score")
        val score: Double)