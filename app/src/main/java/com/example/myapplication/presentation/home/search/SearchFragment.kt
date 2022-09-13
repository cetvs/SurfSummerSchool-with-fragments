package com.example.myapplication.presentation.home.search

import android.content.Context
import android.os.Bundle
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
    lateinit var mainViewModel: MainViewModel
    lateinit var thisContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        thisContext = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        val backFromSearchImageView = view.findViewById<ImageView>(R.id.back_from_search_iv)
        backFromSearchImageView.setOnClickListener {
            parentFragmentManager.popBackStack("home_fragment", 1)
        }
        val recyclerView = view.findViewById<RecyclerView>(R.id.search_rv)
        val searchRecyclerAdapter = SearchRecyclerAdapter(listOf(), mainViewModel)
        recyclerView?.adapter = searchRecyclerAdapter
        recyclerView?.layoutManager = GridLayoutManager(thisContext, 2)
        recyclerView.addItemDecoration(SpacesItemDecoration(10))
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        if (p0 != null) {
            mainViewModel.liveData.observe(viewLifecycleOwner) { pictureInfoListState ->
                pictureInfoListState.value.filter {
                    it.title.contains(p0)
                }
            }
        }
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        if (p0 != null) {
            mainViewModel.liveData.observe(viewLifecycleOwner) { pictureInfoListState ->
                pictureInfoListState.value.filter {
                    it.title.contains(p0)
                }
            }
        }
        return true
    }

}