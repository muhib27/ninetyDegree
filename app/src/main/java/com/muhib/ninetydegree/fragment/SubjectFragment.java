package com.muhib.ninetydegree.fragment;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.muhib.ninetydegree.Interface.ItemClickListener;
import com.muhib.ninetydegree.Main2Activity;
import com.muhib.ninetydegree.R;

import com.muhib.ninetydegree.adapter.SubjectAdapter;
import com.muhib.ninetydegree.model.ClassListResponse;
import com.muhib.ninetydegree.model.SubjectModel;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

import static com.muhib.ninetydegree.fragment.DashboardFragment.SELECTED;


public class SubjectFragment extends Fragment implements ItemClickListener {
    String cls = "";
    ClassListResponse classListResponseModel;
    ClassListResponse classListResponse;
    SubjectAdapter subjectAdapter;
    private SubjectViewModel mViewModel;
    List<SubjectModel> subjectList;

    public static SubjectFragment newInstance() {
        return new SubjectFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.subject_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SubjectViewModel.class);
        // TODO: Use the ViewModel

        //callApi();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getActivity()!=null) {
            ((Main2Activity) getActivity()).tvHomeToolbarText.setText("Subject");
            ((Main2Activity) getActivity()).ivHomeMenuBarId1.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.left_arrow));

        }

        subjectList = new ArrayList<>();
        classListResponseModel = ViewModelProviders.of(getActivity()).get(ClassListResponse.class);
        classListResponse = classListResponseModel.getMutableLiveData().getValue();

        for(int i=0; i< classListResponse.getData().size(); i++){
            if(classListResponse.getData().get(i).getId().toString().equals(SELECTED)) {
                for (int j = 0; j < classListResponse.getData().get(i).getSubjects().size(); j++) {
                    subjectList = classListResponse.getData().get(i).getSubjects();
                    cls = classListResponse.getData().get(i).getName();
                }
                break;
            }
        }


        String[] data = { "15", "16", "17", "18", "19", "20", "21"};

        // set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycleview);
        int numberOfColumns = 1;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        subjectAdapter = new SubjectAdapter(getActivity(),  this);
//        com.muhib.ninetydegree.adapter.setClickListener(this);
        recyclerView.setAdapter(subjectAdapter);
        subjectAdapter.addAllData(subjectList,cls);
    }

    @Override
    public void setClickListener(int id) {
        Bundle bundle = new Bundle();
        bundle.putString("id", String.valueOf(id));
        ChapterFragment chapterFragment = new ChapterFragment();
        gotoFragment(chapterFragment, "chapterFragment", bundle);

    }

    private void gotoFragment(Fragment fragment, String tag, Bundle bundle) {
        // load com.muhib.ninetydegree.fragment
        // com.muhib.ninetydegree.fragment.setArguments(bundle);
        fragment.setArguments(bundle);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, tag);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
