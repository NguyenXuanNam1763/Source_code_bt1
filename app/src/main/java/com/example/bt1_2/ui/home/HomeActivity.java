package com.example.bt1_2.ui.home;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.viewpager.widget.ViewPager;

import com.example.bt1_2.BaseActivity;
import com.example.bt1_2.R;
import com.example.bt1_2.data.model.entity.Snake;
import com.example.bt1_2.ui.home.Fragment.AerialAnimalFragment;
import com.example.bt1_2.ui.home.Fragment.FavoriteAnimalFragment;
import com.example.bt1_2.ui.home.Fragment.GroundAnimalFragment;
import com.example.bt1_2.ui.home.Fragment.UnderWarterAnimalFragment;
import com.example.bt1_2.ui.home.adapter.TabLayoutAdapter;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends BaseActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AerialAnimalFragment bird;
    private GroundAnimalFragment manmal;
    private UnderWarterAnimalFragment fish;
    private FavoriteAnimalFragment favoriteAnimalFragment;
    private TabLayoutAdapter tabLayoutAdapter;

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
        bird=new AerialAnimalFragment();
        fish=new UnderWarterAnimalFragment();
        manmal=new GroundAnimalFragment();
        favoriteAnimalFragment=new FavoriteAnimalFragment();
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
}
