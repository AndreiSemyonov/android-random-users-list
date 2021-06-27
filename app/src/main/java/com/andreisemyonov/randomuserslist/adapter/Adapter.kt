package com.andreisemyonov.randomuserslist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andreisemyonov.randomuserslist.R
import com.andreisemyonov.randomuserslist.databinding.UserPhotoViewHolderBinding
import com.andreisemyonov.randomuserslist.model.Result
import com.bumptech.glide.Glide

class Adapter(private val context: Context, private var resultList: List<Result>?) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.user_photo_view_holder, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder) {

            binding.firstName.text = resultList!![position].name.first
            binding.lastName.text = resultList!![position].name.last

            Glide.with(context)
                    .load(resultList!![position].picture.thumbnail)
                    .centerCrop()
                    .circleCrop()
                    .into(binding.imageView)
        }
    }

    override fun getItemCount(): Int {
        return if (resultList != null) {
            resultList!!.size
        } else 0
    }

    fun setUsersList(resultList: List<Result>?) {
        this.resultList = resultList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val binding = UserPhotoViewHolderBinding.bind(itemView)
    }

    interface ItemClickListener {
        fun onClick(view: View?, position: Int)
    }
}