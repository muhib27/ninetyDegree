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
import com.muhib.ninetydegree.R;


public class SubjectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ItemClickListener itemClickListener;
    private static final int ITEM = 0;
    Context mContext;
    String[] data;

    public SubjectAdapter(Context context, String[] data, ItemClickListener itemClickListener) {
        this.data = data;
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
                View viewItem = inflater.inflate(R.layout.class_item_row, parent, false);
                viewHolder = new HeroVH(viewItem);
                break;

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
//         final Option optionModel = mValues.get(position);
        switch (getItemViewType(position)) {
            case ITEM:
                final HeroVH itemHolder = (HeroVH) viewHolder;
                itemHolder.title.setText(data[position]);
                itemHolder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemClickListener.setClickListener(position);
                    }
                });
                break;
        }
    }


    @Override
    public int getItemCount() {
        return data.length;
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
        private TextView mMovieDesc;
        private TextView mYear; // displays "year | language"
        private ImageView mPosterImg;
        private CardView cardView;

        public HeroVH(View itemView) {
            super(itemView);
             title = itemView.findViewById(R.id.tvCoursesDashId1);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }

//    public void add(Option r) {
//        mValues.add(r);
//        notifyItemInserted(mValues.size() - 1);
//    }
//
//    public void addAllData(List<Option> moveResults, int questionCount, String type) {
//        for (Option result : moveResults) {
//            add(result);
//        }
//        question = questionCount;
//        questionType = type;
//    }
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