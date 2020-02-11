package com.example.bt1_2.data.model.abs;

import com.example.bt1_2.data.model.abs.Animal;

public abstract class AerialAnimals extends Animal {
    private int maxBirdWingLenght;
    private int minBirdWingLength;
    private String kindOfFood;
    private int maxFlightTime;
    private int minFlightTime;

    public AerialAnimals() {
    }

    public AerialAnimals(String animalName) {
        super(animalName);
    }

    public AerialAnimals(String animalName, String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs) {
        super(animalName, animalColor, height, width, weight, dangerousLevel, animalAge, numberOfLegs);
    }

    public AerialAnimals(String animalName, String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs, int maxBirdWingLenght, int minBirdWingLength, String kindOfFood, int maxFlightTime, int minFlightTime) {
        super(animalName, animalColor, height, width, weight, dangerousLevel, animalAge, numberOfLegs);
        this.maxBirdWingLenght = maxBirdWingLenght;
        this.minBirdWingLength = minBirdWingLength;
        this.kindOfFood = kindOfFood;
        this.maxFlightTime = maxFlightTime;
        this.minFlightTime = minFlightTime;
    }

    public AerialAnimals(String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs, int maxBirdWingLenght, int minBirdWingLength, String kindOfFood, int maxFlightTime, int minFlightTime) {
        super(animalColor, height, width, weight, dangerousLevel, animalAge, numberOfLegs);
        this.maxBirdWingLenght = maxBirdWingLenght;
        this.minBirdWingLength = minBirdWingLength;
        this.kindOfFood = kindOfFood;
        this.maxFlightTime = maxFlightTime;
        this.minFlightTime = minFlightTime;
    }

    public int getMaxBirdWingLenght() {
        return maxBirdWingLenght;
    }

    public void setMaxBirdWingLenght(int maxBirdWingLenght) {
        this.maxBirdWingLenght = maxBirdWingLenght;
    }

    public int getMinBirdWingLength() {
        return minBirdWingLength;
    }

    public void setMinBirdWingLength(int minBirdWingLength) {
        this.minBirdWingLength = minBirdWingLength;
    }

    public String getKindOfFood() {
        return kindOfFood;
    }

    public void setKindOfFood(String kindOfFood) {
        this.kindOfFood = kindOfFood;
    }

    public int getMaxFlightTime() {
        return maxFlightTime;
    }

    public void setMaxFlightTime(int maxFlightTime) {
        this.maxFlightTime = maxFlightTime;
    }

    public int getMinFlightTime() {
        return minFlightTime;
    }

    public void setMinFlightTime(int minFlightTime) {
        this.minFlightTime = minFlightTime;
    }
}
