package com.muhib.ninetydegree.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.muhib.ninetydegree.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class ImageSliderAdapter extends SliderViewAdapter<ImageSliderAdapter.SliderAdapterVH> {
    private Context context;
    private int mCount;

    public ImageSliderAdapter(Context context) {
        this.context = context;
    }

    public void setCount(int count) {
        this.mCount = count;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {
        switch (position) {
            case 0:
                viewHolder.textViewDescription.setTextSize(20);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
               // viewHolder.textViewDescription.setText("শহীদ স্মৃতি সৌধ");
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                viewHolder.imageViewBackground.setImageResource(R.drawable.one);
                break;
            case 1:
                viewHolder.textViewDescription.setTextSize(20);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
              //  viewHolder.textViewDescription.setText("হরিপুর রাজবাড়ি");
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageGifContainer.setVisibility(View.GONE);
                viewHolder.imageViewBackground.setImageResource(R.drawable.two);
                break;
            case 2:
                viewHolder.textViewDescription.setTextSize(20);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
               // viewHolder.textViewDescription.setText("আফাইল মসজিদ");
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
                viewHolder.imageViewBackground.setImageResource(R.drawable.three);
                break;
            default:
                viewHolder.textViewDescription.setTextSize(20);
                viewHolder.textViewDescription.setTextColor(Color.WHITE);
              //  viewHolder.textViewDescription.setText("কুল্লাপাথর শহীদ স্মৃতিসৌধ");
                viewHolder.imageGifContainer.setVisibility(View.VISIBLE);
                viewHolder.imageViewBackground.setImageResource(R.drawable.four);
                break;

        }

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mCount;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }
}
