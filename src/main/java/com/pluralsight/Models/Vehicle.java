package com.pluralsight.Models;


public class Vehicle {
    private int vin;
    private String make;
    private String model;
    private String color;
    private double price;
    private int year;
    private String vehicleType;
    private int mileage;


    public Vehicle(int vin, String make, String model, String color, double price, int year, String vehicleType, int mileage) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.color = color;
        this.price = price;
        this.year = year;
        this.vehicleType = vehicleType;
        this.mileage = mileage;
    }


    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public int getMileage() {
        return mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin=" + vin +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", vehicleType='" + vehicleType + '\'' +
                ", mileage=" + mileage +
                '}';
    }


}

