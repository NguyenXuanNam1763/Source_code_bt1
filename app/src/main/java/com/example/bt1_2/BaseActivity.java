package com.example.bt1_2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.InetAddresses;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.toolbox.Volley;
import com.example.bt1_2.data.model.abs.Animal;
import com.example.bt1_2.data.model.entity.AnimalEntity;
import com.example.bt1_2.data.model.entity.Arowana;
import com.example.bt1_2.data.model.entity.Banner;
import com.example.bt1_2.data.model.entity.Carp;
import com.example.bt1_2.data.model.entity.Eagle;
import com.example.bt1_2.data.model.entity.Giraffe;
import com.example.bt1_2.data.model.entity.Lion;
import com.example.bt1_2.data.model.entity.Monkey;
import com.example.bt1_2.data.model.entity.Parrots;
import com.example.bt1_2.data.model.entity.Python;
import com.example.bt1_2.data.model.entity.Snake;
import com.example.bt1_2.data.model.entity.Tiger;
import com.android.volley.RequestQueue;
import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity {
    public ArrayList<AnimalEntity> animalArrayList=new ArrayList<>();
    public ArrayList<AnimalEntity> favoriteAnimalList=new ArrayList<>();
    public ArrayList<Banner> bannerArrayList=new ArrayList<>();
    public RequestQueue requestQueue;
    public static final String URL_BANNER_ANIMALS="http://git.segu.vn:89/snippets/70/raw";
    public static final String URL_REPTILE_ANIMALS="http://git.segu.vn:89/snippets/72/raw";
    public static final String URL_MAMMAL_ANIMALS="http://git.segu.vn:89/snippets/73/raw";
    public static final String URL_BIRD_ANIMALS="http://git.segu.vn:89/snippets/75/raw";
    public static final String URL_FISH_ANIMALS="http://git.segu.vn:89/snippets/74/raw";
    public static final String URL_TIGER_ANIMAL="http://git.segu.vn:89/snippets/76/raw";
    public static final String URL_LION_ANIMAL="http://git.segu.vn:89/snippets/77/raw";
    public static final String URL_MONKEY_ANIMAl="http://git.segu.vn:89/snippets/78/raw";
    public static final String URL_GIRAFFE_ANIMAL="http://git.segu.vn:89/snippets/79/raw";
    public static final String URL_CARP_ANIMAL="http://git.segu.vn:89/snippets/80/raw";
    public static final String URL_AROWANA_ANIMAL="http://git.segu.vn:89/snippets/81/raw";
    public static final String URL_PYTHON_ANIMAL="http://git.segu.vn:89/snippets/82/raw";
    public static final String URL_SNAKE_ANIMAL="http://git.segu.vn:89/snippets/83/raw";
    public static final String URL_PARROTS_ANIMAL="http://git.segu.vn:89/snippets/84/raw";
    public static final String URL_EAGLE_ANIMAL="http://git.segu.vn:89/snippets/85/raw";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }
    private void init(){
        requestQueue=Volley.newRequestQueue(this);
    }
}
