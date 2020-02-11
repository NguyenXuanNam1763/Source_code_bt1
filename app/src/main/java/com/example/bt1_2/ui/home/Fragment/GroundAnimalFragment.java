package com.example.bt1_2.ui.home.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bt1_2.R;
import com.example.bt1_2.data.model.entity.AnimalEntity;
import com.example.bt1_2.ui.home.Interface.CallBackActivity;
import com.example.bt1_2.ui.home.Interface.CallBackAdapter;
import com.example.bt1_2.ui.home.adapter.GafRecyclerAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroundAnimalFragment extends Fragment implements CallBackAdapter {
    RecyclerView rcv_fgm;
    GafRecyclerAdapter adapter;
    CallBackActivity callBackActivity;
    private ArrayList<AnimalEntity> animalEntityArrayList;

    public GroundAnimalFragment(ArrayList<AnimalEntity> animalEntityArrayList,CallBackActivity callBackActivity) {
        // Required empty public constructor
        this.animalEntityArrayList=animalEntityArrayList;
        this.callBackActivity=callBackActivity;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater inflater1=LayoutInflater.from(getContext());
        View view=inflater.inflate(R.layout.fragment_ground_animal,container,false);
        adapter=new GafRecyclerAdapter(getContext(),animalEntityArrayList,this);
        rcv_fgm=(RecyclerView) view.findViewById(R.id.rcv_fgm);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rcv_fgm.setLayoutManager(linearLayoutManager);
        rcv_fgm.setAdapter(adapter);
        return view;
    }

    @Override
    public void setPosition(AnimalEntity animalEntity) {
        callBackActivity.callBackPosition(animalEntity);
    }
}
