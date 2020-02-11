package com.example.bt1_2.data.model.entity;

import com.example.bt1_2.data.model.abs.GroundAnimals;

public class Giraffe extends GroundAnimals {

    public Giraffe() {
        super("Giraffe","striped color",5000,500,5000,0,10,4);
    }

    public Giraffe(String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs, String animalSource, int maxSpeed, String classify) {
        super("Giraffe",animalColor, height, width, weight, dangerousLevel, animalAge, numberOfLegs, animalSource, maxSpeed, classify);
    }

    @Override
    public void setAnimalRun() {

    }

    @Override
    public void setAnimalSound() {

    }

    @Override
    public void setAnimalSleep() {

    }

    @Override
    public void setAnimalEat() {

    }

    @Override
    public void setHuntForm() {

    }
}
