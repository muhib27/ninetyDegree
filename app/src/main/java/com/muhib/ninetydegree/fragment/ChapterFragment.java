package com.muhib.ninetydegree.fragment;

import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gmail.samehadar.iosdialog.CamomileSpinner;
import com.muhib.ninetydegree.AppApplication;
import com.muhib.ninetydegree.Interface.ChapterItemClickListener;
import com.muhib.ninetydegree.Interface.ItemClickListener;
import com.muhib.ninetydegree.Main2Activity;
import com.muhib.ninetydegree.MainActivity;
import com.muhib.ninetydegree.R;
import com.muhib.ninetydegree.TrainerInformationListResponse;
import com.muhib.ninetydegree.UIHelper;
import com.muhib.ninetydegree.adapter.ChapterAdapter;
import com.muhib.ninetydegree.adapter.SubjectAdapter;
import com.muhib.ninetydegree.broadcast_receiver.ConnectivityReceiver;
import com.muhib.ninetydegree.broadcast_receiver.InternetConnectionManager;
import com.muhib.ninetydegree.model.ChapterData;
import com.muhib.ninetydegree.model.ChapterListResponse;
import com.muhib.ninetydegree.model.ClassListResponse;
import com.muhib.ninetydegree.webapi.ApiInterface;
import com.muhib.ninetydegree.webapi.ConnectionURL;
import com.muhib.ninetydegree.webapi.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import libs.mjn.prettydialog.PrettyDialog;
import libs.mjn.prettydialog.PrettyDialogCallback;

public class ChapterFragment extends Fragment implements ChapterItemClickListener, ConnectivityReceiver.ConnectivityReceiverListener {

    private ConnectivityReceiver connectivityReceiver;
    UIHelper uiHelper;
    ChapterAdapter chapterAdapter;
    private SubjectViewModel mViewModel;
    String id = "";
    List<ChapterData> chapterDataList;
    CamomileSpinner progress;

    public static ChapterFragment newInstance() {
        return new ChapterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chapter_fragment, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        uiHelper = new UIHelper(getActivity());
        connectivityReceiver = new ConnectivityReceiver();


        try {
            if(getActivity()!=null)
                getActivity().registerReceiver(connectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            // registerNetworkBroadcastForNougat();
            setUpInterConnectionBroadcastReceiverListener();
        }catch (Exception e){

        }
        mViewModel = ViewModelProviders.of(this).get(SubjectViewModel.class);
        // TODO: Use the ViewModel

        chapterDataList = new ArrayList<>();
        Bundle bundle = this.getArguments();
        if (bundle != null && bundle.getString("id") !=null) {
            id = bundle.getString("id");
        }


        if (InternetConnectionManager.isConnectedToInternet(getActivity())) {
            if(!id.isEmpty()) {
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

    private void setUpInterConnectionBroadcastReceiverListener() {
        AppApplication.getInstance().setConnectivityListener(this);
    }


    ChapterListResponse chapterListResponseModel;
    private void callApi() {


//            if (!NetworkConnection.getInstance().isNetworkAvailable()) {
//                Toast.makeText(getActivity(), "No Connectivity", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            uiHelper.showLoadingDialog("Please wait...");

            // RetrofitApiClient.getApiInterface().getTaskAssign(requestBody)
            ServiceFactory.createService(ApiInterface.class, ConnectionURL.BASE_URL)
                    .getChapters(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ChapterListResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(ChapterListResponse chapterListResponse) {
                            progress.stop();
                            progress.setVisibility(View.GONE);
                            if(getActivity()!=null) {
                                chapterListResponseModel = ViewModelProviders.of(getActivity()).get(ChapterListResponse.class);
                                chapterListResponseModel.setChapterListData(chapterListResponse);
                            }

                            chapterAdapter.addAllData(chapterListResponse.getData());
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.v("error", e.toString());
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getActivity()!=null) {
            ((Main2Activity) getActivity()).tvHomeToolbarText.setText("Chapter");
            ((Main2Activity) getActivity()).ivHomeMenuBarId1.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_arrow));

        }
        progress = view.findViewById(R.id.inOutProgress);
        String[] data = { "15", "16", "17", "44", "45", "46", "47", "48"};

        // set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycleview);
        int numberOfColumns = 1;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        chapterAdapter = new ChapterAdapter(getActivity(), this);
//        com.muhib.ninetydegree.adapter.setClickListener(this);
        recyclerView.setAdapter(chapterAdapter);

    }

//    @Override
//    public void setClickListener(int pos) {
//        VideoListFragment videoListFragment = new VideoListFragment();
//        gotoFragment(videoListFragment, "videoListFragment");
//
//    }

    private void gotoFragment(Fragment fragment, String tag) {
        // load com.muhib.ninetydegree.fragment
        // com.muhib.ninetydegree.fragment.setArguments(bundle);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    ChapterData chapterModel;
    @Override
    public void setChapterClickListener(ChapterData data) {
        chapterModel = ViewModelProviders.of(getActivity()).get(ChapterData.class);
        chapterModel.setChapterData(data);

        VideoListFragment videoListFragment = new VideoListFragment();
        gotoFragment(videoListFragment, "videoListFragment");
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unregisterNetworkChanges();
    }

    protected void unregisterNetworkChanges() {
        try {
            getActivity().unregisterReceiver(connectivityReceiver);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
