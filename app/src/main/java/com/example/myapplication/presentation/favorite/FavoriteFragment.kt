package com.example.myapplication.presentation.favorite

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.home.HomeRecyclerAdapter

class FavoriteFragment : Fragment() {
    lateinit var favoriteRecyclerAdapter: HomeRecyclerAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var mainViewModel: MainViewModel
    lateinit var thisContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        thisContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.favorite_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.favorite_rv)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        favoriteRecyclerAdapter = HomeRecyclerAdapter(listOf(), mainViewModel)
        recyclerView?.adapter = favoriteRecyclerAdapter
        recyclerView?.layoutManager =
            LinearLayoutManager(thisContext, LinearLayoutManager.VERTICAL, false)
        mainViewModel.liveData.observe(viewLifecycleOwner) {
            favoriteRecyclerAdapter.setData(it.value.filter { entityPictureInfo ->
                entityPictureInfo.favoriteDate != null
            })
        }
    }
}