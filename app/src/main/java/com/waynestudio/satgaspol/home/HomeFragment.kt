package com.waynestudio.satgaspol.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.waynestudio.satgaspol.MainActivity
import com.waynestudio.satgaspol.R
import com.waynestudio.satgaspol.home.helper.HomeRekapAdapter
import com.waynestudio.satgaspol.home.helper.HomeViewModel
import com.waynestudio.satgaspol.model.Barang
import com.waynestudio.satgaspol.utils.function.debug
import com.waynestudio.satgaspol.utils.function.generateRT
import com.waynestudio.satgaspol.utils.viewmodels.BarangViewModelFactory
import kotlinx.android.synthetic.main.app_bar_snippet.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var viewModel: HomeViewModel
    lateinit var adapter: HomeRekapAdapter

    private var picked : Int = 0
    private var unpicked : Int  = 0
    private var total : Int  = 0

    private val list = arrayListOf<Barang>()

    companion object {
        fun newInstance(): Fragment =
            HomeFragment()

        private fun obtainViewModel(fragmentActivity: FragmentActivity): HomeViewModel {
            val factory = BarangViewModelFactory.getInstance()
            return ViewModelProviders.of(fragmentActivity, factory).get(HomeViewModel::class.java)
        }
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
        action_bar_title.text = view.resources.getString(R.string.beranda)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            debug(this.javaClass.simpleName, "run")
            viewModel = obtainViewModel(activity!!)
            adapter = HomeRekapAdapter(activity!!)

            viewModel.items("D32/22B").observe(viewLifecycleOwner, Observer {
                debug("View Model", "Observer")
                total+= it.qty
                if(it.status == "Diterima"){
                    unpicked += it.qty
                } else if(it.status == "Diambil"){
                    picked += it.qty
                }

                text_item_picked.text = "$picked"
                text_item_unpicked.text = "$unpicked"
                text_item_total.text = "$total"

                item_progress.progress = ((picked.toFloat() / total.toFloat()) * 100f).toInt()
            })

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
