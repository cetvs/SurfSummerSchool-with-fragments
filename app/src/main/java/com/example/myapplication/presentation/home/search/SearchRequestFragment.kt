package com.example.myapplication.presentation.home.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.EntityPictureInfo
import com.example.domain.model.PictureInfo
import com.example.myapplication.R
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.common.SpacesItemDecoration

class SearchRequestFragment(val pictureList: List<EntityPictureInfo>) : Fragment() {
    lateinit var recyclerView: RecyclerView
    private lateinit var searchRecyclerAdapter: SearchRecyclerAdapter
    lateinit var mainViewModel: MainViewModel
    lateinit var thisContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        thisContext = context
    }

    companion object {
        fun getNewInstance(bundle: Bundle): Fragment {
            val pictureList = bundle.get("pictureList") as List<EntityPictureInfo>
            return SearchRequestFragment(pictureList)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.search_request_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.search_rv)
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        searchRecyclerAdapter = SearchRecyclerAdapter(pictureList, mainViewModel)
        recyclerView.adapter = searchRecyclerAdapter
        recyclerView.layoutManager = GridLayoutManager(thisContext, 2)
        recyclerView.addItemDecoration(SpacesItemDecoration(10))
    }

}