/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectstartup;

/**
 *
 * @author Administrator
 */
import javax.swing.JOptionPane;
public class Validator {
    public static String getValidVIN(String input){
       
        //loop to make sure input is valid
        while(isValidVIN(input) == false){
        
            input = JOptionPane.showInputDialog(null, "VIN: " + input + " is invalid\n\nPlease reenter a valid VIN");
        }
      
        return input;
    
    }
    
    private static boolean isValidVIN(String input){
        // VIN number must be 17 characters
        if(input.length() != 17){
            return false;
        }
        // VIN number must only contain uppercase letters and digits
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(!Character.isDigit(c) && !Character.isUpperCase(c)){
                return false;
            }
        }
        return true;
    }
}
