/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exception;

/**
 *
 * @author Patrick
 */
public class CreationFormatException extends Exception {
    
    public CreationFormatException() {
        
    }
    
    public CreationFormatException(String message) {
        super(message);
    }
}
