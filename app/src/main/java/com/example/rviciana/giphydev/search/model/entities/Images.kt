package com.example.rviciana.giphydev.search.model.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Images(
        @SerializedName("fixed_height")
        val fixedHeight: FixedHeight,
        @SerializedName("fixed_height_still")
        val fixedHeightStill: FixedHeightStill,
        @SerializedName("fixed_height_downsampled")
        val fixedHeightDownsampled: FixedHeightDownsampled
) : Serializable