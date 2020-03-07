package com.muhib.ninetydegree.fragment;

import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.muhib.ninetydegree.Interface.ItemClickListener;
import com.muhib.ninetydegree.MainActivity;
import com.muhib.ninetydegree.R;
import com.muhib.ninetydegree.adapter.MyAdapter;

//
//import com.muhib.ninetydegree.adapter.ClassAdapter;

public class HomeFragment extends Fragment implements ItemClickListener {

    private HomeViewModel mViewModel;
    MyAdapter adapter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // mViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
//        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        ((MainActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // data to populate the RecyclerView with
        String[] data = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

        // set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycleview);
        int numberOfColumns = 1;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        adapter = new MyAdapter(getActivity(), data, this);
//        com.muhib.ninetydegree.adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setClickListener(int pos) {

      //  Toast.makeText(getActivity(), "" + pos, Toast.LENGTH_LONG).show();
        SubjectFragment subjectFragment = new SubjectFragment();
        gotoFragment(subjectFragment, "subjectFragment");
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
