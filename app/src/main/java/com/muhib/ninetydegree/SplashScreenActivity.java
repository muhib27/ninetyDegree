package com.muhib.ninetydegree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.widget.TextView;
//import android.util.Log;

import com.muhib.ninetydegree.broadcast_receiver.InternetConnectionManager;
import com.muhib.ninetydegree.webapi.ApiInterface;
import com.muhib.ninetydegree.webapi.ConnectionURL;
import com.muhib.ninetydegree.webapi.ServiceFactory;

import libs.mjn.prettydialog.PrettyDialog;
import libs.mjn.prettydialog.PrettyDialogCallback;

//import java.io.IOException;
//
//import io.reactivex.Observer;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.disposables.Disposable;
//import io.reactivex.schedulers.Schedulers;

public class SplashScreenActivity extends AppCompatActivity {
    //    SharedPrefsHandler sharedPrefsHandler;
    ApiInterface apiInterface;
    PrettyDialog prettyDialog;
    TextView tv;
    String regid;
    private String TAG = "SplashScreenActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
//        getActionBar().hide();
        setContentView(R.layout.activity_splash_screen);
        tv = findViewById(R.id.tv);
        prettyDialog = new PrettyDialog(this);
        String st = "Developed By " + "90 DEGREE";
        final SpannableStringBuilder sb = new SpannableStringBuilder("Developed By 90 DEGREE");

// Span to set text color to some RGB value
        final ForegroundColorSpan fcs = new ForegroundColorSpan(Color.BLUE);

// Span to make text bold
        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);

// Set the text color for first 4 characters
        sb.setSpan(fcs, 13, 22, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

// make them also bold
        sb.setSpan(bss, 13, 22, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        tv.setText(sb);

        apiInterface = ServiceFactory.createService(ApiInterface.class, ConnectionURL.BASE_URL);
//        sharedPrefsHandler = new SharedPrefsHandler(this);
        getVersionId();
      /*  String android_id = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);

        Log.d("Android", "Android ID : " + android_id);


        Toasty.success(getApplicationContext(), "Android ID : " + android_id, Toasty.LENGTH_LONG).show();*/


        BroadcastReceiver tokenReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String token = intent.getStringExtra("token");

                if (token != null) {
                    Log.e("firebase", String.valueOf(token));
                    regid = token;
                    if(SharedPrefsHandler.getFcm()!=null) {
                        SharedPrefsHandler.setFcm(regid);
                        //sendRegistrationIdToBackend(regid);
                    }
                    checkInternet();

                    // send token to your server
                }

            }
        };
        LocalBroadcastManager.getInstance(this).registerReceiver(tokenReceiver,
                new IntentFilter("tokenReceiver"));




        if(!SharedPrefsHandler.getFcm().isEmpty())
            checkInternet();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


//    private void checkSignUP() {
//        if (InternetConnection.isConnectedToInternet(this)) {
//            String FCMToken = null;
//            try {
//                /*Registration GCM ID then pass this ID to Server*/
//                if (sharedPrefsHandler.getFCMRegistrationID() != null)
//                    FCMToken = sharedPrefsHandler.getFCMRegistrationID();
//                Log.d("token", "token" + sharedPrefsHandler.getFCMRegistrationID());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//            try {
//                if (FCMToken != null)
//                    sendRegistrationIdToBackend(FCMToken);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Log.e("myapp", "memberid null");
//        }
//    }
//    private void sendRegistrationIdToBackend(String regid) throws IOException {
//        if (sharedPrefsHandler != null) {
//            apiInterface.getDeviceWithoutLoginID(regid)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new Observer<StoreDeviceWithOutLogin>() {
//                        @Override
//                        public void onSubscribe(Disposable d) {
//
//                        }
//
//                        @Override
//                        public void onNext(StoreDeviceWithOutLogin storeDeviceWithOutLogin) {
//                            Log.e("Device", "DeviceWithoutLoginID :" + regid);
//                            //Toasty.success(getApplicationContext(), "DeviceWithoutLoginID :" + regid + storeDeviceWithOutLogin.getMsg(), Toasty.LENGTH_LONG).show();
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//                            Toasty.error(getApplicationContext(), e.getMessage(), Toasty.LENGTH_LONG).show();
//
//                        }
//
//                        @Override
//                        public void onComplete() {
//                            //   Toasty.success(getApplicationContext(), "DeviceWithoutLoginID onComplete", Toasty.LENGTH_LONG).show();
//                            Log.e("Device", "DeviceWithoutLoginID onComplete");
//
//                        }
//                    });
//        }
//    }



    private void checkInternet(){
        if (InternetConnectionManager.isConnectedToInternet(getApplicationContext()))

        {
            new Thread() {
                public void run() {
                    try {
                        sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        goHome();

                    }
                }
            }.start();
        }
        else {

            prettyDialog
                    .setTitle("Internet Connection")
                    .setMessage("Please connect your internet connection.")
                    .addButton(
                            "Ok",
                            R.color.black,
                            R.color.orange_clr,
                            new PrettyDialogCallback() {
                                @Override
                                public void onClick() {
                                    prettyDialog.dismiss();
                                    finish();
                                }
                            }
                    )
                    .setIcon(R.drawable.ic_info_error)
                    .show();
        }
    }
    private void goHome() {
        Intent homeIntent = new Intent(this, Main2Activity.class);
        homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(homeIntent);
        finish();
    }

    public void getVersionId() {
        try {
            PackageInfo pInfo = getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 0);
            String version = pInfo.versionName;
//            sharedPrefsHandler.setVersionId(version);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}