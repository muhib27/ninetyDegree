package com.muhib.ninetydegree.fragment;


import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.gmail.samehadar.iosdialog.CamomileSpinner;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.JsonObject;
import com.muhib.ninetydegree.AppApplication;
import com.muhib.ninetydegree.Main2Activity;
import com.muhib.ninetydegree.R;
import com.muhib.ninetydegree.SharedPrefsHandler;
import com.muhib.ninetydegree.UIHelper;
import com.muhib.ninetydegree.broadcast_receiver.ConnectivityReceiver;
import com.muhib.ninetydegree.broadcast_receiver.InternetConnectionManager;
import com.muhib.ninetydegree.model.ClassData;
import com.muhib.ninetydegree.model.ClassListResponse;
import com.muhib.ninetydegree.webapi.ApiInterface;
import com.muhib.ninetydegree.webapi.ConnectionURL;
import com.muhib.ninetydegree.webapi.ServiceFactory;
import com.ramotion.circlemenu.CircleMenuView;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import libs.mjn.prettydialog.PrettyDialog;
import libs.mjn.prettydialog.PrettyDialogCallback;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment implements ConnectivityReceiver.ConnectivityReceiverListener{

    private PrettyDialog prettyDialog;
    UIHelper uiHelper;
    TextView tv;
    SliderView sliderView;
    LinearLayout rlCoursesDashId1;
    List<Integer> icon ;
    List<Integer> colors ;
    LinearLayout fl;
    List<ClassData> classDataList;
    ClassListResponse classListResponseModel;
    ClassListResponse classListResponse;
    public static String SELECTED ="";
    CamomileSpinner progress;
    private ConnectivityReceiver connectivityReceiver;
    TextView textView;
    public DashboardFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prettyDialog = new PrettyDialog(getActivity());
        textView = view.findViewById(R.id.text);
        uiHelper = new UIHelper(getActivity());
        connectivityReceiver = new ConnectivityReceiver();
        progress = view.findViewById(R.id.inOutProgress);


        try {
            if(getActivity()!=null)
                getActivity().registerReceiver(connectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
           // registerNetworkBroadcastForNougat();
            setUpInterConnectionBroadcastReceiverListener();
        }catch (Exception e){

        }
        fl = view.findViewById(R.id.ll);
        classDataList = new ArrayList<>();
        icon = new ArrayList();
        colors = new ArrayList();




        if(getActivity()!=null) {
            ((Main2Activity) getActivity()).tvHomeToolbarText.setText("Home");
            ((Main2Activity) getActivity()).ivHomeMenuBarId1.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_menu_bar_icon));

        }


//        connectivityReceiver = new ConnectivityReceiver();
//        getActivity().registerReceiver(connectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
//        setUpInterConnectionBroadcastReceiverListener();

//        sliderView = view.findViewById(R.id.imageSlider);
        tv = view.findViewById(R.id.tv);
        String st = "Developed By " + "90 DEGREE EDUCATION";
        final SpannableStringBuilder sb = new SpannableStringBuilder("Developed By 90 DEGREE EDUCATION");

// Span to set text color to some RGB value
        final ForegroundColorSpan fcs = new ForegroundColorSpan(Color.BLUE);

// Span to make text bold
        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);

// Set the text color for first 4 characters
        sb.setSpan(fcs, 13, 32, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

// make them also bold
        sb.setSpan(bss, 13, 32, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        tv.setText(sb);

//        final ImageSliderAdapter adapter = new ImageSliderAdapter(getContext());
//        adapter.setCount(4);
//        sliderView.setSliderAdapter(adapter);
//
//        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
//        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
//        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
//        sliderView.setIndicatorSelectedColor(Color.parseColor("#3ba110"));
//        sliderView.setIndicatorUnselectedColor(Color.WHITE);
//        sliderView.startAutoCycle();

//        rlCoursesDashId1 = view.findViewById(R.id.rlCoursesDashId1);
//        rlCoursesDashId1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                HomeFragment homeFragment = new HomeFragment();
//                gotoFragment(homeFragment, "homeFragment");
//            }
//        });



//        final CircleMenuView menu = view.findViewById(R.id.circle_menu);
        classListResponseModel = ViewModelProviders.of(getActivity()).get(ClassListResponse.class);
        classListResponse = classListResponseModel.getMutableLiveData().getValue();


            if(classListResponse != null && classListResponse.getData()!=null) {
                classDataList = classListResponse.getData();
                setData(classDataList);
            }
            else {

                if (InternetConnectionManager.isConnectedToInternet(getActivity())) {
                    {
                        callApi();
                        progress.setVisibility(View.VISIBLE);
                        progress.start();
                    }
                } else {
                    final PrettyDialog prettyDialog = new PrettyDialog(getActivity());
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
                                        }
                                    }
                            )
                            .setIcon(R.drawable.ic_info_error)
                            .show();
                }

            }


    }

    private void gotoFragment(Fragment fragment, String tag) {
        // load com.muhib.ninetydegree.fragment
        // com.muhib.ninetydegree.fragment.setArguments(bundle);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        if (isConnected) {
            //uiHelper.noInternet(true);
            //callApi();
        } else {
            uiHelper.noInternet(false);
        }

    }

    private void setUpInterConnectionBroadcastReceiverListener() {
        AppApplication.getInstance().setConnectivityListener(this);
    }


    @Override
    public void onStart() {
        super.onStart();
        classListResponseModel = ViewModelProviders.of(getActivity()).get(ClassListResponse.class);
        classListResponse = classListResponseModel.getMutableLiveData().getValue();
    }

    private void callApi() {

        JsonObject jsonObject;
        jsonObject = new JsonObject();
        String token;
        if(SharedPrefsHandler.getFcm().isEmpty())
        {
            token = SharedPrefsHandler.getFcm();
            jsonObject.addProperty("device_token", token);
        }
        else {
            token = FirebaseInstanceId.getInstance().getToken();
            if(token!=null)
            jsonObject.addProperty("device_token", token);
        }

//            if (!NetworkConnection.getInstance().isNetworkAvailable()) {
//                Toast.makeText(getActivity(), "No Connectivity", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            uiHelper.showLoadingDialog("Please wait...");

        // RetrofitApiClient.getApiInterface().getTaskAssign(requestBody)
        ServiceFactory.createService(ApiInterface.class, ConnectionURL.BASE_URL)
                .getClasses(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClassListResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(ClassListResponse classListResponse) {
                        progress.stop();
                        progress.setVisibility(View.GONE);
                        classListResponseModel = ViewModelProviders.of(getActivity()).get(ClassListResponse.class);
                        classListResponseModel.setClassResData(classListResponse);

                        classDataList = classListResponse.getData();

                        setData(classDataList);


//                        icon.add(R.drawable.ic_home_white_24dp);
//                        icon.add(R.drawable.ic_home_white_24dp);
//                        icon.add(R.drawable.ic_home_white_24dp);
//                        icon.add(R.drawable.ic_home_white_24dp);
//                        icon.add(R.drawable.ic_home_white_24dp);
//                        icon.add(R.drawable.ic_home_white_24dp);
//                        icon.add(R.drawable.ic_home_white_24dp);
//                        icon.add(R.drawable.ic_home_white_24dp);
//
//
//                        colors.add(getResources().getColor(R.color.colorPrimary));
//                        colors.add(getResources().getColor(R.color.colorPrimary));
//                        colors.add(getResources().getColor(R.color.colorPrimary));
//                        colors.add(getResources().getColor(R.color.colorPrimary));
//                        colors.add(getResources().getColor(R.color.colorPrimary));
//                        colors.add(getResources().getColor(R.color.colorPrimary));
//                        colors.add(getResources().getColor(R.color.colorPrimary));
//                        colors.add(getResources().getColor(R.color.colorPrimary));
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(e.getMessage().contains("403"))
                        {
                            callApi();
                        }
                        else {
                            progress.stop();
                            progress.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


    private void setData(List<ClassData> classDataList)
    {
        for(int i=0;i<classDataList.size(); i++){
            if(classDataList.get(i).getName().equals("Class ONE")) {
                icon.add(R.drawable.one_new);
                colors.add(getResources().getColor(R.color.white));
            }
            else if(classDataList.get(i).getName().equals("Class TWO")) {
                icon.add(R.drawable.two_new);
                colors.add(getResources().getColor(R.color.white));
            }
            else if(classDataList.get(i).getName().equals("Class THREE")) {
                icon.add(R.drawable.three_new);
                colors.add(getResources().getColor(R.color.white));
            }
            else if(classDataList.get(i).getName().equals("Class FOUR")) {
                icon.add(R.drawable.four_new);
                colors.add(getResources().getColor(R.color.white));
            }
            else if(classDataList.get(i).getName().equals("Class FIVE")) {
                icon.add(R.drawable.five_new);
                colors.add(getResources().getColor(R.color.white));
            }
            else if(classDataList.get(i).getName().equals("Class SIX")) {
                icon.add(R.drawable.six_new);
                colors.add(getResources().getColor(R.color.white));
            }
            else if(classDataList.get(i).getName().equals("Class SEVEN")) {
                icon.add(R.drawable.seven_new);
                colors.add(getResources().getColor(R.color.white));
            }
            else if(classDataList.get(i).getName().equals("Class EIGHT")) {
                icon.add(R.drawable.eight_new);
                colors.add(getResources().getColor(R.color.white));
            }
            else if(classDataList.get(i).getName().equals("Class NINE-TEN/ SSC")) {
                icon.add(R.drawable.nine_new);
                colors.add(getResources().getColor(R.color.white));
            }
            else if(classDataList.get(i).getName().equals("Class Eleven-Twelve/ HSC")) {
                icon.add(R.drawable.ten_new);
                colors.add(getResources().getColor(R.color.white));
            }
            else {
                icon.add(R.drawable.ic_home_white_24dp);
                colors.add(getResources().getColor(R.color.white));
            }
        }

        setMenu();
    }

    CircleMenuView menu;
    private void setMenu(){

        menu = new CircleMenuView(getActivity(), icon, colors);
        menu.setDistance(180);
        //menu.setIconMenu(R.drawable.main_new);

        fl.removeAllViews();
        fl.addView(menu);
        //menu.setIconMenu();


        menu.setEventListener(new CircleMenuView.EventListener() {
            @Override
            public void onMenuOpenAnimationStart(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuOpenAnimationStart");
                textView.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onMenuOpenAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuOpenAnimationEnd");
            }

            @Override
            public void onMenuCloseAnimationStart(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuCloseAnimationStart");
            }

            @Override
            public void onMenuCloseAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("D", "onMenuCloseAnimationEnd");
                textView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onButtonClickAnimationStart(@NonNull CircleMenuView view, int index) {
                Log.d("D", "onButtonClickAnimationStart| index: " + index);

            }

            @Override
            public void onButtonClickAnimationEnd(@NonNull CircleMenuView view, int index) {
                Log.d("D", "onButtonClickAnimationEnd| index: " + index);
                textView.setVisibility(View.INVISIBLE);
                SELECTED = classDataList.get(index).getId().toString();
                SubjectFragment subjectFragment = new SubjectFragment();
                gotoFragment(subjectFragment, "subjectFragment");
              //  myDialog();
            }

            @Override
            public boolean onButtonLongClick(@NonNull CircleMenuView view, int index) {
                Log.d("D", "onButtonLongClick| index: " + index);
                return true;
            }

            @Override
            public void onButtonLongClickAnimationStart(@NonNull CircleMenuView view, int index) {
                Log.d("D", "onButtonLongClickAnimationStart| index: " + index);
            }

            @Override
            public void onButtonLongClickAnimationEnd(@NonNull CircleMenuView view, int index) {
                Log.d("D", "onButtonLongClickAnimationEnd| index: " + index);
            }
        });


    }
//    public String m_Text;
//    private void myDialog(){
//
//        final String cmnt ="";
//        String nm = "";
//        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//        builder.setTitle("");
//
//        View viewInflated = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_layout, (ViewGroup) getView(), false);
//
//        final EditText input = viewInflated.findViewById(R.id.etComments);
//        final EditText name = viewInflated.findViewById(R.id.name);
//        builder.setView(viewInflated);
//
//        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//                m_Text = input.getText().toString();
//                if(!input.getText().toString().trim().isEmpty() )
//                {
//                    cmnt = input.getText().toString();
//                    if(!name.getText().toString().isEmpty())
//                        nm = name.getText().toString().isEmpty();
//                    callApi();
//                }
//
//            }
//        });
//        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//            }
//        });
//
//        builder.show();
//    }

    private void registerNetworkBroadcastForNougat() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            getActivity().registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            getActivity().registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
//        }
        AppApplication.getInstance().setConnectivityListener(this);
    }

    protected void unregisterNetworkChanges() {
        try {
            getActivity().unregisterReceiver(connectivityReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void onNetworkConnectionChanged(boolean isConnected) {
//
//        if (isConnected) {
//            uiHelper.noInternet(true);
//            ApiCall();
//        } else {
//            uiHelper.noInternet(false);
//        }
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unregisterNetworkChanges();
    }

//    @Override
//    public void onNetworkConnectionChanged(boolean isConnected) {
//
//        if (isConnected) {
//            uiHelper.noInternet(true);
//            callApi();
//        } else {
//            uiHelper.noInternet(false);
//        }
//    }

}
