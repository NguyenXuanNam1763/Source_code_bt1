package com.example.bt1_2.ui.home.adapter;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bt1_2.R;
import com.example.bt1_2.data.model.entity.AnimalEntity;
import com.example.bt1_2.ui.home.Interface.CallBackAdapter;

import java.util.ArrayList;

public class GafRecyclerAdapter extends RecyclerView.Adapter<GafRecyclerAdapter.GafViewHolder> {

    private Context context;
    private ArrayList<AnimalEntity> animalEntityArrayList;
    private CallBackAdapter callBackAdapter;
    private ArrayList<AnimalEntity> animalGafList = new ArrayList<>();

    public GafRecyclerAdapter(Context context, ArrayList<AnimalEntity> animalEntityArrayList, CallBackAdapter callBackAdapter) {
        this.context = context;
        this.animalEntityArrayList = animalEntityArrayList;
        this.callBackAdapter = callBackAdapter;
    }

    @NonNull
    @Override
    public GafViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_recycleview, parent, false);

        return new GafViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GafViewHolder holder, int position) {
        Log.d("socon", animalEntityArrayList.get(position).getAnimal().getAnimalName());
        holder.txt_Animal.setText(animalGafList.get(position).getAnimal().getAnimalName());
        holder.img_Animal.setImageResource(animalGafList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        int size = 0;
        for (int i = 0; i < animalEntityArrayList.size(); i++) {
            if (animalEntityArrayList.get(i).getClassify() == 1) {
                animalGafList.add(animalEntityArrayList.get(i));
                size += 1;
                Log.d("size", String.valueOf(size));
            }
        }
        return size;
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
}
