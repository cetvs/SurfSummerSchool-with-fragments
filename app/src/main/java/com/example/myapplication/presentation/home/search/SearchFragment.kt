package com.example.myapplication.presentation.home.search

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.presentation.MainViewModel

class SearchFragment : Fragment(), SearchView.OnQueryTextListener {
    //    lateinit var recyclerView: RecyclerView
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
//        mainViewModel.liveData.observe(viewLifecycleOwner) {
//            homeRecyclerAdapter.setData(it.value)
//        }
        searchRecyclerAdapter = SearchRecyclerAdapter(listOf(), mainViewModel)
        val searchView = view.findViewById<SearchView>(R.id.search_sv)
        searchView.setOnQueryTextListener(this)
        parentFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.search_request_result_container, BlankRequestFragment())
            .commit()
    }

    override fun onQueryTextSubmit(str: String?): Boolean {
        if (str == null || str == "") {
            parentFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.search_request_result_container, BlankRequestFragment())
                .commit()
        } else {
            val requestResultList =
                mainViewModel.liveData.value?.value?.filter { it.title.contains(str) }
            if (requestResultList == null || requestResultList.isEmpty()) {
                parentFragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.search_request_result_container, EmptyRequestResultFragment())
                    .commit()
            } else {
                val bundle = bundleOf()
                bundle.putParcelableArrayList("pictureList", ArrayList(requestResultList))
                parentFragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.search_request_result_container,
                        SearchRequestFragment.getNewInstance(bundle))
                    .commit()
            }
        }
        return false
    }

    override fun onQueryTextChange(str: String?): Boolean {
        if (str == null || str == "") {
            parentFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.search_request_result_container, BlankRequestFragment())
                .commit()
        } else {
            val requestResultList =
                mainViewModel.liveData.value?.value?.filter { it.title.contains(str) }
            if (requestResultList == null || requestResultList.isEmpty()) {
                parentFragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.search_request_result_container, EmptyRequestResultFragment())
                    .commit()
            } else {
                val bundle = bundleOf()
                bundle.putParcelableArrayList("pictureList", ArrayList(requestResultList))
                parentFragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.search_request_result_container,
                        SearchRequestFragment.getNewInstance(bundle))
                    .commit()
            }
        }
//        if (str != null) {
//            Log.v("po", str)
//            searchRecyclerAdapter.setData(
//                mainViewModel.liveData.value?.value?.filter { it.title.contains(str) }!!
//            )
//        }
        return false
    }

}