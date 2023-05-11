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
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Main {


    private static HashMap<String, Car> inventory;

    public static void main(String[] args) {
       //initialize the inventory
       inventory = new HashMap<String, Car>();
       
       
       //Present the customer with a choice of vehicles
		String[]  choices = {"Add Car", "Remove Car", "Update Car", "List Cars", "Clear Cars", "Find Car", "Exit"};

                //keep the menu up unless exiting
                while(true){ 
                    int response = JOptionPane.showOptionDialog(
                                    null                       				// center over parent
                                    , "Database Operations"                             // message
                                    , "MaxCar the Best Car Dealership"        		// title in titlebar
                                    , JOptionPane.YES_NO_OPTION                 	// Option type
                                    , JOptionPane.PLAIN_MESSAGE  			// messageType
                                    , null                       			// icon
                                    , choices                    			// Options
                                    , "Select a MaxCar Operation"                       // initial value
                    );
                    switch (response){

                        case 0:
                            addCar();
                            break;
                        case 1:
                            removeCar();
                            break;                      
                        case 2:
                            updateCar();
                            break;
                        case 3:
                            listCars();
                            break;
                        case 4:
                            clearCars();
                            break;
                        case 5:
                            findCar();
                            break;                            
                        default:
                               exitApplication();

                    }
                }
                
    }
    
    
    private static void addCar() {
        // Ask user for car data
        String vin = JOptionPane.showInputDialog(null, "Enter VIN:");
        String make = JOptionPane.showInputDialog(null, "Enter make:");
        String model = JOptionPane.showInputDialog(null, "Enter model:");
        int year = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter year:"));
        // Create new Car object with user input
        Car newCar = new Car(vin, make, model, year);
    
        // Add Car object to inventory
        inventory.put(vin, newCar);
    
        JOptionPane.showMessageDialog(null, "Car added to inventory: " + newCar.toString());
    }
    
    


    private static void removeCar(){
        //add code to ask user for data entry and remove a car from the hashmap
        String vin = JOptionPane.showInputDialog(null, "Enter VIN of the car to remove:");
        if (inventory.containsKey(vin)) {
            inventory.remove(vin);
            JOptionPane.showMessageDialog(null, "Car removed successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Car not found in the inventory!");
        }
    }
    
    private static void updateCar() {
        // Ask the user for the VIN of the car to update
        String vin = JOptionPane.showInputDialog("Enter VIN of the car to update:");
    
        // Check if the car exists in the inventory
        if (!inventory.containsKey(vin)) {
            JOptionPane.showMessageDialog(null, "Car with VIN " + vin + " does not exist in the inventory!");
            return;
        }
    
        // Retrieve the car object from the inventory
        Car car = inventory.get(vin);
    
        // Ask the user for the updated make
        String make = JOptionPane.showInputDialog("Enter updated make:");
        if (make != null && !make.isEmpty()) {
            car.setMake(make);
        }
    
        // Ask the user for the updated model
        String model = JOptionPane.showInputDialog("Enter updated model:");
        if (model != null && !model.isEmpty()) {
            car.setModel(model);
        }
    
        // Ask the user for the updated year
        String yearString = JOptionPane.showInputDialog("Enter updated year:");
        if (yearString != null && !yearString.isEmpty()) {
            try {
                int year = Integer.parseInt(yearString);
                car.setYear(year);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input format! Please enter a valid integer value for year.");
            }
        }
    
        // Ask the user for the updated price
        String priceString = JOptionPane.showInputDialog("Enter updated price:");
        if (priceString != null && !priceString.isEmpty()) {
            try {
                double price = Double.parseDouble(priceString);
                car.setPrice(price);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input format! Please enter a valid decimal value for price.");
            }
        }
    
        JOptionPane.showMessageDialog(null, "Car with VIN " + vin + " has been updated:\n" + car.toString());
    }
    
    
    private static void listCars() {
        // Check if there are cars in the inventory
        if (inventory.isEmpty()) {
            JOptionPane.showMessageDialog(null, "There are no cars in the inventory!");
            return;
        }
        
        // Create a string to hold the summary data of all the cars in the inventory
        StringBuilder carData = new StringBuilder();
        for (String vin : inventory.keySet()) {
            Car car = inventory.get(vin);
            carData.append("VIN: ").append(vin)
                   .append(", Make: ").append(car.getMake())
                   .append(", Model: ").append(car.getModel())
                   .append(", Year: ").append(car.getYear())
                   .append(", Price: $").append(car.getPrice())
                   .append("\n");
        }
        
        // Display the summary data to the user
        JOptionPane.showMessageDialog(null, carData.toString());
    }
    
    
    private static void clearCars() {
        // Clear the inventory
        inventory.clear();
        
        JOptionPane.showMessageDialog(null, "All cars have been removed from the inventory!");
    }
    
    private static void findCar() {
        // Ask the user for the VIN of the car to find
        String vin = JOptionPane.showInputDialog("Enter VIN of the car to find:");
        
        // Check if the car exists in the inventory
        if (!inventory.containsKey(vin)) {
            JOptionPane.showMessageDialog(null, "Car with VIN " + vin + " does not exist in the inventory!");
            return;
        }
        
        // Retrieve the car object from the inventory
        Car car = inventory.get(vin);
        
        // Display the details of the car to the user
        JOptionPane.showMessageDialog(null, "Car details:\n" +
                "VIN: " + vin + "\n" +
                "Make: " + car.getMake() + "\n" +
                "Model: " + car.getModel() + "\n" +
                "Year: " + car.getYear() + "\n" +
                "Price: $" + car.getPrice());
    }
    
    private static void exitApplication(){
        JOptionPane.showMessageDialog(null, "Thank you for using the MaxCar Application. " + inventory.size() + " cars saved!...EXITING...");
        System.exit(0);
    }
    
}
