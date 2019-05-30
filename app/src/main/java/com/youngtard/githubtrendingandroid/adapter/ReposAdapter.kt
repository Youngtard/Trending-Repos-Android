package com.youngtard.githubtrendingandroid.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.youngtard.githubtrendingandroid.MainActivity
import com.youngtard.githubtrendingandroid.R
import com.youngtard.githubtrendingandroid.RepoDetailActivity
import com.youngtard.githubtrendingandroid.model.Repo
import kotlinx.android.synthetic.main.trending_list_item.view.*

class ReposAdapter(reposData: List<Repo>): RecyclerView.Adapter<ReposAdapter.ReposViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
        val vh = LayoutInflater.from(parent.context).inflate(R.layout.trending_list_item, parent, false)

        return ReposViewHolder(vh)
    }

    override fun getItemCount() = reposData.size

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        holder.bind(reposData[position])
    }

    class ReposViewHolder(val listItem: View): RecyclerView.ViewHolder(listItem) {

        fun bind(repo: Repo) {
            listItem.tv_repo_full_name.text = repo.full_name
            listItem.tv_repo_description.text = repo.description
            listItem.tv_language.text = repo.language
            listItem.tv_no_of_stars.text = repo.stargazers_count.toString()

            listItem.setOnClickListener {
                val intent = Intent(listItem.context, RepoDetailActivity::class.java)

                intent.putExtra("avatar_url", repo.owner.avatar_url)
                intent.putExtra("username", repo.owner.login)
                intent.putExtra("repo_name", repo.name)
                intent.putExtra("description", repo.description)
                intent.putExtra("stars", repo.stargazers_count.toString())


                listItem.context.startActivity(intent)
            }
        }

    }

    var reposData: List<Repo> = reposData
        set(tasks) {
            field = tasks
            notifyDataSetChanged()
        }
}