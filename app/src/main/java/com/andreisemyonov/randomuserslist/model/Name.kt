package com.andreisemyonov.randomuserslist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Name(
    @field:Expose @field:SerializedName("first") val first: String,
    @field:Expose @field:SerializedName("last") val last: String
)