package com.github.brewin.mvicoroutines.data

import com.example.rivu.androidcoroutineexample.data.api.GitHubApi
import com.example.rivu.androidcoroutineexample.data.api.RepoItem
import retrofit2.Response

class Repository(private val gitHubApi: GitHubApi) {

    suspend fun searchRepos(query: String): Response<GitHubRepos> =
        gitHubApi.searchRepos(query).await()

    companion object {
        @JvmStatic
        val defaultRepository = Repository(GitHubApi.api)
    }
}