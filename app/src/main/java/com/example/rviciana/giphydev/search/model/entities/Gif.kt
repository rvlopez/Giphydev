package com.example.rviciana.giphydev.search.model.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Gif (
        val type: String,
        val id: String,
        val slug: String,
        val url: String,
        @SerializedName("bitly_url")
        val bitlyUrl: String,
        @SerializedName("embed_url")
        val embedUrl: String,
        val username: String,
        val source: String,
        val rating: String,
        @SerializedName("content_url")
        val contentUrl: String,
        val user: User,
        @SerializedName("source_post_url")
        val sourcePostUrl: String,
        @SerializedName("update_datetime")
        val updateDatetime: String,
        @SerializedName("create_datetime")
        val createDatetime: String,
        @SerializedName("import_datetime")
        val importDatetime: String,
        @SerializedName("trending_datetime")
        val trendingDatetime: String,
        val images: Images,
        val title: String
) : Serializable