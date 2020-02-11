package com.example.bt1_2.data.model.entity;

import com.example.bt1_2.data.model.abs.GroundAnimals;

public class Lion extends GroundAnimals {

    public Lion() {
        super("Lion","Orange",1000,500,20000,4,20,4);
    }

    public Lion(String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs, String animalSource, int maxSpeed, String classify) {
        super("Lion",animalColor, height, width, weight, dangerousLevel, animalAge, numberOfLegs, animalSource, maxSpeed, classify);
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
