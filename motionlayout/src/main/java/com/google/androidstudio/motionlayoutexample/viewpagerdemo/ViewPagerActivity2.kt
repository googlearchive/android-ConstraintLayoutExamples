package com.google.androidstudio.motionlayoutexample.viewpagerdemo

import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.google.androidstudio.motionlayoutexample.R
import kotlinx.android.synthetic.main.motion_16_viewpager.*

class ViewPagerActivity2 : AppCompatActivity() {
    var motionLayout: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = R.layout.motion_23_viewpager
        setContentView(layout)
        motionLayout = findViewById<View>(R.id.motionLayout)

        var adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addPage("Page 1", R.layout.motion_16_viewpager_page1)
        adapter.addPage("Page 2", R.layout.motion_16_viewpager_page2)
        adapter.addPage("Page 3", R.layout.motion_16_viewpager_page3)
        pager.adapter = adapter
        tabs.setupWithViewPager(pager)
        if (motionLayout != null) {
            pager.addOnPageChangeListener(motionLayout as ViewPager.OnPageChangeListener)
        }

        var doShowPaths = intent.getBooleanExtra("showPaths", false)
        (motionLayout as? MotionLayout)?.setShowPaths(doShowPaths)
    }
}