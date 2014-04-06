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
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vince on 05/04/14.
 */
public class MultiScrollListenerListView extends ListView implements OnScrollListener  {
    private List<OnScrollListener> mListeners = new ArrayList<OnScrollListener>();


    public MultiScrollListenerListView(Context context) {
        super(context);
        init();
    }

    public MultiScrollListenerListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MultiScrollListenerListView(Context context, AttributeSet attrs, int theme) {
        super(context, attrs, theme);
        init();
    }

    private void init() {
        super.setOnScrollListener(this);
    }

    @Override
    public void setOnScrollListener(OnScrollListener l) {
        if (!mListeners.contains(l)) {
            mListeners.add(l);
        }
    }

    public void removeOnScrollistener(OnScrollListener l) {
        mListeners.remove(l);
    }

    @Override
    public synchronized void onScrollStateChanged(AbsListView view, int scrollState) {
        for (OnScrollListener l : mListeners) {
            l.onScrollStateChanged(view, scrollState);
        }
    }

    @Override
    public synchronized void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        for (OnScrollListener l : mListeners) {
            l.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        }
    }

}
