package com.closer.tnews.article.dao

import androidx.room.*
import com.closer.tnews.article.model.Article

@Dao
interface ArticleDAO {

    @Query("select * from article")
    fun getAll(): List<Article>

    @Query("select * from article where id = :id")
    fun findById(id: Int): Article

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(article: Article)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun update(article: Article)

    @Delete
    fun delete(article: Article)

}