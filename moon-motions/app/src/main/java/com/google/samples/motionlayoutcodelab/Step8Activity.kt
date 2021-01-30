/*
 *   Copyright (C) 2019 The Android Open Source Project
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.google.samples.motionlayoutcodelab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.google.samples.motionlayoutcodelab.databinding.ActivityStep8Binding

class Step8Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityStep8Binding>(this, R.layout.activity_step8)
            .apply { coordinateMotion() }
    }

    private fun ActivityStep8Binding.coordinateMotion() {
        appbarLayout.addOnOffsetChangedListener(OnOffsetChangedListener { _, verticalOffset ->
            val seekProgress = -verticalOffset / appbarLayout.totalScrollRange.toFloat()
            motionLayout.progress = seekProgress
        })
    }
}
