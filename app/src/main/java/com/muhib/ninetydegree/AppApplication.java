package com.muhib.ninetydegree;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.muhib.ninetydegree.Interface.ConnectivityReceiverListener;


public class AppApplication extends Application {
    private static AppApplication mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
      //  Fabric.with(this, new Crashlytics());
        mInstance = this;
    }
    public static synchronized AppApplication getInstance() {
        return mInstance;
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public void setConnectivityListener(ConnectivityReceiverListener listener) {
    }
}
