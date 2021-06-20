package com.andreisemyonov.randomuserslist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Age(@field:Expose @field:SerializedName("age") val age: Int)

