package com.closer.tnews.article.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.closer.tnews.article.dao.ArticleDAO
import com.closer.tnews.article.model.Article

@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class ArticleDB : RoomDatabase() {

    abstract fun articleDao(): ArticleDAO

    companion object {
        private var INSTANCE: ArticleDB? = null
        private val DB_NAME = "article_db"

        fun getDatabase(context: Context): ArticleDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ArticleDB::class.java,
                        DB_NAME
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }

}