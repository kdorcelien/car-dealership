package com.pluralsight.data;

import com.pluralsight.Models.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {

    private final DataManager dataManager;

    public VehicleDao(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public List<Vehicle> searchByPriceRange(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM  vehicles" +
                "  WHERE price BETWEEN ? AND ? ";

        try {
            Connection connection = dataManager.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setInt(1, min);
                statement.setInt(2, max);

                try (ResultSet results = statement.executeQuery()) {
                    while (results.next()) {
                        int vin = results.getInt("VIN");
                        String make = results.getString("MAKE");
                        String model = results.getString("MODEL");
                        String color = results.getString("color");
                        double price = results.getDouble("price");
                        int year = results.getInt("year");
                        String vehicleType = results.getString("vehicle_type");
                        int mileage = results.getInt("mileage");

                        vehicles.add(new Vehicle(vin, make, model, color, price, year, vehicleType, mileage));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting Vehicles for price range: " + e.getMessage());
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM  vehicles" +
                " WHERE MAKE LIKE ? AND MODEL LIKE ? ";


        try {
            Connection connection = dataManager.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setString(1, make);
                statement.setString(2, model);

                try (ResultSet results = statement.executeQuery()) {
                    while (results.next()) {
                        int vin = results.getInt("VIN");
                        String makes = results.getString("MAKE");
                        String models = results.getString("MODEL");
                        String color = results.getString("color");
                        double price = results.getDouble("price");
                        int year = results.getInt("year");
                        String vehicleType = results.getString("vehicle_type");
                        int mileage = results.getInt("mileage");

                        vehicles.add(new Vehicle(vin, makes, models, color, price, year, vehicleType, mileage));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting Vehicles for price range: " + e.getMessage());
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByYearRange(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM  vehicles" +
                " WHERE year BETWEEN ? AND ? ";

        try {
            Connection connection = dataManager.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setInt(1, min);
                statement.setInt(2, max);

                try (ResultSet results = statement.executeQuery()) {
                    while (results.next()) {
                        int vin = results.getInt("VIN");
                        String make = results.getString("MAKE");
                        String model = results.getString("MODEL");
                        String color = results.getString("color");
                        double price = results.getDouble("price");
                        int year = results.getInt("year");
                        String vehicleType = results.getString("vehicle_type");
                        int mileage = results.getInt("mileage");

                        vehicles.add(new Vehicle(vin, make, model, color, price, year, vehicleType, mileage));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting Vehicles for price range: " + e.getMessage());
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByColor(String color) {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM  vehicles" +
                " WHERE color LIKE ? ";

        try {
            Connection connection = dataManager.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setString(1, "%" + color + "%");

                try (ResultSet results = statement.executeQuery()) {
                    while (results.next()) {
                        int vin = results.getInt("VIN");
                        String make = results.getString("MAKE");
                        String model = results.getString("MODEL");
                        String colors = results.getString("color");
                        double price = results.getDouble("price");
                        int year = results.getInt("year");
                        String vehicleType = results.getString("vehicle_type");
                        int mileage = results.getInt("mileage");

                        vehicles.add(new Vehicle(vin, make, model, colors, price, year, vehicleType, mileage));
                    }


                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting Vehicles for price range: " + e.getMessage());
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByMileageRange(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM  vehicles" +
                " WHERE mileage BETWEEN ? AND ? ";

        try {
            Connection connection = dataManager.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setInt(1, min);
                statement.setInt(2, max);

                try (ResultSet results = statement.executeQuery()) {
                    while (results.next()) {
                        int vin = results.getInt("VIN");
                        String make = results.getString("MAKE");
                        String model = results.getString("MODEL");
                        String color = results.getString("color");
                        double price = results.getDouble("price");
                        int year = results.getInt("year");
                        String vehicleType = results.getString("vehicle_type");
                        int mileage = results.getInt("mileage");

                        vehicles.add(new Vehicle(vin, make, model, color, price, year, vehicleType, mileage));
                    }


                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting Vehicles for price range: " + e.getMessage());
            e.printStackTrace();
        }
        return vehicles;
    }

    public List<Vehicle> searchByType(String vehicleType) {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM  vehicles" +
                " WHERE vehicle_type LIKE ? ";

        try {
            Connection connection = dataManager.getConnection();

            try (PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setString(1, "%" + vehicleType + "%");

                try (ResultSet results = statement.executeQuery()) {
                    while (results.next()) {
                        int vin = results.getInt("VIN");
                        String make = results.getString("MAKE");
                        String model = results.getString("MODEL");
                        String color = results.getString("color");
                        double price = results.getDouble("price");
                        int year = results.getInt("year");
                        String vehicleTypes = results.getString("vehicle_type");
                        int mileage = results.getInt("mileage");

                        vehicles.add(new Vehicle(vin, make, model, color, price, year, vehicleTypes, mileage));
                    }

                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting Vehicles for price range: " + e.getMessage());
            e.printStackTrace();
        }
        return vehicles;
    }
}
