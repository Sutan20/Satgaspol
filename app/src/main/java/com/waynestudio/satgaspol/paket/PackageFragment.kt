package com.waynestudio.satgaspol.paket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.waynestudio.satgaspol.R
import com.waynestudio.satgaspol.helper.generateBarang
import com.waynestudio.satgaspol.home.helper.HomeRekapAdapter
import com.waynestudio.satgaspol.paket.helper.PackageAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_package.*


/**
 * A simple [Fragment] subclass.
 */
class PackageFragment : Fragment() {

    private lateinit var adapter : PackageAdapter

    companion object {
        fun newInstance(): Fragment =
            PackageFragment()
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
            adapter = PackageAdapter(activity!!)

            for(b in generateBarang()){
                adapter.addBarang(b)
            }

            if(adapter.list.size == 0){
                text_status_paket.visibility = View.VISIBLE
                recyclerPackage.visibility = View.GONE
            } else {
                text_status_paket.visibility = View.GONE
                recyclerPackage.visibility = View.VISIBLE
            }

            recyclerPackage.layoutManager = LinearLayoutManager(
                context
            )

            recyclerPackage.setHasFixedSize(true)
            recyclerPackage.adapter = adapter
        }
    }

}
