package com.example.rivu.androidcoroutineexample

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rivu.androidcoroutineexample.data.api.RepoItem
import kotlinx.android.synthetic.main.item_repo.view.tvRepoName
import kotlinx.android.synthetic.main.item_repo.view.tvURL
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

@Suppress("UNCHECKED_CAST")
class RepoListAdapter(
    @LayoutRes private val layoutResId: Int,
    items: List<RepoItem> = emptyList()
) : RecyclerView.Adapter<RepoListAdapter.ViewHolder>() {

    var items = items
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items[position])
    }

    override fun getItemCount() = items.size

    class ViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {

        fun bindData(item: RepoItem) {
            with(itemView) {
                tvRepoName.text = item.name
                tvURL.text = item.url.toString()
            }
        }
    }
}