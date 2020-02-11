package com.example.bt1_2.data.model.abs;
/*
10-02-2020
code by nguyen xuan nam
 */
public abstract class Animal {
    /*
    property class
     */
    private String animalName;
    private String animalColor;
    private int height;
    private int width;
    private int weight;
    private int dangerousLevel;
    private int animalAge;
    private int numberOfLegs;

    /*
    abstract function
     */
    public abstract void setAnimalRun();
    public abstract void setAnimalSound();
    public abstract void setAnimalSleep();
    public abstract void setAnimalEat();
    public abstract void setHuntForm();
    public abstract void setReproduction();

    /*
    constructor class
     */

    public Animal() {
    }

    public Animal(String animalName) {
        this.animalName = animalName;
    }

    public Animal(String animalName, String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs) {
        this.animalName = animalName;
        this.animalColor = animalColor;
        this.height = height;
        this.width = width;
        this.weight = weight;
        this.dangerousLevel = dangerousLevel;
        this.animalAge = animalAge;
        this.numberOfLegs = numberOfLegs;
    }

    public Animal(String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs) {
        this.animalColor = animalColor;
        this.height = height;
        this.width = width;
        this.weight = weight;
        this.dangerousLevel = dangerousLevel;
        this.animalAge = animalAge;
        this.numberOfLegs = numberOfLegs;
    }

    public String getAnimalName() {
        return animalName;
    }

    private void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalColor() {
        return animalColor;
    }

    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDangerousLevel() {
        return dangerousLevel;
    }

    public void setDangerousLevel(int dangerousLevel) {
        this.dangerousLevel = dangerousLevel;
    }

    public int getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }
}
