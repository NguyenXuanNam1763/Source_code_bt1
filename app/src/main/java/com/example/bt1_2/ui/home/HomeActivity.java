package com.example.bt1_2.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.viewpager.widget.ViewPager;

import com.example.bt1_2.BaseActivity;
import com.example.bt1_2.R;
import com.example.bt1_2.data.model.entity.AnimalEntity;
import com.example.bt1_2.data.model.entity.Snake;
import com.example.bt1_2.ui.detailanimal.DetailAnimalActivity;
import com.example.bt1_2.ui.home.Fragment.AerialAnimalFragment;
import com.example.bt1_2.ui.home.Fragment.FavoriteAnimalFragment;
import com.example.bt1_2.ui.home.Fragment.GroundAnimalFragment;
import com.example.bt1_2.ui.home.Fragment.UnderWarterAnimalFragment;
import com.example.bt1_2.ui.home.Interface.CallBackActivity;
import com.example.bt1_2.ui.home.Interface.CallBackFavoriteActivity;
import com.example.bt1_2.ui.home.adapter.TabLayoutAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity implements CallBackActivity, CallBackFavoriteActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AerialAnimalFragment bird;
    private GroundAnimalFragment manmal;
    private UnderWarterAnimalFragment fish;
    private FavoriteAnimalFragment favoriteAnimalFragment;
    private TabLayoutAdapter tabLayoutAdapter;
    private int code_detail=100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mapping();
        addtab(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void mapping(){
        toolbar=(Toolbar) findViewById(R.id.tb_home);
        tabLayout=(TabLayout) findViewById(R.id.tbl_home);
        viewPager=(ViewPager) findViewById(R.id.vpg_home);
        bird=new AerialAnimalFragment(animalArrayList,this);
        fish=new UnderWarterAnimalFragment(animalArrayList,this);
        manmal=new GroundAnimalFragment(animalArrayList,this);
        favoriteAnimalFragment=new FavoriteAnimalFragment(favoriteAnimalList,this);
        setSupportActionBar(toolbar);

    }
    private void addtab(ViewPager viewPager){
        tabLayoutAdapter=new TabLayoutAdapter(getSupportFragmentManager());
        tabLayoutAdapter.add(manmal,"Manmal");
        tabLayoutAdapter.add(bird,"Bird");
        tabLayoutAdapter.add(fish,"Fish");
        tabLayoutAdapter.add(favoriteAnimalFragment,"Favorite Animal");
        viewPager.setAdapter(tabLayoutAdapter);
    }

    @Override
    public void callBackPosition(AnimalEntity animalEntity) {
        Intent intent=new Intent(this, DetailAnimalActivity.class);
        intent.putExtra("Animal",animalEntity);
        startActivityForResult(intent,code_detail);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==code_detail && resultCode==RESULT_OK && data!=null){
            AnimalEntity animalEntity= (AnimalEntity) data.getSerializableExtra("Animal");
            favoriteAnimalList.add(animalEntity);
            Log.d("dolon",String.valueOf(favoriteAnimalList.size()));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void getList(ArrayList<AnimalEntity> entityArrayList) {
        int i=favoriteAnimalList.size()-1;
        while(i>=0){
            for(int j=0;j<entityArrayList.size();j++){
                if(favoriteAnimalList.get(i).getAnimal().getAnimalName().equals(entityArrayList.get(j).getAnimal().getAnimalName())){
                    favoriteAnimalList.remove(i);
                }
            }
            i--;
        }
    }
}
