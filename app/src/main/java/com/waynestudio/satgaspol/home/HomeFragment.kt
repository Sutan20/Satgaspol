package com.waynestudio.satgaspol.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.waynestudio.satgaspol.R
import com.waynestudio.satgaspol.helper.debug
import com.waynestudio.satgaspol.home.helper.HomeRekapAdapter
import com.waynestudio.satgaspol.helper.generateRT
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var adapter: HomeRekapAdapter

    companion object {
        fun newInstance(): Fragment =
            HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        progress_bar.visibility = View.VISIBLE
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
//            viewModel = obtainViewModel(activity!!)
            adapter = HomeRekapAdapter(activity!!)

//            viewModel.movies.observe(this, Observer { movie ->
//                progress_bar.visibility = View.GONE
//                adapter.addMovie(movie)
//            })

            val snapHelper = LinearSnapHelper()
            snapHelper.attachToRecyclerView(recyclerRt)

            for (rt in generateRT())
                adapter.addRT(rt)

            recyclerRt.layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            recyclerRt.setHasFixedSize(true)
            recyclerRt.adapter = adapter
        }
    }
}
