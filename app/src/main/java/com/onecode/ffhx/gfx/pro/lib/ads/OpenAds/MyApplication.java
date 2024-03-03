package com.onecode.ffhx.gfx.pro.lib.ads.OpenAds;

import android.app.Application;
import android.content.Context;

import com.onecode.ffhx.gfx.pro.lib.network.GetAdUnits;
import com.onecode.ffhx.gfx.pro.lib.utils.CheckInternetConnection;

public class MyApplication extends Application {
    Context context;
    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (CheckInternetConnection.isNetworkConnected(context)) {
                    new GetAdUnits(context, MyApplication.this).execute();
                }
            }
        }).start();

    }
}
