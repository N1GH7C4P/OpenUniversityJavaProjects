/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservations;

/**
 *
 * @author kimmo
 */
public class DateUnavailableException extends RuntimeException{

    DateUnavailableException() {
        throw new UnsupportedOperationException("Selected time period unavailable.");
    }
}
