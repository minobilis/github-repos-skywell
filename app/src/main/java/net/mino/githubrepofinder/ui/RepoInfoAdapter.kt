package net.mino.githubrepofinder.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.mino.githubrepofinder.R
import net.mino.githubrepofinder.data.datasource.entity.RoomRepoInfo


class RepoInfoAdapter(private var dataset: MutableList<RoomRepoInfo>) : RecyclerView.Adapter<RepoInfoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.repoFullName.text = dataset[position].repoFullName
        holder.repoHtmlUrl.text = dataset[position].repoHtmlUrl
        holder.repoOwnerName.text = dataset[position].repoOwnerName
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var repoFullName: TextView = v.findViewById(R.id.repoFullName)
        var repoHtmlUrl: TextView = v.findViewById(R.id.repoHtmlUrl)
        var repoOwnerName: TextView = v.findViewById(R.id.repoOwnerName)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun swap(newDataSet: MutableList<RoomRepoInfo>) {
        if (newDataSet.size == 0)
            return
        if (dataset.size > 0)
            dataset.clear()
        dataset.addAll(newDataSet)
        notifyDataSetChanged()
    }
}
