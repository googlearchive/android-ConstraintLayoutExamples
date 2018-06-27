package com.example.nicolasroard.transitionsexample.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.androidstudio.motionlayoutexample.MainViewModel
import com.google.androidstudio.motionlayoutexample.R

class SecondFragment : Fragment() {

    private lateinit var motionLayout: MotionLayout

    companion object {
        fun newInstance() = SecondFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.motion_21_second_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        motionLayout = view.findViewById(R.id.main)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        System.out.println("onStart of fragment...")
//        motionLayout.transitionToEnd()
    }

    override fun onPause() {
        super.onPause()
//        motionLayout.transitionToStart()
    }
}
