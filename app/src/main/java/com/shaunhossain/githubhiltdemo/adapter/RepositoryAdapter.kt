package com.shaunhossain.githubhiltdemo.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shaunhossain.githubhiltdemo.R
import com.shaunhossain.githubhiltdemo.model.GitHubDataModelItem
import kotlinx.android.synthetic.main.item_repository_preview.view.*

@Suppress("DEPRECATION")
class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallBack = object : DiffUtil.ItemCallback<GitHubDataModelItem>(){
        override fun areItemsTheSame(oldItem: GitHubDataModelItem, newItem: GitHubDataModelItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GitHubDataModelItem, newItem: GitHubDataModelItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_repository_preview,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        val gitHubDataModelItem = differ.currentList[position]

        holder.itemView.apply {
            try {
                Glide.with(this)
                    .load(gitHubDataModelItem.owner.avatarUrl)
                    .override(100, 70)
                    .placeholder(R.drawable.error_thum)
                    .error(R.drawable.error_thum)
                    .centerCrop()
                    .into(user_avatar)
            } catch (t : Throwable){
                user_avatar.setImageResource(R.drawable.error_thum)
            }

            user_name.text = gitHubDataModelItem.owner.login
            project_name.text = "Repos : ${gitHubDataModelItem.fullName}"
            project_description.text = "Description : ${gitHubDataModelItem.description}"
        }

        }

}