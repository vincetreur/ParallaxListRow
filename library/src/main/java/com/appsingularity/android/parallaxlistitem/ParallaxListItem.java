/*
 * Copyright 2014 App Singularity
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.appsingularity.android.parallaxlistitem;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by vince on 05/04/14.
 */
public class ParallaxListItem extends ImageView implements OnScrollListener {

    public ParallaxListItem(Context context) {
        super(context);
    }

    public ParallaxListItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ParallaxListItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void attachToList(ListView listView) {
        listView.setOnScrollListener(this);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }


    @Override
    public void onScroll(AbsListView listView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        float imageHeight = getDrawable().getIntrinsicHeight();
        float imageWidth = getDrawable().getIntrinsicWidth();
        float viewHeight = getMeasuredHeight();
        float viewWidth = getMeasuredWidth();
        float offScreenHalf = (imageHeight - viewHeight) / 2f;
        float top = getTop();
        float scale = top / listView.getMeasuredHeight();
        if (scale > 1) { scale = 1; }
        if (scale < -1) { scale = -1; }
        float hStart = (scale * offScreenHalf) + offScreenHalf;
        float hEnd = hStart + viewHeight;

        RectF drawableRect = new RectF(0, hStart, imageWidth, hEnd);

        Matrix m = getImageMatrix();
        RectF viewRect = new RectF(0, 0, viewWidth, viewHeight);
        m.setRectToRect(drawableRect, viewRect, ScaleToFit.FILL);
        setImageMatrix(m);
        invalidate();
    }


}
