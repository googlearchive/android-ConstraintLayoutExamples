package com.google.androidstudio.motionlayoutexample.helpers;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.constraint.ConstraintHelper;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

public class ExampleFlyinBounceHelper extends ConstraintHelper {
    float myFlyValue = 1;
    protected ConstraintLayout mContainer;
    private static final String TAG = "Layer";
    private float mCenterX = 0; //Float.NaN;
    private float mCenterY = 0; //Float.NaN;
    private float mComputedCenterX = Float.NaN;
    private float mComputedCenterY = Float.NaN;

    public ExampleFlyinBounceHelper(Context context) {
        super(context);
    }

    public ExampleFlyinBounceHelper(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExampleFlyinBounceHelper(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * @param container
     * @hide
     */
//    @Override
//    public void updatePostLayout(ConstraintLayout container) {
//        update();
//    }
//    void update(){
//        if (mContainer == null) {
//            return;
//        }
//        mComputedCenterX = Float.NaN;
//        mComputedCenterY = Float.NaN;
//
//        View[] views = getViews(mContainer);
//
//        calcCenters();
//
//        float shift = myFlyValue-1;
//
//        for (int i = 0; i < mCount; i++) {
//            View view = views[i];
//            int x = (view.getLeft() + view.getRight()) / 2;
//            int y = (view.getTop() + view.getBottom()) / 2;
//            view.setTranslationX((x - mComputedCenterX)*shift);
//            view.setTranslationY((y - mComputedCenterY)*shift);
//        }
//    }

    /**
     * @param container
     * @hide
     */
    @Override
    public void updatePreLayout(ConstraintLayout container) {
        if (mContainer!=container) {
//            setFlyIn(10);
//            ObjectAnimator.ofFloat(this, "FlyIn", 1f).setDuration(1000).start();
            View[] views = getViews(container);
            for (int i = 0; i < mCount; i++) {
                View view = views[i];
//                ObjectAnimator.ofFloat(view, "translationX", - 2000, 0).setDuration(1000).start();
                ObjectAnimator animator = ObjectAnimator.ofFloat(view, "translationX", - 2000, 0).setDuration(1000);
                animator.setInterpolator(new BounceInterpolator());
 //               animator.setStartDelay(1000);
                animator.start();
            }
        }
        mContainer = container;
    }

    public void calcCenters() {
        if (!(Float.isNaN(mComputedCenterX) || Float.isNaN(mComputedCenterY))) {
            return;
        }
        if (Float.isNaN(mCenterX) || Float.isNaN(mCenterY)) {

            int minx = Integer.MAX_VALUE, miny= Integer.MAX_VALUE;
            int maxx= Integer.MIN_VALUE,maxy= Integer.MIN_VALUE;
            View []views = getViews(mContainer);
            for (int i = 0; i < mCount; i++) {
                View view = views[i];
                minx = Math.min(minx, view.getLeft());
                miny = Math.min(miny, view.getTop());
                maxx = Math.max(maxx, view.getRight());
                maxy = Math.max(maxy, view.getBottom());
            }

                mComputedCenterX = (Float.isNaN(mCenterX))?(minx + maxx) / 2:mCenterX;
                mComputedCenterY = (Float.isNaN(mCenterY))?(miny + maxy) / 2:mCenterY;

        } else {
            mComputedCenterY = mCenterY;
            mComputedCenterX = mCenterX;
        }

    }

    public float getFlyIn() {
       return myFlyValue;
    }
    public void setFlyIn(float flyIn) {
        myFlyValue = flyIn;
//        update();
    }
}
