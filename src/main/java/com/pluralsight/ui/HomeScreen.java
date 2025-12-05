package com.pluralsight.ui;

import com.pluralsight.Models.Vehicle;
import com.pluralsight.data.VehicleDao;
import com.pluralsight.util.ConsoleColors;
import com.pluralsight.util.InputValidator;

import java.util.List;

public class HomeScreen {
private  final VehicleDao vehicleDao;

    public HomeScreen(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    public void display() {
        boolean running = true;

        while (running) {
            InputValidator.clearScreen();
            displayMenu();

            int choice = InputValidator.getIntInRange("Select an option: ", 0, 6);

            switch (choice) {
                case 1:
                    showByPriceRange();
                    break;
                case 2:
                    showByByMakeModel();
                    break;
                case 3:
                    showByYearRange();
                    break;
                case 4:
                    showByColor();
                    break;
                case 5:
                    showByMileageRange();
                    break;
                case 6:
                    showByType();
                    break;
                case 0:
                    running = false;
                    break;
            }
        }
    }

    private void displayMenu() {
        ConsoleColors.printHeader("SEARCH SCREEN");

        System.out.println("\nHOW WOULD YOU LIKE TO SEARCH YOUR VEHICLE:");
        System.out.println("1. By price range");
        System.out.println("2. By make/model");
        System.out.println("3. By year range");
        System.out.println("4. By color");
        System.out.println("5. By mileage range");
        System.out.println("6. By type");

        System.out.println("\n0. Back to main menu");
        System.out.println();
    }
    public void showByPriceRange(){
        InputValidator.clearScreen();
        ConsoleColors.printHeader("by Price Range");

        int min = InputValidator.getInt("Enter minimum price: ");
        int max = InputValidator.getInt("Enter maximum price: ");
        List<Vehicle> vehicles = vehicleDao.searchByPriceRange(min, max);
        printResults(vehicles);
    }

    public void showByByMakeModel(){
        InputValidator.clearScreen();
        ConsoleColors.printHeader("by Make and Model");

        String make = InputValidator.getString("Enter make: ");
        String model = InputValidator.getString("Enter model: ");
        List<Vehicle> vehicles = vehicleDao.searchByMakeModel("%" + make + "%", "%" + model + "%");
        printResults(vehicles);
    }

    public void showByYearRange(){
        InputValidator.clearScreen();
        ConsoleColors.printHeader("by Year Range");

        int min = InputValidator.getInt("Enter minimum year: ");
        int max = InputValidator.getInt("Enter maximum year: ");
        List<Vehicle> vehicles = vehicleDao.searchByYearRange(min, max);
        printResults(vehicles);
    }

    public void showByColor(){
        InputValidator.clearScreen();
        ConsoleColors.printHeader("by Color");

        String color = InputValidator.getString("Enter color: ");
        List<Vehicle> vehicles = vehicleDao.searchByColor(color);
        printResults(vehicles);
    }

    public void showByMileageRange(){
        InputValidator.clearScreen();
        ConsoleColors.printHeader("by Mileage Range");

        int min = InputValidator.getInt("Enter minimum mileage: ");
        int max = InputValidator.getInt("Enter maximum mileage: ");
        List<Vehicle> vehicles = vehicleDao.searchByMileageRange(min, max);
        printResults(vehicles);
    }

    public void showByType(){
        InputValidator.clearScreen();
        ConsoleColors.printHeader("by Type");

        String type = InputValidator.getString("Enter vehicle type: ");
        List<Vehicle> vehicles = vehicleDao.searchByType(type);
        printResults(vehicles);
    }
    private void printResults(List<Vehicle> vehicles) {
        InputValidator.clearScreen();

        if (vehicles.isEmpty()) {
            ConsoleColors.printWarning("No data available for this report.");
        } else {
            System.out.printf("%-8s %-12s %-15s %-10s %-10s %-6s %-12s %-10s%n",
                    "VIN", "MAKE", "MODEL", "COLOR", "PRICE", "YEAR", "TYPE", "MILEAGE");
            System.out.println("-".repeat(100));

            for (Vehicle v : vehicles) {
                System.out.printf("%-8d %-12s %-15s %-10s %-10.2f %-6d %-12s %-10d%n",
                        v.getVin(),
                        v.getMake(),
                        v.getModel(),
                        v.getColor(),
                        v.getPrice(),
                        v.getYear(),
                        v.getVehicleType(),
                        v.getMileage());
            }

            System.out.println();
            InputValidator.pressEnterToContinue();
        }
    }
}

