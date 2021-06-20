package com.andreisemyonov.randomuserslist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Location(
    @field:Expose @field:SerializedName("city") val city: String,
    @field:Expose @field:SerializedName("country") val country: String
)