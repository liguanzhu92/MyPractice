package com.chestnut.mypractice.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chestnut.mypractice.data.Article
import com.chestnut.mypractice.databinding.ItemArticleBinding

class ArticleListAdapter:ListAdapter<Article, RecyclerView.ViewHolder>(ArticleDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ArticleViewHolder(
            ItemArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val article = getItem(position)
        (holder as ArticleViewHolder).bind(article)
    }

    class ArticleViewHolder(private val binding:ItemArticleBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(article:Article) {
            binding.apply {
                this.article = article
            }
        }
    }
}

private class ArticleDiffCallback : DiffUtil.ItemCallback<Article>() {

    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}