package com.example.rviciana.giphydev.search.model.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User (
        @SerializedName("avatar_url")
        val avatarUrl: String,
        @SerializedName("banner_url")
        val bannerUrl: String,
        @SerializedName("profile_url")
        val profileUrl: String,
        val username: String,
        @SerializedName("display_name")
        val displayName: String,
        val twitter: String
) : Serializable