ParallaxListRow
===============

A simple implementation to display a parallax effect on images in ListViews.

Usage
=====
Showing an image with parallax effect in a ListView is as quite simple.
Your adapter can inflate an xml layout the looks a lot like this one.
```xml
<com.appsingularity.android.parallaxlistitem.ParallaxListItem 
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="@dimen/image_height"
    android:scaleType="centerCrop"
    android:background="#000000"
    />
```
After you've done that just connect the inflated view with your ListView.
```java
    ParallaxListItem item = (ParallaxListItem) convertView;
    item.attachToList((ListView) parent);
```

> Using multiple `ParallaxListItem`'s in a single ListView.
>
> Since a ListView only supports a single `OnScrollListener` only one `ParallaxListItem` will show the parallax effect in plain ListViews.
> If you want to have mulitple images in your list to show the parallax effect, use the `MultiScrollListenerListView`. (Also in this repository.)
> This ListView replacement supports multiple on scroll listeners so all `ParallaxListItem`s to function properly.

Demo
====
See the included sample project.

Licence
=======
 Copyright 2014 App Singularity
 
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 
     http://www.apache.org/licenses/LICENSE-2.0
 
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 
