/*
 * Copyright (C) 2017 The Android Open Source Project
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

package com.google.androidstudio.motionlayoutexample.helpers

import android.animation.ObjectAnimator
import android.content.Context
import android.support.constraint.ConstraintHelper
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.animation.BounceInterpolator

class ExampleFlyinBounceHelper : ConstraintHelper {
    private var mContainer: ConstraintLayout? = null;

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    /**
     * @param container
     * @hide
     */
    override fun updatePreLayout(container: ConstraintLayout) {
        if (mContainer != null && mContainer != container) {
            val views = getViews(container)
            for (i in 0 until mCount) {
                val view = views[i]
                val animator = ObjectAnimator.ofFloat(view, "translationX", -2000f, 0f)
                animator.interpolator = BounceInterpolator()
                animator.start()
            }
        }
        mContainer = container
    }
}
