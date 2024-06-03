package com.example.cuoiki;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CourseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CourseFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerViewData;
    RecyclerView recyclerViewLandScape;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CourseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CourseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CourseFragment newInstance(String param1, String param2) {
        CourseFragment fragment = new CourseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course, container, false);
        recyclerViewData = getRecyclerViewData();
        //4:
        recyclerViewLandScape = view.findViewById(R.id.recyclerLand);
        //5:
//        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
//        recyclerViewLandScape.setLayoutManager(layoutLinear);
//        RecyclerView.LayoutManager layoutLinearHorizonal = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
//        recyclerViewLandScape.setLayoutManager(layoutLinearHorizonal);
        RecyclerView.LayoutManager layoutGrid = new GridLayoutManager(getActivity(), 2);
        recyclerViewLandScape.setLayoutManager(layoutGrid);
        //6:
        landScapeAdapter = new LandScapeAdapter(getActivity(), recyclerViewData);
        //7:
        recyclerViewLandScape.setAdapter(landScapeAdapter);
        return view;
    }

    ArrayList<LandScape> getRecyclerViewData() {
        ArrayList<LandScape> dsDuLieu = new ArrayList<>();
        dsDuLieu.add(new LandScape("thaphanoi", "Cột cờ Hà Nội"));
        dsDuLieu.add(new LandScape("effel", "Tháp Effel"));
        dsDuLieu.add(new LandScape("buckingham", "Cung điện Buckinghham"));
        dsDuLieu.add(new LandScape("thaphanoi", "Cột cờ Hà Nội"));
        dsDuLieu.add(new LandScape("effel", "Tháp Effel"));
        dsDuLieu.add(new LandScape("buckingham", "Cung điện Buckinghham"));
        return dsDuLieu;
    }
}