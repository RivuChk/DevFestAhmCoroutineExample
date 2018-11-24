package com.github.brewin.mvicoroutines.data

import com.example.rivu.androidcoroutineexample.data.api.GitHubApi
import com.example.rivu.androidcoroutineexample.data.api.RepoItem


class Repository(private val gitHubApi: GitHubApi) {

    suspend fun searchRepos(query: String): List<RepoItem> =
        gitHubApi.searchRepos(query).await().asRepoItemList

    companion object {
        @JvmStatic
        val defaultRepository = Repository(GitHubApi.api)
    }
}