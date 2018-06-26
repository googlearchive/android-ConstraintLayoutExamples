package com.google.androidstudio.motionlayoutexample

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.androidstudio.motionlayoutexample.fragmentsdemo.CustomAdapter

class ItemFragment : Fragment() {

    companion object {
        fun newInstance() = ItemFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.item_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private lateinit var myHolder: CustomAdapter.ViewHolder

    fun update(holder: CustomAdapter.ViewHolder) {
        myHolder = holder
        view?.findViewById<TextView>(R.id.txtTitle)?.text = holder.txtTitle.text
        view?.findViewById<TextView>(R.id.txtName)?.text = holder.txtName.text
    }

    override fun onStart() {
        super.onStart()
        if (myHolder != null) {
            update(myHolder)
        }
    }
}