package com.metro.itunesdemo.utils;

import android.content.Context;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.metro.itunesdemo.R;


/**
 * Created by Skbhati
 * on Date 01-01-2018 : Time 07:58 PM.
 */

public class SnackBarHelper {

    public static void displaySnackbar(Context context, View view, String s) {
        Snackbar snack = Snackbar.make(view, s, Snackbar.LENGTH_LONG);
        View sbview = snack.getView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            sbview.setBackgroundColor(context.getColor(R.color.colorPrimary));
        }
        TextView textView = (TextView) sbview.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(context.getResources().getColor(R.color.colorAccent));
        snack.show();
    }
}
