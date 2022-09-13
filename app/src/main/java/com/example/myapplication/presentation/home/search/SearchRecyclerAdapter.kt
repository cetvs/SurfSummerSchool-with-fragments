package com.example.myapplication.presentation.home.search

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.EntityPictureInfo
import com.example.myapplication.R
import com.example.myapplication.presentation.MainViewModel
import com.squareup.picasso.Picasso
import java.time.LocalDate

class SearchRecyclerAdapter(
    private var list: List<EntityPictureInfo>,
    var mainViewModel: MainViewModel,
) : RecyclerView.Adapter<SearchRecyclerAdapter.CustomRecyclerHolder>() {

    inner class CustomRecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.name_tv)
        private val homeImageView: ImageView = itemView.findViewById(R.id.favorite_image_iv)
        private val favImageView: ImageView = itemView.findViewById(R.id.favorite_iv)

        fun bind(pictureInfo: EntityPictureInfo) {
            nameTextView.text = pictureInfo.title
            Picasso.get().load(pictureInfo.photoUrl).into(homeImageView)
            if (pictureInfo.favoriteDate == null) {
                favImageView.setImageResource(R.drawable.ic_unfavorite)
            } else {
                favImageView.setImageResource(R.drawable.ic_favorite)
            }
            favImageView.setOnClickListener {
                val favoriteImageView = itemView.findViewById<ImageView>(R.id.favorite_iv)
                if (pictureInfo.favoriteDate == null) {
                    favoriteImageView.setImageResource(R.drawable.ic_favorite)
                    val localDate = LocalDate.now()
                    val date = java.sql.Date.valueOf(localDate.toString())
                    mainViewModel.updateFavoriteInfo(pictureInfo.copy(favoriteDate = date))
                } else {
                    favoriteImageView?.setImageResource(R.drawable.ic_unfavorite)
                    mainViewModel.updateFavoriteInfo(pictureInfo.copy(favoriteDate = null))
                }
            }
        }
    }

    fun setData(lst: List<EntityPictureInfo>) {
        list = lst
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomRecyclerHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_adapter_layout, parent, false)
        return CustomRecyclerHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomRecyclerHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}