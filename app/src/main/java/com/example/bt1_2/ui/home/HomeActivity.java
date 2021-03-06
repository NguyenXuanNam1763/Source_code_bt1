package com.example.bt1_2.ui.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.bt1_2.BaseActivity;
import com.example.bt1_2.R;
import com.example.bt1_2.data.model.entity.AnimalEntity;
import com.example.bt1_2.data.model.entity.Banner;
import com.example.bt1_2.ui.detailanimal.DetailAnimalActivity;
import com.example.bt1_2.ui.home.Fragment.FavoriteAnimalFragment;
import com.example.bt1_2.ui.home.Fragment.AnimalFragment;
import com.example.bt1_2.ui.home.Interface.CallBackActivity;
import com.example.bt1_2.ui.home.Interface.CallBackBanner;
import com.example.bt1_2.ui.home.Interface.HomePresenter;
import com.example.bt1_2.ui.home.adapter.BannerAdapter;
import com.example.bt1_2.ui.home.adapter.TabLayoutAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity implements CallBackActivity, HomePresenter,CallBackBanner {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AnimalFragment bird;
    private AnimalFragment manmal;
    private RecyclerView rcv_Banner;
    private AnimalFragment fish;
    private FavoriteAnimalFragment favoriteAnimalFragment;
    private TabLayoutAdapter tabLayoutAdapter;
    private int code_detail = 100;
    private HomeModel homeModel;
    private BannerAdapter bannerAdapter;
    LinearLayoutManager linearLayoutManager;
    StartSnapHelper startSnapHelper = new StartSnapHelper();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mapping();
        checkConnection();
    }

    private void mapping() {
        rcv_Banner = (RecyclerView) findViewById(R.id.rcv_slide);
        tabLayout = (TabLayout) findViewById(R.id.tbl_home);
        viewPager = (ViewPager) findViewById(R.id.vpg_home);
        homeModel = new HomeModel(HomeActivity.this, requestQueue);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rcv_Banner.setLayoutManager(linearLayoutManager);
        bannerAdapter = new BannerAdapter(bannerArrayList, this,this);
        rcv_Banner.setAdapter(bannerAdapter);
        bannerAdapter.notifyDataSetChanged();
        bird = new AnimalFragment(animalArrayList, this, R.layout.fragment_animal, 3, R.layout.item_recycleview);
        fish = new AnimalFragment(animalArrayList, this, R.layout.fragment_animal, 4, R.layout.item_recycleview);
        manmal = new AnimalFragment(animalArrayList, this, R.layout.fragment_animal, 2, R.layout.item_recycleview);
        favoriteAnimalFragment = new FavoriteAnimalFragment(animalArrayList);
    }

    private void addtab(ViewPager viewPager) {
        tabLayoutAdapter = new TabLayoutAdapter(getSupportFragmentManager());
        tabLayoutAdapter.add(manmal, "Manmal");
        tabLayoutAdapter.add(bird, "Bird");
        tabLayoutAdapter.add(fish, "Fish");
        tabLayoutAdapter.add(favoriteAnimalFragment, "Favorite Animal");
        viewPager.setAdapter(tabLayoutAdapter);
    }

    @Override
    public void callBackPosition(AnimalEntity animalEntity) {
        Intent intent = new Intent(this, DetailAnimalActivity.class);
        intent.putExtra("Animal", animalEntity);
        startActivityForResult(intent, code_detail);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == code_detail && resultCode == RESULT_OK && data != null) {
            AnimalEntity animalEntity = (AnimalEntity) data.getSerializableExtra("Animal");
            if(animalEntity!=null){
                for (int i = 0; i < animalArrayList.size(); i++) {
                    if (animalArrayList.get(i).getAnimal_Id() == animalEntity.getAnimal_Id())
                        animalArrayList.get(i).setLike(animalEntity.getLike());
                }
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void checkConnection() {
        ConnectivityManager manager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (null != networkInfo) {
            if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                addtab(viewPager);
                tabLayout.setupWithViewPager(viewPager);
                showApiBanner();
                autoSlide();
            } else if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                homeModel.getData(URL_MAMMAL_ANIMALS, "animal");
                homeModel.getData(URL_BIRD_ANIMALS, "animal");
                homeModel.getData(URL_FISH_ANIMALS, "animal");
                homeModel.getData(URL_REPTILE_ANIMALS, "animal");
                addtab(viewPager);
                tabLayout.setupWithViewPager(viewPager);
                showApiBanner();
//                autoSlide();
                startSnapHelper.attachToRecyclerView(rcv_Banner);

            }
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
            builder.setTitle("Phone does not have internet connection");
            builder.setMessage("Do you want turn on internet?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.show();
        }
    }

    public void showApiBanner() {
        homeModel.getData(URL_BANNER_ANIMALS, "banner");
    }

    @Override
    public void getDataApiBanner(ArrayList<Banner> arrayList) {
        bannerArrayList.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            bannerArrayList.add(arrayList.get(i));
        }
        bannerAdapter.notifyDataSetChanged();
    }

    @Override
    public void getDataApiAnimal(ArrayList<AnimalEntity> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            animalArrayList.add(arrayList.get(i));
        }
        Log.d("ddd", String.valueOf(animalArrayList.size()) + "--------" + String.valueOf(arrayList.size()));
    }

    public void autoSlide() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int size = bannerArrayList.size();
                for (int i = 0; i < size; i++) {
                    rcv_Banner.smoothScrollToPosition(i);
                    bannerAdapter.notifyDataSetChanged();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i == size - 1)
                        i = 0;
                    Log.d("www", "ahihi");
                }
            }
        };
        Handler handler = new Handler();
        handler.postDelayed(runnable, 2000);
    }

    @Override
    public void getList(Banner banner) {
        for(int i=0;i<animalArrayList.size();i++){
            if(animalArrayList.get(i).getAnimal_Id()==banner.getIdBanner()){
                Intent intent=new Intent(HomeActivity.this,DetailAnimalActivity.class);
                intent.putExtra("Animal",animalArrayList.get(i));
                startActivityForResult(intent,code_detail);
                break;
            }
        }

    }
}
