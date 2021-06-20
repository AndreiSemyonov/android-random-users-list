package com.andreisemyonov.randomuserslist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Example(@field:Expose @field:SerializedName("results") val results: List<Result>)