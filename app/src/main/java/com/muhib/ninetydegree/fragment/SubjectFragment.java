package com.muhib.ninetydegree.fragment;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.muhib.ninetydegree.Interface.ItemClickListener;
import com.muhib.ninetydegree.MainActivity;
import com.muhib.ninetydegree.R;

import com.muhib.ninetydegree.TrainerInformationListResponse;
import com.muhib.ninetydegree.adapter.SubjectAdapter;
import com.muhib.ninetydegree.webapi.ApiInterface;
import com.muhib.ninetydegree.webapi.ConnectionURL;
import com.muhib.ninetydegree.webapi.ServiceFactory;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class SubjectFragment extends Fragment implements ItemClickListener {

    SubjectAdapter subjectAdapter;
    private SubjectViewModel mViewModel;

    public static SubjectFragment newInstance() {
        return new SubjectFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.subject_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SubjectViewModel.class);
        // TODO: Use the ViewModel

        callApi();
    }

    private void callApi() {


//            if (!NetworkConnection.getInstance().isNetworkAvailable()) {
//                Toast.makeText(getActivity(), "No Connectivity", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            uiHelper.showLoadingDialog("Please wait...");

            // RetrofitApiClient.getApiInterface().getTaskAssign(requestBody)
            ServiceFactory.createService(ApiInterface.class, ConnectionURL.BASE_URL)
                    .getTrainersInformation()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<TrainerInformationListResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(TrainerInformationListResponse trainerInformationListResponse) {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);
        String[] data = { "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48"};

        // set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycleview);
        int numberOfColumns = 1;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        subjectAdapter = new SubjectAdapter(getActivity(), data, this);
//        com.muhib.ninetydegree.adapter.setClickListener(this);
        recyclerView.setAdapter(subjectAdapter);
    }

    @Override
    public void setClickListener(int pos) {
        PlayerFragment playerFragment = new PlayerFragment();
        gotoFragment(playerFragment, "playerFragment");

    }

    private void gotoFragment(Fragment fragment, String tag) {
        // load com.muhib.ninetydegree.fragment
        // com.muhib.ninetydegree.fragment.setArguments(bundle);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
