package com.closer.tnews.article.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
class Article (
        @NonNull
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Int,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "author")
        var author: String,

        @ColumnInfo(name = "content")
        var content: String,

        @ColumnInfo(name = "imageMain")
        var imageMain: Int){

}