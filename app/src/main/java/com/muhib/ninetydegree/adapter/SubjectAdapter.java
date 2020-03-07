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

import com.muhib.ninetydegree.Interface.ItemClickListener;
import com.muhib.ninetydegree.R;
import com.muhib.ninetydegree.UIHelper;
import com.muhib.ninetydegree.model.SubjectModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;


public class SubjectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ItemClickListener itemClickListener;
    private static final int ITEM = 0;
    Context mContext;
    List<SubjectModel> subjectList;
    String[] data;
    String clsNm;

    public SubjectAdapter(Context context, ItemClickListener itemClickListener) {
        this.subjectList = new ArrayList<>();
        this.itemClickListener = itemClickListener;
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
                View viewItem = inflater.inflate(R.layout.subject_item_row, parent, false);
                viewHolder = new HeroVH(viewItem);
                break;

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
         final SubjectModel subjectModel = subjectList.get(position);

                final HeroVH itemHolder = (HeroVH) viewHolder;
                itemHolder.cardView.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_transition));
                itemHolder.title.setText(subjectModel.getSubjectName());
                itemHolder.className.setText(clsNm);
                itemHolder.date.setText(UIHelper.dateTimeParse(subjectModel.getSubjectCreatedDate()));
                itemHolder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemClickListener.setClickListener(subjectModel.getSubjectId());
                    }
                });
                if(subjectModel.getSubjectBanner()!=null) {
                    Picasso.get().load(subjectModel.getSubjectBanner()).into(itemHolder.mPosterImg);
                    itemHolder.className.setVisibility(View.GONE);
                }
                else
                {
                    itemHolder.className.setVisibility(View.VISIBLE);
                }

    }


    @Override
    public int getItemCount() {
        return subjectList.size();
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
        private TextView className;
        private TextView date; // displays "year | language"
        private ImageView mPosterImg;
        private CardView cardView;

        public HeroVH(View itemView) {
            super(itemView);
             title = itemView.findViewById(R.id.tvCoursesDashId1);
            className = itemView.findViewById(R.id.className);
            date = itemView.findViewById(R.id.date);
            cardView = itemView.findViewById(R.id.cardView);
            mPosterImg = itemView.findViewById(R.id.img);

        }
    }

    public void add(SubjectModel r) {
        subjectList.add(r);
        notifyItemInserted(subjectList.size() - 1);
    }

    public void addAllData(List<SubjectModel> moveResults , String cls) {
        for (SubjectModel result : moveResults) {
            add(result);
        }
        clsNm = cls;
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