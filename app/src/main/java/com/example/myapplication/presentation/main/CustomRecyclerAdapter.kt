package com.example.myapplication.presentation.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.EntityPictureInfo
import com.example.myapplication.R

class CustomRecyclerAdapter(private val list: List<EntityPictureInfo>) :
    RecyclerView.Adapter<CustomRecyclerAdapter.CustomRecyclerHolder>() {

    inner class CustomRecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.name_tv)
        private val homeImageView: ImageView = itemView.findViewById(R.id.home_image_iv)

        fun bind(entityPictureInfo: EntityPictureInfo) {
            Log.v("mybind", entityPictureInfo.title)
            nameTextView.text = entityPictureInfo.title
            homeImageView.setImageResource(R.drawable.home_test)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomRecyclerHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return CustomRecyclerHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomRecyclerHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}