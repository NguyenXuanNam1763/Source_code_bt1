package com.example.bt1_2.data.model.entity;

import com.example.bt1_2.data.model.abs.Animal;

import java.io.Serializable;

public class AnimalEntity implements Serializable {
    private int animal_Id;
    private int species;
    private String nameAnimal;
    private String sizeAnimal;
    private String img_Url;

    public AnimalEntity(int animal_Id, int species, String nameAnimal, String sizeAnimal, String img_Url) {
        this.animal_Id = animal_Id;
        this.species = species;
        this.nameAnimal = nameAnimal;
        this.sizeAnimal = sizeAnimal;
        this.img_Url = img_Url;
    }

    public int getAnimal_Id() {
        return animal_Id;
    }

    public void setAnimal_Id(int animal_Id) {
        this.animal_Id = animal_Id;
    }

    public int getSpecies() {
        return species;
    }

    public void setSpecies(int species) {
        this.species = species;
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    public String getSizeAnimal() {
        return sizeAnimal;
    }

    public void setSizeAnimal(String sizeAnimal) {
        this.sizeAnimal = sizeAnimal;
    }

    public String getImg_Url() {
        return img_Url;
    }

    public void setImg_Url(String img_Url) {
        this.img_Url = img_Url;
    }
}
