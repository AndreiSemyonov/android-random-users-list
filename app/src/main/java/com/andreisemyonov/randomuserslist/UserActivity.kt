package com.andreisemyonov.randomuserslist

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andreisemyonov.randomuserslist.common.Common
import com.andreisemyonov.randomuserslist.databinding.ActivityUserBinding
import com.bumptech.glide.Glide

class UserActivity : AppCompatActivity(){

    private lateinit var binding: ActivityUserBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.firstName.text = Common.selected_user_first_name
        binding.lastName.text = Common.selected_user_last_name
        binding.age.text = "Age: " + Common.selected_user_age.toString()
        binding.country.text = "Country: " + Common.selected_user_country
        binding.city.text = "City: " + Common.selected_user_city
        binding.email.text = "e-mail: " + Common.selected_user_email

        Glide.with(this)
                .load(Common.selected_user_photo)
                .centerCrop()
                .into(binding.userPhoto)
    }
}