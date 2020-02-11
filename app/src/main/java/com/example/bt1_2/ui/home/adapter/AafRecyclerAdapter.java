package com.example.bt1_2.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bt1_2.R;
import com.example.bt1_2.data.model.entity.AnimalEntity;
import com.example.bt1_2.ui.home.Interface.CallBackAdapter;

import java.util.ArrayList;

public class AafRecyclerAdapter extends RecyclerView.Adapter<AafRecyclerAdapter.AafViewHolder> {
    CallBackAdapter callBackAdapter;
    Context context;
    ArrayList<AnimalEntity> animalEntityArrayList;
    ArrayList<AnimalEntity> animalEntitiesList = new ArrayList<>();

    public AafRecyclerAdapter(CallBackAdapter callBackAdapter, Context context, ArrayList<AnimalEntity> animalEntityArrayList) {
        this.callBackAdapter = callBackAdapter;
        this.context = context;
        this.animalEntityArrayList = animalEntityArrayList;
    }

    @NonNull
    @Override
    public AafViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_recycleview, parent, false);
        return new AafViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AafViewHolder holder, int position) {
        holder.txt_Animal.setText(animalEntitiesList.get(position).getAnimal().getAnimalName());
        holder.img_Animal.setImageResource(animalEntitiesList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        int size = 0;
        for (int i = 0; i < animalEntityArrayList.size(); i++) {
            if (animalEntityArrayList.get(i).getClassify() == 2) {
                animalEntitiesList.add(animalEntityArrayList.get(i));
                size += 1;
            }
        }
        return size;
    }

    public class AafViewHolder extends RecyclerView.ViewHolder {
        public ImageView img_Animal;
        public TextView txt_Animal;

        public AafViewHolder(@NonNull View itemView) {
            super(itemView);
            img_Animal = (ImageView) itemView.findViewById(R.id.img_animal);
            txt_Animal = (TextView) itemView.findViewById(R.id.txt_name_animal);
            txt_Animal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBackAdapter.setPosition(animalEntitiesList.get(getPosition()));
                }
            });
        }
    }
}
