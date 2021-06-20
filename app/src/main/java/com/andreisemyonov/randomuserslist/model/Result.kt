package com.andreisemyonov.randomuserslist.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
    @field:Expose @field:SerializedName("name") val name: Name,
    @field:Expose @field:SerializedName("location") val location: Location,
    @field:Expose @field:SerializedName("email") val email: String,
    @field:Expose @field:SerializedName("dob") val age: Age,
    @field:Expose @field:SerializedName("picture") val picture: Picture,
)




