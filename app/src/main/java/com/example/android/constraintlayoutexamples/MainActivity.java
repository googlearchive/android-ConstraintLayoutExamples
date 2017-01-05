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

package com.example.android.constraintlayoutexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private boolean mShowingLayout = false;

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

    public void showConstraintSetExample(View view) {
        startActivity(new Intent(this, ConstraintSetExampleActivity.class));
    }
}
