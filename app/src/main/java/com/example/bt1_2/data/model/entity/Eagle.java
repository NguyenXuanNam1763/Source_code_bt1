package com.example.bt1_2.data.model.entity;

import com.example.bt1_2.data.model.abs.AerialAnimals;

public class Eagle extends AerialAnimals {

    public Eagle() {
        super("Eagle","Black",1000,800,5000,1,10,2);
    }

    public Eagle(String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs, int maxBirdWingLenght, int minBirdWingLength, String kindOfFood, int maxFlightTime, int minFlightTime) {
        super("Eagle",animalColor, height, width, weight, dangerousLevel, animalAge, numberOfLegs, maxBirdWingLenght, minBirdWingLength, kindOfFood, maxFlightTime, minFlightTime);
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

    @Override
    public void setReproduction() {

    }
}
