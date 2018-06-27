package com.example.nicolasroard.transitionsexample.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.androidstudio.motionlayoutexample.fragmentsdemo.CustomAdapter
import com.google.androidstudio.motionlayoutexample.MainViewModel
import com.google.androidstudio.motionlayoutexample.R
import com.google.androidstudio.motionlayoutexample.User

class ListFragment : Fragment() {

    private lateinit var motionLayout: MotionLayout
    private lateinit var recyclerView: RecyclerView

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        System.out.println("onCreateView, container is " + container)
        return inflater.inflate(R.layout.motion_22_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        motionLayout = view.findViewById(R.id.main)
        recyclerView = view.findViewById<RecyclerView>(R.id.list)

        recyclerView.layoutManager = LinearLayoutManager(
                context, LinearLayout.VERTICAL, false)
        val users = ArrayList<User>()
        users.add(User("Paul", "Mr"))
        users.add(User("Jane", "Miss"))
        users.add(User("John", "Dr"))
        users.add(User("Amy", "Mrs"))
        users.add(User("Paul", "Mr"))
        users.add(User("Jane", "Miss"))
        users.add(User("John", "Dr"))
        users.add(User("Amy", "Mrs"))
        users.add(User("Paul", "Mr"))
        users.add(User("Jane", "Miss"))
        users.add(User("John", "Dr"))
        users.add(User("Amy", "Mrs"))
        users.add(User("Paul", "Mr"))
        users.add(User("Jane", "Miss"))
        users.add(User("John", "Dr"))
        users.add(User("Amy", "Mrs"))

        var adapter = CustomAdapter(users)
        recyclerView.adapter = adapter

        super.onViewCreated(view, savedInstanceState)
    }
}
