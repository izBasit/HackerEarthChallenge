/*
 * Copyright 2016 Basit Parkar.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 *  @date 3/19/16 5:13 AM
 *  @modified 3/18/16 11:06 PM
 */

package me.iz.mobility.hackerearthchallenge.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import me.iz.mobility.hackerearthchallenge.utils.TypefaceCache;

/**
 * @author ibasit
 */
public class CustomTextView extends TextView {

    private final String TAG = getClass().getSimpleName();

    private static Typeface mTypeface;

    public CustomTextView(Context context) {
        this(context, null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        Typeface typeface = TypefaceCache.getTypeFace(context.getAssets(), TypefaceCache.OPEN_SANS_LIGHT_TTF);
        if (typeface != null) {
            setTypeface(typeface);
        }
    }
}
