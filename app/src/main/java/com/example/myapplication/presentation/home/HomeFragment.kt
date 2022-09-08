package com.example.myapplication.presentation.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.EntityPictureInfo
import com.example.myapplication.R
import com.example.myapplication.presentation.common.SpacesItemDecoration
import com.example.myapplication.presentation.main.CustomRecyclerAdapter

class HomeFragment : Fragment() {
    lateinit var customRecyclerAdapter : CustomRecyclerAdapter
    lateinit var recyclerView : RecyclerView
    lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.home_rv)
//        val customRecyclerAdapter = CustomRecyclerAdapter(viewModel.getExampleMovie())

        val ent = EntityPictureInfo("1", "картин", "32", "#2", 1,"1")
        val lst = listOf<EntityPictureInfo>(ent, ent.copy(id = "2"), ent.copy(id = "3"), ent.copy(id = "4"))
        val customRecyclerAdapter = CustomRecyclerAdapter(lst)

        recyclerView?.adapter = customRecyclerAdapter
        recyclerView?.layoutManager = GridLayoutManager(mContext, 2)
        recyclerView.addItemDecoration(SpacesItemDecoration(10))
    }
}