package com.google.androidstudio.motionlayoutexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.v4.app.Fragment
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import com.example.nicolasroard.transitionsexample.ui.main.ListFragment
import com.example.nicolasroard.transitionsexample.ui.main.MainFragment
import com.example.nicolasroard.transitionsexample.ui.main.SecondFragment
import kotlinx.android.synthetic.main.main_activity.*

class FragmentExample2Activity : AppCompatActivity(), View.OnClickListener, MotionLayout.TransitionListener {
    override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, progress: Float) {
        if (progress - lastProgress > 0) {
            // from start to end
            var atEnd = Math.abs(progress - 1f) < 0.1f
            if (atEnd && fragment is MainFragment) {
                var transaction = supportFragmentManager.beginTransaction()
                transaction
                        .setCustomAnimations(R.animator.show, 0)
                fragment = ListFragment.newInstance()
//                fragment = SecondFragment.newInstance()
//                (fragment as SecondFragment).setEnterTransition((fragment as SecondFragment).view)
                transaction
                        .replace(R.id.container, fragment)
                        .commitNow()
            }
        } else {
            // from end to start
            var atStart = progress < 0.9f
            if (atStart && fragment is ListFragment) {
                var transaction = supportFragmentManager.beginTransaction()
                transaction
                        .setCustomAnimations(0, R.animator.hide)
                fragment = MainFragment.newInstance()
                transaction
                        .replace(R.id.container, fragment)
                        .commitNow()
            }
        }
        lastProgress = progress
    }

    override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
    }

    var lastProgress = 0f

    var fragment : Fragment? = null
    var last : Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            fragment = MainFragment.newInstance()
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commitNow()
        }
        //toggle.setOnClickListener(this)
        //toggleAnimation.setOnClickListener(this)
        motionLayout.setTransitionListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.toggle) {
            var transaction = supportFragmentManager.beginTransaction()
            fragment = if (fragment == null || fragment is MainFragment) {
                last = 1f
                transaction
                        .setCustomAnimations(R.animator.show, 0)
                SecondFragment.newInstance()
            } else {
                transaction
                        .setCustomAnimations(0, R.animator.hide)
                MainFragment.newInstance()
            }
            transaction
                    .replace(R.id.container, fragment)
                    .commitNow()
        }
    }
}
