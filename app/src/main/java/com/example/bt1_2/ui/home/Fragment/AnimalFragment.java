package com.example.bt1_2.ui.home.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bt1_2.R;
import com.example.bt1_2.data.model.entity.AnimalEntity;
import com.example.bt1_2.ui.home.Interface.CallBackActivity;
import com.example.bt1_2.ui.home.Interface.CallBackAdapter;
import com.example.bt1_2.ui.home.adapter.AnimalAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimalFragment extends Fragment implements CallBackAdapter {
    RecyclerView rcv_fgm;
    AnimalAdapter adapter;
    CallBackActivity callBackActivity;
    private ArrayList<AnimalEntity> animalEntityArrayList;
    private int layout;
    private int species;
    private int layout_Item;

    public AnimalFragment(ArrayList<AnimalEntity> animalEntityArrayList, CallBackActivity callBackActivity, int layout, int species, int layout_Item) {
        // Required empty public constructor
        this.animalEntityArrayList = animalEntityArrayList;
        this.callBackActivity = callBackActivity;
        this.layout=layout;
        this.species=species;
        this.layout_Item=layout_Item;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LayoutInflater inflater1 = LayoutInflater.from(getContext());
        View view = inflater.inflate(layout, container, false);
        adapter = new AnimalAdapter(getContext(), animalEntityArrayList, this,species,layout_Item);
        rcv_fgm = (RecyclerView) view.findViewById(R.id.rcv_fgm);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rcv_fgm.setLayoutManager(linearLayoutManager);
        rcv_fgm.setAdapter(adapter);
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        };
        Handler handler=new Handler();
        handler.postDelayed(runnable,1000);
        return view;
    }

    @Override
    public void setPosition(AnimalEntity animalEntity) {
        callBackActivity.callBackPosition(animalEntity);
    }
}
