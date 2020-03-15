package com.muhib.ninetydegree.fragment;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.PowerManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.muhib.ninetydegree.Interface.ItemClickListener;
import com.muhib.ninetydegree.Main2Activity;
import com.muhib.ninetydegree.MainActivity;
import com.muhib.ninetydegree.R;

import com.muhib.ninetydegree.adapter.CommentAdapter;
import com.muhib.ninetydegree.broadcast_receiver.InternetConnectionManager;
import com.muhib.ninetydegree.model.ChapterData;
import com.muhib.ninetydegree.model.ClassListResponse;
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
public class PlayerFragment extends Fragment implements ItemClickListener {
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

    public PlayerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getActivity()!=null) {
            ((Main2Activity) getActivity()).tvHomeToolbarText.setText("Tutorial");
            ((Main2Activity) getActivity()).ivHomeMenuBarId1.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_arrow));

        }

        videoModel = ViewModelProviders.of(getActivity()).get(Video.class);
        video = videoModel.getMutableLiveData().getValue();

        chapterDataModel = ViewModelProviders.of(getActivity()).get(ChapterData.class);
        chapterData = chapterDataModel.getMutableLiveData().getValue();

        if(video!=null && video.getFileUrlId()!=null)
            videoId = video.getFileUrlId();

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
        comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog();
            }
        });
        String[] data = { "What is atom?", "What is atom?", "What is atom?", "What is atom?", "What is atom?", "What is atom?", "What is atom?", "What is atom?"};

        // set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycleview);
        int numberOfColumns = 1;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        commentAdapter = new CommentAdapter(getActivity(), video.getComments(), this);
//        com.muhib.ninetydegree.adapter.setClickListener(this);
        recyclerView.setAdapter(commentAdapter);
    }



    @Override
    public void setClickListener(int pos) {
        PlayerFragment playerFragment = new PlayerFragment();
      //  gotoFragment(playerFragment, "playerFragment");

    }
    public void getVideo() {
//        if (videoId != null) {
//
//
//            youTubePlayerView.initialize(
//                    new YouTubePlayerInitListener() {
//                        @Override
//                        public void onInitSuccess(@NonNull final YouTubePlayer initializedYouTubePlayer) {
//                            initializedYouTubePlayer.addListener(
//                                    new AbstractYouTubePlayerListener() {
//                                        @Override
//                                        public void onReady() {
//                                            boolean isScreenOn;
//                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
//                                                isScreenOn = powerManager.isInteractive();
//                                            } else {
//                                                isScreenOn = powerManager.isScreenOn();
//                                            }
//
//                                            if (!isScreenOn) {
//                                                initializedYouTubePlayer.pause();
//                                            } else {
//                                                switch (value1) {
//                                                    case "Play":
//                                                        initializedYouTubePlayer.loadVideo(videoId, 0);
//                                                        break;
//                                                    case "Pause":
//                                                        initializedYouTubePlayer.pause();
//                                                        break;
//                                                    default:
//                                                        initializedYouTubePlayer.pause();
//                                                        break;
//                                                }
//                                            }
//                                            Log.d("onCreate", videoId);
//                                        }
//
//                                        @Override
//                                        public void onStateChange(int state) {
//                                            super.onStateChange(state);
//                                            if (state == 0) {
//                                                initializedYouTubePlayer.loadVideo(videoId, 0);
//                                            }
//                                        }
//                                    });
//                        }
//                    }, true);
//        }

        youTubePlayerView.initialize(new YouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                boolean isScreenOn;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
                    isScreenOn = powerManager.isInteractive();
                } else {
                    isScreenOn = powerManager.isScreenOn();
                }

                if (!isScreenOn) {
                    youTubePlayer.pause();
                } else {
                    switch (value1) {
                        case "Play":
                            youTubePlayer.loadVideo(videoId, 0);
                            break;
                        case "Pause":
                            youTubePlayer.pause();
                            break;
                        default:
                            youTubePlayer.pause();
                            break;
                    }
                }
                Log.d("onCreate", videoId);


            }

            @Override
            public void onStateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlayerState playerState) {
                if (playerState !=null) {
                    youTubePlayer.loadVideo(videoId, 0);
                }
            }

            @Override
            public void onPlaybackQualityChange(YouTubePlayer youTubePlayer, PlayerConstants.PlaybackQuality playbackQuality) {

            }

            @Override
            public void onPlaybackRateChange(YouTubePlayer youTubePlayer, PlayerConstants.PlaybackRate playbackRate) {

            }

            @Override
            public void onError(YouTubePlayer youTubePlayer, PlayerConstants.PlayerError playerError) {

            }

            @Override
            public void onCurrentSecond(YouTubePlayer youTubePlayer, float v) {

            }

            @Override
            public void onVideoDuration(YouTubePlayer youTubePlayer, float v) {

            }

            @Override
            public void onVideoLoadedFraction(YouTubePlayer youTubePlayer, float v) {

            }

            @Override
            public void onVideoId(YouTubePlayer youTubePlayer, String s) {

            }

            @Override
            public void onApiChange(YouTubePlayer youTubePlayer) {

            }
        });
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

    String cmnt ="";
    String nm = "";

    public String m_Text;
    private void myDialog(){


        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("");

        View viewInflated = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_layout, (ViewGroup) getView(), false);

        final EditText input = viewInflated.findViewById(R.id.etComments);
        final EditText name = viewInflated.findViewById(R.id.name);
        builder.setView(viewInflated);

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                m_Text = input.getText().toString();
                if(!input.getText().toString().trim().isEmpty() )
                {
                    cmnt = input.getText().toString();
                    if(!name.getText().toString().isEmpty())
                        nm = name.getText().toString();
                   // callApi(cmnt, nm);

                    if (InternetConnectionManager.isConnectedToInternet(getActivity())) {
                        callApi(cmnt, nm);
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
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

//    {
//        "id": "",
//            "user_name": "ddsd",
//            "comments": "dfd",
//            "video_id": 15,
//            "chapter_id": 119
//    }
    private void callApi(String cmnt, String nm) {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", "");
        jsonObject.addProperty("user_name", nm);
        jsonObject.addProperty("comments", cmnt);
        jsonObject.addProperty("video_id", video.getId());
        jsonObject.addProperty("chapter_id", chapterData.getId());


//            if (!NetworkConnection.getInstance().isNetworkAvailable()) {
//                Toast.makeText(getActivity(), "No Connectivity", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            uiHelper.showLoadingDialog("Please wait...");

        // RetrofitApiClient.getApiInterface().getTaskAssign(requestBody)
        ServiceFactory.createService(ApiInterface.class, ConnectionURL.BASE_URL)
                .postComment(jsonObject)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(CommentResponse commentResponse) {
                        Log.v("commentResponse", commentResponse.toString());
                        commentAdapter.addAllData(commentResponse.getComments());
//                        classListResponseModel = ViewModelProviders.of(getActivity()).get(ClassListResponse.class);
//                        classListResponseModel.setClassResData(classListResponse);
//
//                        classDataList = classListResponse.getData();
//
//                        for(int i=0;i<classListResponse.getData().size(); i++){
//                            if(classListResponse.getData().get(i).getName().equals("Class ONE")) {
//                                icon.add(R.drawable.numbers_one);
//                                colors.add(getResources().getColor(R.color.colorPrimary));
//                            }
//                            else if(classListResponse.getData().get(i).getName().equals("Class TWO")) {
//                                icon.add(R.drawable.ic_two);
//                                colors.add(getResources().getColor(R.color.colorPrimary));
//                            }
//                            else {
//                                icon.add(R.drawable.ic_home_white_24dp);
//                                colors.add(getResources().getColor(R.color.colorPrimary));
//                            }
//                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.v("e", e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
