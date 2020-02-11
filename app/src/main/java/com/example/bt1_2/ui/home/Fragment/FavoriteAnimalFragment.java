package com.example.bt1_2.ui.home.Fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bt1_2.R;
import com.example.bt1_2.data.model.entity.AnimalEntity;
import com.example.bt1_2.ui.home.Interface.CallBackFavorite;
import com.example.bt1_2.ui.home.Interface.CallBackFavoriteActivity;
import com.example.bt1_2.ui.home.adapter.FafRecyclerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteAnimalFragment extends Fragment implements CallBackFavorite {
    RecyclerView rcvFavorite;
    ArrayList<AnimalEntity> animaFavoriteList;
    ArrayList<AnimalEntity> animalEntitiesDel=new ArrayList<>();
    CallBackFavoriteActivity callBackFavoriteActivity;
    FafRecyclerAdapter fafRecyclerAdapter;
    BottomNavigationView navigationView;

    public FavoriteAnimalFragment(ArrayList<AnimalEntity> animaFavoriteList,CallBackFavoriteActivity callBackFavoriteActivity) {
        this.animaFavoriteList=animaFavoriteList;
        this.callBackFavoriteActivity=callBackFavoriteActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_favorite_animal, container, false);
        rcvFavorite=(RecyclerView) view.findViewById(R.id.rcv_ffa);
        fafRecyclerAdapter=new FafRecyclerAdapter(animaFavoriteList,getContext(),this);
        navigationView=(BottomNavigationView) view.findViewById(R.id.btnnview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rcvFavorite.setLayoutManager(linearLayoutManager);
        rcvFavorite.setAdapter(fafRecyclerAdapter);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_del:
                        int i=animaFavoriteList.size()-1;
                        if(animalEntitiesDel.size()>0){
                            while(i>=0){
                                for(int j=0;j<animalEntitiesDel.size();j++){
                                    if(animaFavoriteList.get(i).getAnimal().getAnimalName().equals(animalEntitiesDel.get(j).getAnimal().getAnimalName())){
                                        animaFavoriteList.remove(i);
                                    }
                                }
                                i--;
                            }
                            fafRecyclerAdapter.notifyDataSetChanged();
                            Toast.makeText(getContext(),"Delete complete!",Toast.LENGTH_SHORT).show();
                        }

                        break;
                }
                return false;
            }
        });
        return view;
    }

    @Override
    public void getArrayDel(ArrayList<AnimalEntity> animalEntitiesList) {
        animalEntitiesDel.clear();
        for(int i=0;i<animalEntitiesList.size();i++){
            animalEntitiesDel.add(animalEntitiesList.get(i));
        }
        Log.d("sizelist",String.valueOf(animalEntitiesDel.size()));
        callBackFavoriteActivity.getList(animalEntitiesList);
    }

}
