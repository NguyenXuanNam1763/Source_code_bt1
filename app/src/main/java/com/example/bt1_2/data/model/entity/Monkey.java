package com.example.bt1_2.data.model.entity;

import com.example.bt1_2.data.model.abs.GroundAnimals;

public class Monkey extends GroundAnimals {

    public Monkey() {
        super("Monkey","Orange",1500,500,50000,3,40,4);
    }

    public Monkey(String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs, String animalSource, int maxSpeed, String classify) {
        super("Monkey",animalColor, height, width, weight, dangerousLevel, animalAge, numberOfLegs, animalSource, maxSpeed, classify);
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
