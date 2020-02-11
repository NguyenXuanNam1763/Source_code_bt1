package com.example.bt1_2.data.model.entity;

import com.example.bt1_2.data.model.abs.GroundAnimals;

public class Tiger extends GroundAnimals {

    public Tiger() {
        super("Tiger","Yellow",1000,500,10000,4,10,4);
    }

    public Tiger(String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs, String animalSource, int maxSpeed, String classify) {
        super("Tiger",animalColor, height, width, weight, dangerousLevel, animalAge, numberOfLegs, animalSource, maxSpeed, classify);
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
