package com.muhib.ninetydegree.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.muhib.ninetydegree.Interface.ItemClickListener;
import com.muhib.ninetydegree.Interface.VideoItemClickListener;
import com.muhib.ninetydegree.R;
import com.muhib.ninetydegree.UIHelper;
import com.muhib.ninetydegree.model.ChapterData;
import com.muhib.ninetydegree.model.Video;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    VideoItemClickListener videoItemClickListener;
    private static final int ITEM = 0;
    Context mContext;
    String[] data;
    List<Video> videoList;

    String chapterName = "";

    public VideoAdapter(Context context, VideoItemClickListener videoItemClickListener) {
        videoList = new ArrayList<>();
        this.videoItemClickListener = videoItemClickListener;
        mContext = context;
    }

//    public AnsAdapter(Context context, QuizFragment quizFragment) {
////        mValues = new ArrayList<>();
////        mContext = context;
////        this.quizFragment = quizFragment;
//    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case ITEM:
                View viewItem = inflater.inflate(R.layout.video_item_row, parent, false);
                viewHolder = new HeroVH(viewItem);
                break;

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
         final Video video = videoList.get(position);

                final HeroVH itemHolder = (HeroVH) viewHolder;
                itemHolder.title.setText(video.getTitle());
                itemHolder.chapterName.setText(chapterName);
                 itemHolder.date.setText(UIHelper.dateTimeParse(video.getCreatedAt()));
                itemHolder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        videoItemClickListener.setVideoClickListener(video);
                    }
                });
        if(video.getVideoBanner()!=null  && !video.getVideoBanner().isEmpty()) {
            Picasso.get().load(video.getVideoBanner()).into(itemHolder.mPosterImg);
            itemHolder.chapterName.setVisibility(View.GONE);
        }
        else
        {
            itemHolder.chapterName.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public int getItemCount() {
        return videoList.size();
    }

    @Override
    public int getItemViewType(int position) {
//        if (position == 0) {
//            return HERO;
//        } else
        return ITEM;
    }


    protected class HeroVH extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView chapterName;
        private TextView date; // displays "year | language"
        private ImageView mPosterImg;
        private CardView cardView;

        public HeroVH(View itemView) {
            super(itemView);
            chapterName = itemView.findViewById(R.id.chapterName);
            title = itemView.findViewById(R.id.topic);
             date = itemView.findViewById(R.id.date);
            cardView = itemView.findViewById(R.id.cardView);
            mPosterImg = itemView.findViewById(R.id.img);
        }
    }

    public void add(Video r) {
        videoList.add(r);
        notifyItemInserted(videoList.size() - 1);
    }

    public void addAllData(List<Video> moveResults, String title) {
        for (Video result : moveResults) {
            add(result);
        }
        chapterName = title;

    }
//
//    public void remove(Option r) {
//        int position = mValues.indexOf(r);
//        if (position > -1) {
//            mValues.remove(position);
//            notifyItemRemoved(position);
//        }
//    }
//
//    public void clear() {
//        isLoadingAdded = false;
//        while (getItemCount() > 0) {
//            remove(getItem(0));
//        }
//    }
//
//    public Option getItem(int position) {
//        return mValues.get(position);
//    }
}