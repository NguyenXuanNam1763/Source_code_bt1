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
import com.example.bt1_2.ui.home.adapter.UwaRecyclerAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class UnderWarterAnimalFragment extends Fragment implements CallBackAdapter {
    RecyclerView rcv_fuwa;
    UwaRecyclerAdapter uwaRecyclerAdapter;
    private ArrayList<AnimalEntity> animalEntityArrayList;
    private CallBackActivity callBackActivity;

    public UnderWarterAnimalFragment(ArrayList<AnimalEntity> animalEntityArrayList,CallBackActivity callBackActivity) {
        this.animalEntityArrayList=animalEntityArrayList;
        this.callBackActivity=callBackActivity;
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_under_warter_animal, container, false);
        rcv_fuwa=(RecyclerView) view.findViewById(R.id.rcv_fuaw);
        uwaRecyclerAdapter=new UwaRecyclerAdapter(animalEntityArrayList,this,getContext());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rcv_fuwa.setLayoutManager(linearLayoutManager);
        rcv_fuwa.setAdapter(uwaRecyclerAdapter);
        return view;
    }

    @Override
    public void setPosition(AnimalEntity animalEntity) {
        callBackActivity.callBackPosition(animalEntity);
    }
}
