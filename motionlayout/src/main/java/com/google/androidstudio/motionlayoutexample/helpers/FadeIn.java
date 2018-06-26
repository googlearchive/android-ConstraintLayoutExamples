package com.google.androidstudio.motionlayoutexample.helpers;

import android.content.Context;
import android.support.constraint.motion.MotionHelper;
import android.util.AttributeSet;
import android.view.View;

public class FadeIn extends MotionHelper {

    public FadeIn(Context context) {
        super(context);
    }

    public FadeIn(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FadeIn(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setProgress(View view, float progress) {
        view.setAlpha(progress);
    }
}
