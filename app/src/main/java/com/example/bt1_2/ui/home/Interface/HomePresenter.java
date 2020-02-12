package com.example.bt1_2.ui.home.Interface;

import com.android.volley.RequestQueue;
import com.example.bt1_2.data.model.entity.AnimalEntity;
import com.example.bt1_2.data.model.entity.Banner;

import java.util.ArrayList;

public interface HomePresenter {
    void getDataApiBanner(ArrayList<Banner> arrayList);
    void getDataApiAnimal(ArrayList<AnimalEntity> arrayList);
}
