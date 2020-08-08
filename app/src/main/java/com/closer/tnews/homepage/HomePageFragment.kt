package com.closer.tnews.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.closer.tnews.R
import com.closer.tnews.article.adapter.ArticleAdapter
import com.closer.tnews.article.db.ArticleDB
import com.closer.tnews.article.model.Article
import kotlinx.android.synthetic.main.home_page_layout.view.*
import kotlinx.coroutines.Job

class HomePageFragment : Fragment() {

    private var articleAdapter = ArticleAdapter()
    private lateinit var mainView: View
    private var articleDB: ArticleDB? = null
    private lateinit var mJob: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mainView = inflater.inflate(R.layout.home_page_layout, container, false)
        return mainView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var viewArticle = mainView.view_article

        // Layout recycle view
        viewArticle.layoutManager = LinearLayoutManager(activity)
        viewArticle.setHasFixedSize(true)
        viewArticle.itemAnimator = DefaultItemAnimator()
        viewArticle.addItemDecoration(DividerItemDecoration(viewArticle.context, DividerItemDecoration.VERTICAL))

        // Room
        articleDB = ArticleDB.getDatabase(activity!!)

        articleAdapter.getData(ArticleDB.getDatabase(activity!!)?.articleDao().getAll()!! as ArrayList<Article>)
        viewArticle.adapter = articleAdapter
    }

    fun data(): List<Article> {
        ArticleDB.getDatabase(activity!!)?.articleDao().insert(Article(1, "First title", "First author", "First content", R.drawable.ic_search_black_24dp))
        ArticleDB.getDatabase(activity!!)?.articleDao().insert(Article(2, "Second title", "Second author", "Second content", R.drawable.ic_settings_black_24dp))
        return ArticleDB.getDatabase(activity!!)?.articleDao().getAll()!!
    }
}