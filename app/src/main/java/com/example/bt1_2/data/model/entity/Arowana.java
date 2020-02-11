package com.example.bt1_2.data.model.entity;

import com.example.bt1_2.data.model.abs.UnderWaterAnimals;

public class Arowana extends UnderWaterAnimals {

    public Arowana() {
        super("Arowana","Orange",20,10,500,0,1,0);
    }

    public Arowana(String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs, int maxDivingTime, int maxAnimalLenght, int depthOfSurvival) {
        super("Arowana",animalColor, height, width, weight, dangerousLevel, animalAge, numberOfLegs, maxDivingTime, maxAnimalLenght, depthOfSurvival);
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
