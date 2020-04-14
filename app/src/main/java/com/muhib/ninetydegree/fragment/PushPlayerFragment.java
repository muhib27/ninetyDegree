package com.muhib.ninetydegree.fragment;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonObject;
import com.muhib.ninetydegree.Interface.ItemClickListener;
import com.muhib.ninetydegree.Main2Activity;
import com.muhib.ninetydegree.R;
import com.muhib.ninetydegree.adapter.CommentAdapter;
import com.muhib.ninetydegree.broadcast_receiver.InternetConnectionManager;
import com.muhib.ninetydegree.model.ChapterData;
import com.muhib.ninetydegree.model.CommentResponse;
import com.muhib.ninetydegree.model.Video;
import com.muhib.ninetydegree.webapi.ApiInterface;
import com.muhib.ninetydegree.webapi.ConnectionURL;
import com.muhib.ninetydegree.webapi.ServiceFactory;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import libs.mjn.prettydialog.PrettyDialog;
import libs.mjn.prettydialog.PrettyDialogCallback;


/**
 * A simple {@link Fragment} subclass.
 */
public class PushPlayerFragment extends Fragment {
    CommentAdapter commentAdapter;
    private TextView comment;
    String videoId = "";
    PowerManager powerManager;
    Video videoModel;
    Video video;
    YouTubePlayerView youTubePlayerView;
    public String value1;
    ChapterData chapterDataModel;
    ChapterData chapterData;

    public PushPlayerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player_push, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getActivity()!=null) {
            ((Main2Activity) getActivity()).tvHomeToolbarText.setText("Tutorial");
            ((Main2Activity) getActivity()).ivHomeMenuBarId1.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_arrow));

        }

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            videoId = bundle.getString("videoId", "");
        }

        if (videoId.contains("&") || videoId.contains("#") || videoId.contains("?")) {
            if (videoId.contains("&")) {
                int index = videoId.indexOf("&");
                videoId = videoId.substring(0, index);
            } else if (videoId.contains("#")) {
                int index = videoId.indexOf("#");
                videoId = videoId.substring(0, index);
            } else if (videoId.contains("?")) {
                int index = videoId.indexOf("?");
                videoId = videoId.substring(0, index);
            }
        }

//        if(video!=null && video.getFileUrlId()!=null)
//            videoId = video.getFileUrlId();

        youTubePlayerView = view.findViewById(R.id.youtube_player_view);
        comment = view.findViewById(R.id.comment);
        powerManager= (PowerManager)getActivity().getSystemService(Context.POWER_SERVICE);
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.setEnableAutomaticInitialization(false);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
       // videoId = "S0Q4gqBUs7c";
       // getVideo();


    }





    @Override
    public void onResume() {
        super.onResume();
        value1 = "Play";
      //  checkSignUP();
        //getVideo();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        value1 = "Pause";
       // getVideo();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        videoRelease();
    }

    public void videoRelease() {
        youTubePlayerView.release();
    }


}
