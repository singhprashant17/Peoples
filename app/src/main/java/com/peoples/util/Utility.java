package com.peoples.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.peoples.ApplicationClass;

public class Utility {

    /**
     * Method to check network availability
     */
    public static boolean checkNetwork() {
        final Context ctx = ApplicationClass.getInstance();
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context
                .CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected();
    }
}
