package com.pluralsight.data;

import com.pluralsight.Models.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LeaseDao {
    private final DataManager dataManager;
    private final Scanner scan = new Scanner(System.in);

    public LeaseDao(DataManager dataManager) {
        this.dataManager = dataManager;
    }
}
