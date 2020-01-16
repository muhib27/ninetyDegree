//package com.muhib.ninetydegree.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.muhib.ninetydegree.Interface.ItemClickListener;
//import com.muhib.ninetydegree.R;
//
//
//public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassViewHolder> {
//    Context context;
//    String[] data;
//    ItemClickListener itemClickListener;
//
//    public ClassAdapter(Context context, String[] data, ItemClickListener itemClickListener) {
//        this.context = context;
//        this.data = data;
//        this.itemClickListener = itemClickListener;
//    }
//
//    @NonNull
//    @Override
//    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(context)
//                .inflate(R.layout.class_item_row, parent, false);
//        return new ClassViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ClassViewHolder holder, final int position) {
////        final Blog blog = blogList.get(position);
////        holder.blog_imageView.setImageResource(blog.getIcon());
////        holder.tv_blog_title.setText(blog.getName());
////        holder.blog_cardView.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                itemClickListener.setClickListener(position);
////            }
////        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return data.length;
//    }
//
//    public class ClassViewHolder extends RecyclerView.ViewHolder {
//
//        TextView textView;
//
//
//        public ClassViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//        }
//    }
//}
