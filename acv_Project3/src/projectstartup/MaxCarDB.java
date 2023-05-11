/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectstartup;

/**
 *
 * @author hmouissa
 */
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class MaxCarDB {
    
    public static HashMap<String, Car> loadCars(String filePath) {
        HashMap<String, Car> carList = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split each line into its components
                String[] parts = line.split(",");
                String vin = parts[0];
                String make = parts[1];
                String model = parts[2];
                int year = Integer.parseInt(parts[3]);
                double price = Double.parseDouble(parts[4]);
                
                // Create a new Car object and add it to the HashMap
                Car car = new Car(make, model, year, price);
                carList.put(vin, car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return carList;
    }
    
    public static void saveCars(HashMap<String, Car> carList) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(new File("cars.txt")));
            for (Car car : carList.values()) {
                writer.printf("%s,%s,%s,%d,%.2f\n", car.getVin(), car.getMake(), car.getModel(), car.getYear(), car.getPrice());
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Error saving cars: " + e.getMessage());
        }
    }
    
}
