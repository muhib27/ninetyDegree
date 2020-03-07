package com.muhib.ninetydegree;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.muhib.ninetydegree.broadcast_receiver.InternetConnectionManager;

public class ConnectivityReceiver extends BroadcastReceiver {

    public static ConnectivityReceiverListener connectivityReceiverListener;
    public ConnectivityReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (connectivityReceiverListener!=null){
            connectivityReceiverListener.onNetworkConnectionChanged(InternetConnectionManager.isConnectedToInternet(context));
        }
    }

    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(boolean isConnected);
    }
}
