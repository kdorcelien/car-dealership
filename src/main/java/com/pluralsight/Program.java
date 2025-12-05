package com.pluralsight;

import com.pluralsight.config.DatabaseConfig;
import com.pluralsight.data.DataManager;
import com.pluralsight.data.VehicleDao;
import com.pluralsight.ui.HomeScreen;

public class Program {
    public static void main(String[] args) {

            System.out.println("Initializing MangoMusic Database Tool...\n");

            DataManager dataManager = null;

            try {
                dataManager = new DataManager();
                VehicleDao vehicleDao = new VehicleDao(dataManager);


                HomeScreen homeScreen = new HomeScreen(vehicleDao);

                homeScreen.display();

            } catch (Exception e) {
                System.err.println("Fatal error: " + e.getMessage());
                e.printStackTrace();
                System.exit(1);
            } finally {
                if (dataManager != null) {
                    dataManager.close();
                }
                DatabaseConfig.closeDataSource();
            }
        }

}