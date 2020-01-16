package com.muhib.ninetydegree.fragment;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.muhib.ninetydegree.R;
import com.muhib.ninetydegree.adapter.ImageSliderAdapter;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    TextView tv;
    SliderView sliderView;
    LinearLayout rlCoursesDashId1;
    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        sliderView = view.findViewById(R.id.imageSlider);
        tv = view.findViewById(R.id.tv);
        String st = "Developed By " + "90 DEGREE";
        final SpannableStringBuilder sb = new SpannableStringBuilder("Developed By 90 DEGREE");

// Span to set text color to some RGB value
        final ForegroundColorSpan fcs = new ForegroundColorSpan(Color.BLUE);

// Span to make text bold
        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);

// Set the text color for first 4 characters
        sb.setSpan(fcs, 13, 22, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

// make them also bold
        sb.setSpan(bss, 13, 22, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        tv.setText(sb);

//        final ImageSliderAdapter adapter = new ImageSliderAdapter(getContext());
//        adapter.setCount(4);
//        sliderView.setSliderAdapter(adapter);
//
//        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
//        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
//        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
//        sliderView.setIndicatorSelectedColor(Color.parseColor("#3ba110"));
//        sliderView.setIndicatorUnselectedColor(Color.WHITE);
//        sliderView.startAutoCycle();

        rlCoursesDashId1 = view.findViewById(R.id.rlCoursesDashId1);
        rlCoursesDashId1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HomeFragment homeFragment = new HomeFragment();
                gotoFragment(homeFragment, "homeFragment");
            }
        });

    }

    private void gotoFragment(Fragment fragment, String tag) {
        // load com.muhib.ninetydegree.fragment
        // com.muhib.ninetydegree.fragment.setArguments(bundle);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
