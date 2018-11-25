package com.example.rivu.androidcoroutineexample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.github.brewin.mvicoroutines.data.Repository

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.rvRepo
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    val job = Job()
    override val coroutineContext: CoroutineContext by lazy {
        Dispatchers.IO + job
    }

    val adapter by lazy {
        RepoListAdapter(R.layout.item_repo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        rvRepo.adapter = adapter

        fab.setOnClickListener { view ->
            loadData(view)
        }

        loadData()
    }

    private fun loadData(view: View = fab) {
        Snackbar.make(view, "Loading", Snackbar.LENGTH_INDEFINITE).show()
        launch {
            val response = Repository.defaultRepository.searchRepos("Kotlin")
            val responseBody = response.body()
            if (response.isSuccessful && responseBody != null) {
                val repolist = responseBody.asRepoItemList
                withContext(Dispatchers.Main) {
                    adapter.items = repolist
                    Snackbar.make(view, "Data Loaded", Snackbar.LENGTH_LONG).show()
                }
            }

        }
    }
}
