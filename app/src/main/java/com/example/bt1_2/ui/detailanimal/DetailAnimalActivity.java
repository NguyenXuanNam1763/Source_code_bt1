package com.example.bt1_2.ui.detailanimal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.bt1_2.BaseActivity;
import com.example.bt1_2.R;
import com.example.bt1_2.data.model.entity.AnimalEntity;
import com.example.bt1_2.ui.home.HomeActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailAnimalActivity extends BaseActivity {
    AnimalEntity animalEntity;
    Toolbar toolbar;
    ImageView imgAnimal;
    TextView txtAge;
    TextView txtSize;
    FloatingActionButton fabtn_favorite;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_animal);
        Intent intent=getIntent();
        animalEntity= (AnimalEntity) intent.getSerializableExtra("Animal");
        mapping();
        Log.d("convat",animalEntity.getNameAnimal()+"---------"+animalEntity.getAnimal_Id());
        fabtn_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(animalEntity.getLike()==0){
                    fabtn_favorite.setImageResource(R.drawable.ic_favorite);
                    animalEntity.setLike(1);
                }
                else{
                    fabtn_favorite.setImageResource(R.drawable.ic_dislike);
                    animalEntity.setLike(0);
                }
                Intent it=new Intent(DetailAnimalActivity.this, HomeActivity.class);
                it.putExtra("Animal",animalEntity);
                setResult(RESULT_OK,it);
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void mapping(){
        toolbar=(Toolbar) findViewById(R.id.tb_animal_detail);
        imgAnimal=(ImageView) findViewById(R.id.img_animal_detail);
        txtAge=(TextView) findViewById(R.id.txt_detail_age);
        txtSize=(TextView) findViewById(R.id.txt_detail_size);
        fabtn_favorite=(FloatingActionButton) findViewById(R.id.fab_favotite);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setTitle(animalEntity.getNameAnimal());
        Glide.with(DetailAnimalActivity.this).load(animalEntity.getImg_Url()).into(imgAnimal);
        txtSize.setText(animalEntity.getSizeAnimal());
        txtAge.setText("No data!");
        if(animalEntity.getLike()==0){
            fabtn_favorite.setImageResource(R.drawable.ic_dislike);
        }
        else{
            fabtn_favorite.setImageResource(R.drawable.ic_favorite);
        }
    }
}
