/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.androidstudio.motionlayoutexample.youtubedemo

import android.os.Bundle
import android.support.constraint.motion.MotionLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.google.androidstudio.motionlayoutexample.Consts
import com.google.androidstudio.motionlayoutexample.R

class YouTubeDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.motion_24_youtube)
        val motionLayout = findViewById<MotionLayout>(R.id.motionLayout).apply {
            savedInstanceState
        }
        findViewById<RecyclerView>(R.id.recyclerview_front).apply {
            adapter = FrontPhotosAdapter()
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@YouTubeDemoActivity)
        }
        val doShowPaths = intent.getBooleanExtra("showPaths", false)
        motionLayout.setDebugMode(if (doShowPaths) Consts.SHOW_PATHS else 0)
    }
}