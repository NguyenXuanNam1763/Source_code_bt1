package com.example.bt1_2.ui.home.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bt1_2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteAnimalFragment extends Fragment {


    public FavoriteAnimalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_animal, container, false);
    }

}
