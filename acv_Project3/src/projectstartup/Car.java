/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectstartup;

public class Car {
    private String vin;
    private String make;
    private String model;
    private double year;

    public Car(String vin, String make, String year2, double price) {
        this.vin = vin;
        this.make = make;
        this.model = year2;
        this.year = price;
    }

    public Car(String string, String string2, String string3, String string4, String string5) {
    }

    public Car(String make2, String model2, int year2, double price) {
    }

    public String getVin() {
        return this.vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return (int) this.year;
    }

    public void setYear(int i) {
        this.year = i;
    }

    public void setPrice(double parseDouble) {
    }

    public Object getPrice() {
        return null;
    }
}
