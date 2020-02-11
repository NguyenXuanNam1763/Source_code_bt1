package com.example.bt1_2;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bt1_2.data.model.abs.Animal;
import com.example.bt1_2.data.model.entity.AnimalEntity;
import com.example.bt1_2.data.model.entity.Arowana;
import com.example.bt1_2.data.model.entity.Carp;
import com.example.bt1_2.data.model.entity.Eagle;
import com.example.bt1_2.data.model.entity.Giraffe;
import com.example.bt1_2.data.model.entity.Lion;
import com.example.bt1_2.data.model.entity.Monkey;
import com.example.bt1_2.data.model.entity.Parrots;
import com.example.bt1_2.data.model.entity.Python;
import com.example.bt1_2.data.model.entity.Snake;
import com.example.bt1_2.data.model.entity.Tiger;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity {
    private ArrayList<AnimalEntity> animalArrayList=new ArrayList<>();
    private ArrayList<AnimalEntity> favoriteAnimalList=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initArrayListAnimal();
    }
    public void initArrayListAnimal(){
        animalArrayList.add(new AnimalEntity(new Snake(),R.drawable.img_snake));
        animalArrayList.add(new AnimalEntity(new Parrots(),R.drawable.img_parrots));
        animalArrayList.add(new AnimalEntity(new Tiger(),R.drawable.img_tiger));
        animalArrayList.add(new AnimalEntity(new Lion(),R.drawable.img_lion));
        animalArrayList.add(new AnimalEntity(new Carp(),R.drawable.img_carp));
        animalArrayList.add(new AnimalEntity(new Arowana(),R.drawable.img_arowana));
        animalArrayList.add(new AnimalEntity(new Monkey(),R.drawable.img_monkey));
        animalArrayList.add(new AnimalEntity(new Giraffe(),R.drawable.img_giraffe));
        animalArrayList.add(new AnimalEntity(new Python(),R.drawable.img_python));
        animalArrayList.add(new AnimalEntity(new Eagle(),R.drawable.img_eagle));

    }
}
