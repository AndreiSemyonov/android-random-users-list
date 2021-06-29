package com.andreisemyonov.randomuserslist.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andreisemyonov.randomuserslist.R
import com.andreisemyonov.randomuserslist.UserActivity
import com.andreisemyonov.randomuserslist.common.Common
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

        holder.setItemClickListener(object : ItemClickListener {

            override fun onClick(view: View?, position: Int) {

                Common.selected_user_photo = resultList!![position].picture.large
                Common.selected_user_first_name = resultList!![position].name.first
                Common.selected_user_last_name = resultList!![position].name.last
                Common.selected_user_age = resultList!![position].age.age
                Common.selected_user_country = resultList!![position].location.country
                Common.selected_user_city = resultList!![position].location.city
                Common.selected_user_email = resultList!![position].email

                val intent = Intent(context, UserActivity::class.java)

                context.startActivity(intent)
            }
        })
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

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        val binding = UserPhotoViewHolderBinding.bind(itemView)

        private var itemClickListener: ItemClickListener? = null

        fun setItemClickListener(itemClickListener: ItemClickListener) {
            this.itemClickListener = itemClickListener
        }

        override fun onClick(v: View) {
            itemClickListener?.onClick(v, adapterPosition)
        }

        init {
            itemView.setOnClickListener(this)
        }
    }

    interface ItemClickListener {
        fun onClick(view: View?, position: Int)
    }
}