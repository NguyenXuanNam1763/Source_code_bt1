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

public class UwaRecyclerAdapter extends RecyclerView.Adapter<UwaRecyclerAdapter.UwaViewHolder> {

    ArrayList<AnimalEntity> animalEntityArrayList;
    CallBackAdapter callBackAdapter;
    Context context;
    ArrayList<AnimalEntity> animalEntities=new ArrayList<>();

    public UwaRecyclerAdapter(ArrayList<AnimalEntity> animalEntityArrayList, CallBackAdapter callBackAdapter, Context context) {
        this.animalEntityArrayList = animalEntityArrayList;
        this.callBackAdapter = callBackAdapter;
        this.context = context;
    }

    @NonNull
    @Override
    public UwaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_recycleview,parent,false);
        return new UwaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UwaViewHolder holder, int position) {
        holder.txt_Animal.setText(animalEntities.get(position).getAnimal().getAnimalName());
        holder.img_Animal.setImageResource(animalEntities.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        int size=0;
        for(int i=0;i<animalEntityArrayList.size();i++){
            if(animalEntityArrayList.get(i).getClassify()==3){
                animalEntities.add(animalEntityArrayList.get(i));
                size+=1;
            }
        }
        return size;
    }

    public class UwaViewHolder extends RecyclerView.ViewHolder {
        public ImageView img_Animal;
        public TextView txt_Animal;
        public UwaViewHolder(@NonNull View itemView) {
            super(itemView);
            img_Animal = (ImageView) itemView.findViewById(R.id.img_animal);
            txt_Animal = (TextView) itemView.findViewById(R.id.txt_name_animal);
            img_Animal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBackAdapter.setPosition(animalEntities.get(getPosition()));
                }
            });
            txt_Animal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBackAdapter.setPosition(animalEntities.get(getPosition()));
                }
            });

        }
    }
}
