package com.example.android.constraintlayoutexamples;

import android.content.res.Configuration;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private boolean mShowingLayout = false;
    ConstraintSet mSetNormal = new ConstraintSet();
    ConstraintSet mSetBig = new ConstraintSet();
    ConstraintSet mSetBigLandscape = new ConstraintSet();
    ConstraintLayout mLayout;
    boolean mBig = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show(View v) {
        String tag = (String) v.getTag();
        int id = getResources().getIdentifier(tag, "layout", getPackageName());
        setContentView(id);
        mShowingLayout = true;
        if (tag.equals("constraint_example_7")) {
            mLayout = (ConstraintLayout) findViewById(R.id.activity_main);
            mSetNormal.load(this, R.layout.constraint_example_7);
            mSetBig.load(this, R.layout.constraint_example_7a);
            mSetBigLandscape.load(this, R.layout.constraint_example_7b);
        } else {
            mLayout = null;
        }
    }

    @Override
    public void onBackPressed() {
        if (mShowingLayout) {
            setContentView(R.layout.activity_main);
            mShowingLayout = false;
        } else {
            super.onBackPressed();
        }
    }

    public void toggleMode(View v) {
        TransitionManager.beginDelayedTransition(mLayout);
        mBig = !mBig;
        int orientation = getResources().getConfiguration().orientation;
        layout7(orientation == Configuration.ORIENTATION_LANDSCAPE);
    }

    private void layout7(boolean landscape) {
        if (mLayout == null) {
            return;
        }
        if (mBig) {
            if (landscape) {
                mSetBigLandscape.applyTo(mLayout);
            } else {
                mSetBig.applyTo(mLayout);
            }
        } else {
            mSetNormal.applyTo(mLayout);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        layout7(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE);
    }
}
