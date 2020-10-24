package com.smart.school.util.helper;

import android.content.Context;
import android.widget.Toast;

public class ToastHelper {

    public static void showToast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
