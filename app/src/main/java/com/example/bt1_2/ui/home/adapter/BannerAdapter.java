package com.example.bt1_2.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bt1_2.R;
import com.example.bt1_2.data.model.entity.Banner;
import com.example.bt1_2.ui.home.Interface.CallBackBanner;

import java.util.ArrayList;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {
    ArrayList<Banner> bannerArrayList;
    Context context;
    CallBackBanner callBackBanner;

    public BannerAdapter(ArrayList<Banner> bannerArrayList, Context context,CallBackBanner callBackBanner) {
        this.bannerArrayList = bannerArrayList;
        this.context = context;
        this.callBackBanner=callBackBanner;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item_slide,parent,false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        final Banner banner=bannerArrayList.get(position);
        if(banner!=null){
            Glide.with(context).load(banner.getImg_url()).into(holder.img_Banner);
            holder.img_Banner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callBackBanner.getList(banner);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return bannerArrayList.size();
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView img_Banner;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            img_Banner=(ImageView) itemView.findViewById(R.id.img_slide);
        }
    }
}
