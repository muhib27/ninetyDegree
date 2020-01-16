package com.muhib.ninetydegree.fragment;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.PowerManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.muhib.ninetydegree.MainActivity;
import com.muhib.ninetydegree.R;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;



/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerFragment extends Fragment {
    String videoId;
    PowerManager powerManager;
    YouTubePlayerView youTubePlayerView;
    public String value1;
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
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);
        youTubePlayerView = view.findViewById(R.id.youtube_player_view);
        powerManager= (PowerManager)getActivity().getSystemService(Context.POWER_SERVICE);
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.setEnableAutomaticInitialization(false);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "S0Q4gqBUs7c";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        videoId = "S0Q4gqBUs7c";
       // getVideo();
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


}
