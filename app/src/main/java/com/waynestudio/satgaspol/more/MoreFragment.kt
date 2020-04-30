package com.waynestudio.satgaspol.more

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.waynestudio.satgaspol.R
import com.waynestudio.satgaspol.helper.generateMenu
import com.waynestudio.satgaspol.helper.generateRT
import com.waynestudio.satgaspol.home.helper.HomeRekapAdapter
import com.waynestudio.satgaspol.more.helper.MoreAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_more.*

/**
 * A simple [Fragment] subclass.
 */
class MoreFragment : Fragment() {

    lateinit var adapter : MoreAdapter

    companion object {
        fun newInstance(): Fragment =
            MoreFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        progress_bar.visibility = View.VISIBLE
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
//            viewModel = obtainViewModel(activity!!)
            adapter = MoreAdapter(generateMenu())

//            viewModel.movies.observe(this, Observer { movie ->
//                progress_bar.visibility = View.GONE
//                adapter.addMovie(movie)
//            })

            recyclerMore.layoutManager = LinearLayoutManager(
                context
            )

            recyclerMore.setHasFixedSize(true)
            recyclerMore.adapter = adapter
        }
    }
}
