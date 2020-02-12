package com.example.bt1_2.ui.home.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bt1_2.R;
import com.example.bt1_2.data.model.entity.AnimalEntity;
import com.example.bt1_2.ui.home.Interface.CallBackAdapter;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.GafViewHolder> {

    private Context context;
    private ArrayList<AnimalEntity> animalEntityArrayList;
    private CallBackAdapter callBackAdapter;
    private ArrayList<AnimalEntity> animalGafList = new ArrayList<>();
    private int species;
    private int layout_Item;

    public AnimalAdapter(Context context, ArrayList<AnimalEntity> animalEntityArrayList, CallBackAdapter callBackAdapter, int species, int layout_Item) {
        this.context = context;
        this.animalEntityArrayList = animalEntityArrayList;
        this.callBackAdapter = callBackAdapter;
        this.species=species;
        this.layout_Item=layout_Item;
    }

    @NonNull
    @Override
    public GafViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layout_Item, parent, false);

        return new GafViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GafViewHolder holder, int position) {
        holder.txt_Animal.setText(animalGafList.get(position).getNameAnimal());
        Glide.with(context).load(animalGafList.get(position).getImg_Url()).into(holder.img_Animal);
    }

    @Override
    public int getItemCount() {
        return getCount(species);
    }

    public class GafViewHolder extends RecyclerView.ViewHolder {
        public ImageView img_Animal;
        public TextView txt_Animal;

        public GafViewHolder(@NonNull View itemView) {
            super(itemView);
            img_Animal = (ImageView) itemView.findViewById(R.id.img_animal);
            txt_Animal = (TextView) itemView.findViewById(R.id.txt_name_animal);
            txt_Animal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBackAdapter.setPosition(animalGafList.get(getPosition()));
                }
            });
            img_Animal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBackAdapter.setPosition(animalGafList.get(getPosition()));
                }
            });
        }
    }
    public int getCount(int species){
        animalGafList.clear();
        int size = 0;
        for (int i = 0; i < animalEntityArrayList.size(); i++) {
            if (animalEntityArrayList.get(i).getSpecies()==species) {
                animalGafList.add(animalEntityArrayList.get(i));
                size += 1;
                Log.d("size", String.valueOf(size));
            }
        }
        return size;
    }
}
