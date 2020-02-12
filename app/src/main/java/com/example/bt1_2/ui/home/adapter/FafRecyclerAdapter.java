package com.example.bt1_2.ui.home.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bt1_2.R;
import com.example.bt1_2.data.model.abs.Animal;
import com.example.bt1_2.data.model.entity.AnimalEntity;
import com.example.bt1_2.ui.home.Interface.CallBackFavorite;

import java.util.ArrayList;

public class FafRecyclerAdapter extends RecyclerView.Adapter<FafRecyclerAdapter.FafViewHolder> {
    ArrayList<AnimalEntity> favoriteList;
    ArrayList<AnimalEntity> getFavoriteList=new ArrayList<>();
    Context context;
    CallBackFavorite callBackFavorite;
    ArrayList<AnimalEntity> animalEntitiesDel = new ArrayList<>();
    int vitri = -1;

    public FafRecyclerAdapter(ArrayList<AnimalEntity> favoriteList, Context context, CallBackFavorite callBackFavorite) {
        this.favoriteList = favoriteList;
        this.context = context;
        this.callBackFavorite = callBackFavorite;
    }

    @NonNull
    @Override
    public FafViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_recycleview, parent, false);
        return new FafViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FafViewHolder holder, int position) {
        holder.txt_Animal.setText(getFavoriteList.get(position).getNameAnimal());
        Glide.with(context).load(getFavoriteList.get(position).getImg_Url()).into(holder.img_Animal);
        if (vitri == position) {
            holder.img_Opacity.setBackgroundResource(R.color.colorgay);
            animalEntitiesDel.add(favoriteList.get(position));
            callBackFavorite.getArrayDel(animalEntitiesDel);
            Log.d("iii", String.valueOf(animalEntitiesDel.size()));
        }
    }

    @Override
    public int getItemCount() {
        getFavoriteList.clear();
        int size = 0;
        for (int i = 0; i < favoriteList.size(); i++) {
            if (favoriteList.get(i).getLike() == 1){
                getFavoriteList.add(favoriteList.get(i));
                size+=1;
            }
        }
        return size;
    }

    public class FafViewHolder extends RecyclerView.ViewHolder {
        public ImageView img_Animal;
        public TextView txt_Animal;
        public RelativeLayout ll_item;
        public ImageView img_Opacity;

        public FafViewHolder(@NonNull View itemView) {
            super(itemView);
            img_Animal = (ImageView) itemView.findViewById(R.id.img_animal);
            txt_Animal = (TextView) itemView.findViewById(R.id.txt_name_animal);
            img_Opacity = (ImageView) itemView.findViewById(R.id.img_opacity);
            ll_item = (RelativeLayout) itemView.findViewById(R.id.ll_item);
            ll_item.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    vitri = getPosition();
                    notifyDataSetChanged();
                    animalEntitiesDel.add(getFavoriteList.get(getPosition()));
                    return false;
                }
            });

        }
    }
}
