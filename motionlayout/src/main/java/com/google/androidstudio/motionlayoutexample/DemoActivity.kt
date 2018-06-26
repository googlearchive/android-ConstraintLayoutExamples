package com.google.androidstudio.motionlayoutexample

import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView

class DemoActivity : AppCompatActivity() {
    var motionLayout : View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = intent.getIntExtra("layout_file_id", R.layout.motion_01_basic)
        setContentView(layout)
        motionLayout = findViewById<View>(R.id.motionLayout)

        if (layout == R.layout.motion_11_coordinatorlayout) {
            var icon = findViewById<ImageView>(R.id.icon)
            icon?.clipToOutline = true
        }

        var doShowPaths = intent.getBooleanExtra("showPaths", false)
        (motionLayout as? MotionLayout)?.setShowPaths(doShowPaths)
    }

    fun changeState(v: View?) {
        if (motionLayout == null || motionLayout !is MotionLayout) {
            return
        }
        var ml = motionLayout as? MotionLayout
        if (ml == null) {
            return
        }
        if (ml.getProgress() > 0.5f) {
            ml.transitionToStart()
        } else {
            ml.transitionToEnd()
        }
    }
}