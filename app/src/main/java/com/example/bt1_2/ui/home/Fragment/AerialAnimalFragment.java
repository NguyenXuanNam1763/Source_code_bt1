package com.example.bt1_2.ui.home.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bt1_2.R;
import com.example.bt1_2.data.model.entity.AnimalEntity;
import com.example.bt1_2.ui.home.Interface.CallBackActivity;
import com.example.bt1_2.ui.home.Interface.CallBackAdapter;
import com.example.bt1_2.ui.home.adapter.AafRecyclerAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AerialAnimalFragment extends Fragment implements CallBackAdapter {
    AafRecyclerAdapter aafRecyclerAdapter;
    RecyclerView rcv_AAniaml;
    ArrayList<AnimalEntity> animalEntityArrayList;
    CallBackActivity callBackActivity;

    public AerialAnimalFragment(ArrayList<AnimalEntity> animalEntityArrayList,CallBackActivity callBackActivity) {
        this.animalEntityArrayList=animalEntityArrayList;
        this.callBackActivity=callBackActivity;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_aerial_animal,container,false);
        rcv_AAniaml=(RecyclerView) view.findViewById(R.id.rcv_fam);
        aafRecyclerAdapter=new AafRecyclerAdapter(this,getContext(),animalEntityArrayList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rcv_AAniaml.setLayoutManager(linearLayoutManager);
        rcv_AAniaml.setAdapter(aafRecyclerAdapter);
        return view;
    }

    @Override
    public void setPosition(AnimalEntity animalEntity) {
        callBackActivity.callBackPosition(animalEntity);
    }
}
