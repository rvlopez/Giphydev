package com.example.rviciana.giphydev.search.model.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FixedHeightDownsampled(
        val url: String,
        val width: String,
        val height: String,
        val size: String,
        val webp: String,
        @SerializedName("webp_size")
        val webpSize: String
) : Serializable