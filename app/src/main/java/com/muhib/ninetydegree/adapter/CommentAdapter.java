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
import com.muhib.ninetydegree.model.Comments;

import org.w3c.dom.Comment;

import java.util.List;


public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ItemClickListener itemClickListener;
    private static final int ITEM = 0;
    Context mContext;
    List<Comments> commentList;

    public CommentAdapter(Context context, List<Comments> commentList, ItemClickListener itemClickListener) {
        this.commentList = commentList;
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
                View viewItem = inflater.inflate(R.layout.comment_item_row, parent, false);
                viewHolder = new HeroVH(viewItem);
                break;

        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {
         final Comments comments = commentList.get(position);
                final HeroVH itemHolder = (HeroVH) viewHolder;
                itemHolder.name.setText(comments.getUserName());
                itemHolder.title.setText(comments.getComments());
                itemHolder.cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemClickListener.setClickListener(position);
                    }
                });
    }


    @Override
    public int getItemCount() {
        return commentList.size();
    }

    @Override
    public int getItemViewType(int position) {
//        if (position == 0) {
//            return HERO;
//        } else
        return ITEM;
    }


    protected class HeroVH extends RecyclerView.ViewHolder {
        private TextView title, name;
        private TextView mMovieDesc;
        private TextView mYear; // displays "year | language"
        private ImageView mPosterImg;
        private CardView cardView;

        public HeroVH(View itemView) {
            super(itemView);
             name = itemView.findViewById(R.id.name);
            title = itemView.findViewById(R.id.title);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }

    public void add(Comments r) {
        commentList.add(r);
        notifyItemInserted(commentList.size() - 1);
    }

    public void addAllData(List<Comments> moveResults) {
        for (Comments result : moveResults) {
            add(result);
        }

    }

    public void remove(Comments r) {
        int position = commentList.indexOf(r);
        if (position > -1) {
            commentList.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
       // isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public Comments getItem(int position) {
        return commentList.get(position);
    }
}