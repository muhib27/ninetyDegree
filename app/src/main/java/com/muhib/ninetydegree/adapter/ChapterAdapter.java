package com.muhib.ninetydegree.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.muhib.ninetydegree.Interface.ChapterItemClickListener;
import com.muhib.ninetydegree.Interface.ItemClickListener;
import com.muhib.ninetydegree.R;
import com.muhib.ninetydegree.UIHelper;
import com.muhib.ninetydegree.model.ChapterData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ChapterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ChapterItemClickListener chapterItemClickListener;
    private static final int ITEM = 0;
    Context mContext;
    String[] data;
    List<ChapterData> chapterDataList;

    public ChapterAdapter(Context context, ChapterItemClickListener chapterItemClickListener) {
        chapterDataList = new ArrayList<>();
        this.chapterItemClickListener = chapterItemClickListener;
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
                View viewItem = inflater.inflate(R.layout.chapter_item_row, parent, false);
                viewHolder = new HeroVH(viewItem);
                break;

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
         final ChapterData chapterData = chapterDataList.get(position);

                final HeroVH itemHolder = (HeroVH) viewHolder;
        itemHolder.cardView.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_transition));
                itemHolder.title.setText(chapterData.getTitle());
                itemHolder.subjectName.setText(chapterData.getSubjectName());
                itemHolder.date.setText(UIHelper.dateTimeParse(chapterData.getCreatedAt()));
                itemHolder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        chapterItemClickListener.setChapterClickListener(chapterData);
                    }
                });
        if(chapterData.getChapterBanner()!=null  && !chapterData.getChapterBanner().isEmpty()) {
            Picasso.get().load(chapterData.getChapterBanner()).into(itemHolder.mPosterImg);
            itemHolder.subjectName.setVisibility(View.GONE);
        }
        else
        {
            itemHolder.subjectName.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public int getItemCount() {
        return chapterDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
//        if (position == 0) {
//            return HERO;
//        } else
        return ITEM;
    }


    protected class HeroVH extends RecyclerView.ViewHolder {
        private TextView title, subjectName, date;
        private TextView mMovieDesc;
        private TextView mYear; // displays "year | language"
        private ImageView mPosterImg;
        private CardView cardView;

        public HeroVH(View itemView) {
            super(itemView);
             title = itemView.findViewById(R.id.chapter);
            subjectName = itemView.findViewById(R.id.subjectName);
            date = itemView.findViewById(R.id.date);
            cardView = itemView.findViewById(R.id.cardView);
            mPosterImg = itemView.findViewById(R.id.img);

        }
    }

    public void add(ChapterData r) {
        chapterDataList.add(r);
        notifyItemInserted(chapterDataList.size() - 1);
    }

    public void addAllData(List<ChapterData> moveResults) {
        for (ChapterData result : moveResults) {
            add(result);
        }

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