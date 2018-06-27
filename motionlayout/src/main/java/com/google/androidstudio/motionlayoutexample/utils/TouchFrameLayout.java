package com.google.androidstudio.motionlayoutexample.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.motion.MotionLayout;
import android.support.v4.view.NestedScrollingParent2;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class TouchFrameLayout extends FrameLayout implements NestedScrollingParent2{


    public TouchFrameLayout(@NonNull Context context) {
        super(context);
    }

    public TouchFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NestedScrollingParent2 getMotionLayout() {
        return (NestedScrollingParent2) getParent();
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        return getMotionLayout().onTouchEvent(event);
//    }
//
    @Override
    public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int axes, int type) {
        return getMotionLayout().onStartNestedScroll(child, target, axes, type);
    }

    @Override
    public void onNestedScrollAccepted(@NonNull View child, @NonNull View target, int axes, int type) {
        getMotionLayout().onNestedScrollAccepted(child, target, axes, type);
    }

    @Override
    public void onStopNestedScroll(@NonNull View target, int type) {
        getMotionLayout().onStopNestedScroll(target, type);
    }

    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        getMotionLayout().onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
    }

    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        getMotionLayout().onNestedPreScroll(target, dx, dy, consumed, type);
    }
}
