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

package com.appsingularity.parallaxlistrow.app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.appsingularity.android.parallaxlistitem.ParallaxListItem;

/**
 * Created by vince on 05/04/14.
 */
public class ParallaxAdapter extends BaseAdapter {
    private static final int NORMAL_ROW_TYPE = 0;
    private static final int IMAGE_ROW_TYPE = 1;
    private static final int ROW_COUNT = 16;


    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
//        if (position != 0) {
//            if (position % 3 == 0) {
//                return IMAGE_ROW_TYPE;
//            }
//        }
        if (position == 4) {
            return IMAGE_ROW_TYPE;
        }
        return NORMAL_ROW_TYPE;
    }

    @Override
    public int getCount() {
        return ROW_COUNT;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (getItemViewType(position) == NORMAL_ROW_TYPE) {
            return getNormalView(position, convertView, parent);
        }

        return getImageView(position, convertView, parent);
    }

    public View getNormalView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        }
        TextView tv = (TextView) convertView.findViewById(android.R.id.text1);
        tv.setText(R.string.row_title);
        tv = (TextView) convertView.findViewById(android.R.id.text2);
        tv.setText(R.string.row_text);

        return convertView;
    }

    public View getImageView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.parallax_image_list_item, parent, false);
        }

        ParallaxListItem item = (ParallaxListItem) convertView;
        item.setImageResource(R.drawable.houses);
        item.attachToList((ListView) parent);

        return convertView;
    }


}
