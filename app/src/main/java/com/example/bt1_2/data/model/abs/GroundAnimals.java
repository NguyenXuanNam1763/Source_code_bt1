package com.example.bt1_2.data.model.abs;

import com.example.bt1_2.data.model.abs.Animal;

/*
10-02-2020
code by nguyen xuan nam
 */
public abstract class GroundAnimals extends Animal {

    private String animalSource;
    private int maxSpeed;
    private String classify;

    /*
    Constructor class
     */
    public GroundAnimals() {
        super();
    }

    public GroundAnimals(String animalName) {
        super(animalName);
    }

    public GroundAnimals(String animalName, String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs) {
        super(animalName, animalColor, height, width, weight, dangerousLevel, animalAge, numberOfLegs);
    }

    public GroundAnimals(String animalName, String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs, String animalSource, int maxSpeed, String classify) {
        super(animalName, animalColor, height, width, weight, dangerousLevel, animalAge, numberOfLegs);
        this.animalSource = animalSource;
        this.maxSpeed = maxSpeed;
        this.classify = classify;
    }

    public GroundAnimals(String animalColor, int height, int width, int weight, int dangerousLevel, int animalAge, int numberOfLegs, String animalSource, int maxSpeed, String classify) {
        super(animalColor, height, width, weight, dangerousLevel, animalAge, numberOfLegs);
        this.animalSource = animalSource;
        this.maxSpeed = maxSpeed;
        this.classify = classify;
    }

    @Override
    public void setReproduction() {

    }

    public String getAnimalSource() {
        return animalSource;
    }

    public void setAnimalSource(String animalSource) {
        this.animalSource = animalSource;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }
}
