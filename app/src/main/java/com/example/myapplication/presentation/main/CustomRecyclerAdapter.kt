package com.example.myapplication.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CustomRecyclerAdapter(private val list: List<Int>){
//    : RecyclerView.Adapter<CustomRecyclerAdapter.CustomRecyclerHolder>(){
//
//    inner class CustomRecyclerHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        private val nameTextView: TextView = itemView.findViewById(R.id.name_tv)
//        private val descriptionTextView: TextView = itemView.findViewById(R.id.name_tv)
//
//        fun bind(movie: Movie){
//            nameTextView.text = movie.name
//            descriptionTextView.text = movie.description
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomRecyclerHolder {
//        val itemView = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_layout, parent, false)
//        return CustomRecyclerHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: CustomRecyclerHolder, position: Int) {
//        holder.bind(list[position])
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
}