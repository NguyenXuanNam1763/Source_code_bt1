package com.example.bt1_2.ui.home;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.bt1_2.data.model.entity.AnimalEntity;
import com.example.bt1_2.data.model.entity.Banner;
import com.example.bt1_2.ui.home.Interface.HomePresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeModel {
    private HomePresenter homePresenter;
    private RequestQueue requestQueue;

    private ArrayList<Banner> bannerArrayList;
    private ArrayList<AnimalEntity> animalEntityArrayList;
    public HomeModel(HomePresenter homePresenter, RequestQueue requestQueue) {
        this.homePresenter = homePresenter;
        this.requestQueue=requestQueue;
    }
    public void getData(String url, final String species){
        final JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(species.equals("banner")){
                    bannerArrayList=new ArrayList<>();
                    int size=response.length();
                    for(int i=0;i<=size;i++){
                        try {
                            JSONObject jsonObject=response.getJSONObject(i);
                            int id=Integer.parseInt(jsonObject.getString("animal_id"));
                            String img_Url=jsonObject.getString("banner");
                            bannerArrayList.add(new Banner(id,img_Url));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    homePresenter.getDataApiBanner(bannerArrayList);
                }
                if(species.equals("animal")){
                    animalEntityArrayList=new ArrayList<>();
                    int size=response.length();
                    for(int i=0;i<=size;i++){
                        try {
                            JSONObject jsonObject=response.getJSONObject(i);
                            int id=jsonObject.getInt("animal_id");
                            int species=jsonObject.getInt("species");
                            String name=jsonObject.getString("name");
                            String sizeAnimal=jsonObject.getString("size");
                            String img_url=jsonObject.getString("img_url");
                            animalEntityArrayList.add(new AnimalEntity(id,species,name,sizeAnimal,img_url));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    homePresenter.getDataApiAnimal(animalEntityArrayList);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

}
