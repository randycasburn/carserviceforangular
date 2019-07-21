package com.fidelity.carserviceforangular.model;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private String model;
    private String make;
    private int year;
    private int doors;
    private double price;

    public Car() {
    }

    public Car(String model, String make, int year, int doors, double price) {
        super();
        this.model = model;
        this.make = make;
        this.year = year;
        this.doors = doors;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public int getDoors() {
        return doors;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car [model=" + model + ", make=" + make + ", year=" + year + ", doors=" + doors + ", price=" + price
                + "]";
    }

}
