package com.andreisemyonov.randomuserslist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Picture(
    @field:Expose @field:SerializedName("large") val large: String,
    @field:Expose @field:SerializedName("thumbnail") val thumbnail: String
)
