package com.example.bt1_2.data.model.entity;

import com.example.bt1_2.data.model.abs.UnderWaterAnimals;

public class Python extends UnderWaterAnimals {

    public Python() {
        super("Python","Yellow",1000,10,100000,4,3,0);
    }

    public Python(String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs, int maxDivingTime, int maxAnimalLenght, int depthOfSurvival) {
        super("Python",animalColor, height, width, weight, dangerousLevel, animalAge, numberOfLegs, maxDivingTime, maxAnimalLenght, depthOfSurvival);
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
