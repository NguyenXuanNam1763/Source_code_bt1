package com.example.bt1_2.data.model.entity;

import com.example.bt1_2.data.model.abs.UnderWaterAnimals;

public class Snake extends UnderWaterAnimals {

    public Snake() {
        super("Snake","Yellow",1000,10,2000,4,10,0);
    }

    public Snake(String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs, int maxDivingTime, int maxAnimalLenght, int depthOfSurvival) {
        super("Snake",animalColor, height, width, weight, dangerousLevel, animalAge, numberOfLegs, maxDivingTime, maxAnimalLenght, depthOfSurvival);

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
