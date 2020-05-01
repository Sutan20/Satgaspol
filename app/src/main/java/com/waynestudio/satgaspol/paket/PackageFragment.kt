package com.waynestudio.satgaspol.paket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.waynestudio.satgaspol.R
import com.waynestudio.satgaspol.home.HomeFragment
import com.waynestudio.satgaspol.home.helper.HomeViewModel
import com.waynestudio.satgaspol.utils.function.generateBarang
import com.waynestudio.satgaspol.paket.helper.PackageAdapter
import com.waynestudio.satgaspol.utils.function.debug
import com.waynestudio.satgaspol.utils.viewmodels.BarangViewModelFactory
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_package.*
import kotlinx.android.synthetic.main.fragment_package.item_progress
import kotlinx.android.synthetic.main.fragment_package.text_item_picked
import kotlinx.android.synthetic.main.fragment_package.text_item_total
import kotlinx.android.synthetic.main.fragment_package.text_item_unpicked


/**
 * A simple [Fragment] subclass.
 */
class PackageFragment : Fragment() {

    private lateinit var adapter : PackageAdapter
    private lateinit var viewModel : HomeViewModel

    private var picked : Int = 0
    private var unpicked : Int  = 0
    private var total : Int  = 0

    companion object {
        fun newInstance(): Fragment =
            PackageFragment()

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
        return inflater.inflate(R.layout.fragment_package, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        progress_bar.visibility = View.VISIBLE
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null) {
            debug(this.javaClass.simpleName, "run")
            viewModel = obtainViewModel(activity!!)
            adapter = PackageAdapter(activity!!)

            viewModel.items("D32/22B").observe(viewLifecycleOwner, Observer {
                debug("View Model", "Observer")

                total+= it.qty
                if(it.status == "Diterima"){
                    unpicked += it.qty
                    adapter.addBarang(it)
                } else if(it.status == "Diambil"){
                    picked += it.qty
                }

                text_item_picked.text = "$picked"
                text_item_unpicked.text = "$unpicked"
                text_item_total.text = "$total"

                item_progress.progress = ((picked.toFloat() / total.toFloat()) * 100f).toInt()

                if(adapter.list.size == 0){
                    text_status_paket.visibility = View.VISIBLE
                    recyclerPackage.visibility = View.GONE
                } else {
                    text_status_paket.visibility = View.GONE
                    recyclerPackage.visibility = View.VISIBLE
                }
            })

            recyclerPackage.layoutManager = LinearLayoutManager(
                context
            )

            recyclerPackage.setHasFixedSize(true)
            recyclerPackage.adapter = adapter
        }
    }

}
