package com.example.myapplication.presentation.home.search

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.presentation.MainViewModel
import com.example.myapplication.presentation.common.SpacesItemDecoration

class SearchFragment : Fragment(), SearchView.OnQueryTextListener {
    lateinit var recyclerView: RecyclerView
    private lateinit var searchRecyclerAdapter: SearchRecyclerAdapter
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
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        val backFromSearchImageView = view.findViewById<ImageView>(R.id.back_from_search_iv)
        backFromSearchImageView.setOnClickListener {
            parentFragmentManager.popBackStack("home_fragment", 1)
        }
        recyclerView = view.findViewById(R.id.search_rv)
        searchRecyclerAdapter = SearchRecyclerAdapter(listOf(), mainViewModel)
        recyclerView.adapter = searchRecyclerAdapter
        recyclerView.layoutManager = GridLayoutManager(thisContext, 2)
        recyclerView.addItemDecoration(SpacesItemDecoration(10))

        val searchView = view.findViewById<SearchView>(R.id.search_sv)
        searchView.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(str: String?): Boolean {
        if (str != null) {
            searchRecyclerAdapter.setData(
                mainViewModel.liveData.value?.value?.filter { it.title.contains(str) }!!
            )
        }
        return false
    }

    override fun onQueryTextChange(str: String?): Boolean {
        if (str != null) {
            Log.v("po", str)
            searchRecyclerAdapter.setData(
                mainViewModel.liveData.value?.value?.filter { it.title.contains(str) }!!
            )
        }
        return false
    }

}