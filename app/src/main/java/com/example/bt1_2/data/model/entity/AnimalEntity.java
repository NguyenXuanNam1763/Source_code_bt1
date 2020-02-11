package com.example.bt1_2.data.model.entity;

import com.example.bt1_2.data.model.abs.Animal;

import java.io.Serializable;

public class AnimalEntity implements Serializable {
    private Animal animal;
    private int image;
    private int classify;

    public AnimalEntity(Animal animal, int image,int classify) {
        this.animal = animal;
        this.image = image;
        this.classify=classify;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getClassify() {
        return classify;
    }

    public void setClassify(int classify) {
        this.classify = classify;
    }
}
