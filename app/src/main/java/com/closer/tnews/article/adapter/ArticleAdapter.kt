package com.closer.tnews.article.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.closer.tnews.R
import com.closer.tnews.article.model.Article
import kotlinx.android.synthetic.main.article_item_layout.view.*

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    private var listArticle = ArrayList<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.article_item_layout, null))
    }

    override fun getItemCount(): Int {
        return if(listArticle.size > 0) listArticle.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.onBind(listArticle.get(position))
    }

    fun getData(listItem: ArrayList<Article>){
        this.listArticle = listItem
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(article: Article){
            itemView.imageMain.setBackgroundResource(article.imageMain)
            itemView.title.text = article.title
            itemView.author.text = article.author
        }

    }
}