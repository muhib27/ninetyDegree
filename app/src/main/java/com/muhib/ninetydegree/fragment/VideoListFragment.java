package com.muhib.ninetydegree.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.muhib.ninetydegree.Interface.ItemClickListener;
import com.muhib.ninetydegree.Interface.VideoItemClickListener;
import com.muhib.ninetydegree.Main2Activity;
import com.muhib.ninetydegree.R;
import com.muhib.ninetydegree.adapter.ChapterAdapter;
import com.muhib.ninetydegree.adapter.VideoAdapter;
import com.muhib.ninetydegree.model.ChapterData;
import com.muhib.ninetydegree.model.ChapterListResponse;
import com.muhib.ninetydegree.model.Video;
import com.muhib.ninetydegree.webapi.ApiInterface;
import com.muhib.ninetydegree.webapi.ConnectionURL;
import com.muhib.ninetydegree.webapi.ServiceFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VideoListFragment extends Fragment implements VideoItemClickListener {

    VideoAdapter videoAdapter;
    private ChapterData chapterDataModel;
    ChapterData chapterDataList;
    ChapterListResponse chapterListResponse;
    String id = "";
    List<Video> videoList;

    ChapterData chapterData;

    public static VideoListFragment newInstance() {
        return new VideoListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.video_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // TODO: Use the ViewModel



    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getActivity()!=null) {
            ((Main2Activity) getActivity()).tvHomeToolbarText.setText("Chapter");
            ((Main2Activity) getActivity()).ivHomeMenuBarId1.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_arrow));

        }
        videoList = new ArrayList<>();
        chapterDataModel = ViewModelProviders.of(getActivity()).get(ChapterData.class);
        chapterDataList = chapterDataModel.getMutableLiveData().getValue();



        if(chapterDataList !=null  && chapterDataList.getVideos().size()>0)
            videoList = chapterDataList.getVideos();


        String[] data = { "15", "16", "17", "44", "45", "46", "47", "48"};

        // set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycleview);
        int numberOfColumns = 1;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        videoAdapter = new VideoAdapter(getActivity(), this);
//        com.muhib.ninetydegree.adapter.setClickListener(this);
        recyclerView.setAdapter(videoAdapter);

        videoAdapter.addAllData(videoList, chapterDataList.getTitle());

    }

//    @Override
//    public void setClickListener(int pos) {
//        PlayerFragment playerFragment = new PlayerFragment();
//        gotoFragment(playerFragment, "playerFragment");
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

    Video videoModel;
    @Override
    public void setVideoClickListener(Video video) {
        videoModel = ViewModelProviders.of(getActivity()).get(Video.class);
        videoModel.setData(video);
        PlayerFragment playerFragment = new PlayerFragment();
        gotoFragment(playerFragment, "playerFragment");
    }
}
