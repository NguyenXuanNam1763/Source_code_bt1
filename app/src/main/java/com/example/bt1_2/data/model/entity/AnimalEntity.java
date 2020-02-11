package com.example.bt1_2.data.model.entity;

import com.example.bt1_2.data.model.abs.Animal;

public class AnimalEntity {
    private Animal animal;
    private int image;

    public AnimalEntity(Animal animal, int image) {
        this.animal = animal;
        this.image = image;
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
}
