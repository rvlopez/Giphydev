package com.example.rviciana.giphydev.search.model.entities

import com.google.gson.annotations.SerializedName

data class Data (
        @SerializedName("data")
        val dataList: MutableList<Gif>
)