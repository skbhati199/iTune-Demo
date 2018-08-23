/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.metro.itunesdemo.utils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.metro.itunesdemo.R;
import com.metro.itunesdemo.data.remote.model.Result;
import com.metro.itunesdemo.data.remote.model.SearchModel;
import com.metro.itunesdemo.ui.adapter.ITuneRecyclerViewAdapter;

import java.util.List;


/**
 * Created by Info Skills Technology 11/07/17.
 */

public final class BindingUtils {

    private static final String TAG = BindingUtils.class.getSimpleName();

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"adapter"})
    public static void addRecyclerItems(RecyclerView recyclerView, List<Result> resultList) {
        ITuneRecyclerViewAdapter adapter = (ITuneRecyclerViewAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(resultList);
        }
    }


    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url)
                .fallback(R.drawable.placeholder)
                .error(new ColorDrawable(Color.RED))
                .into(imageView);
    }
}
