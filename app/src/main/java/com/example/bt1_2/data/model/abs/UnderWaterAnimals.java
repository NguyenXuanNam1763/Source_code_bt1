package com.example.bt1_2.data.model.abs;

import com.example.bt1_2.data.model.abs.Animal;

public abstract class UnderWaterAnimals extends Animal {
    private int maxDivingTime;
    private int maxAnimalLenght;
    private int depthOfSurvival;

    public UnderWaterAnimals() {

    }

    public UnderWaterAnimals(String animalName) {
        super(animalName);
    }

    public UnderWaterAnimals(String animalName, String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs) {
        super(animalName, animalColor, height, width, weight, dangerousLevel, animalAge, numberOfLegs);
    }

    public UnderWaterAnimals(String animalName, String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs, int maxDivingTime, int maxAnimalLenght, int depthOfSurvival) {
        super(animalName, animalColor, height, width, weight, dangerousLevel, animalAge, numberOfLegs);
        this.maxDivingTime = maxDivingTime;
        this.maxAnimalLenght = maxAnimalLenght;
        this.depthOfSurvival = depthOfSurvival;
    }

    public UnderWaterAnimals(String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs, int maxDivingTime, int maxAnimalLenght, int depthOfSurvival) {
        super(animalColor, height, width, weight, dangerousLevel, animalAge, numberOfLegs);
        this.maxDivingTime = maxDivingTime;
        this.maxAnimalLenght = maxAnimalLenght;
        this.depthOfSurvival = depthOfSurvival;
    }

    public int getMaxDivingTime() {
        return maxDivingTime;
    }

    public void setMaxDivingTime(int maxDivingTime) {
        this.maxDivingTime = maxDivingTime;
    }

    public int getMaxAnimalLenght() {
        return maxAnimalLenght;
    }

    public void setMaxAnimalLenght(int maxAnimalLenght) {
        this.maxAnimalLenght = maxAnimalLenght;
    }

    public int getDepthOfSurvival() {
        return depthOfSurvival;
    }

    public void setDepthOfSurvival(int depthOfSurvival) {
        this.depthOfSurvival = depthOfSurvival;
    }
}
