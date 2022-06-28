/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservations;

import org.springframework.stereotype.Service;

/**
 *
 * @author kimmo
 */
@Service
public class DateTimeOverlapService {
    public boolean IsOverlapped(Reservation r1, Reservation r2) {
        return !r1.getReservationTo().isBefore(r2.getReservationFrom()) && r1.getReservationFrom().isAfter(r2.getReservationTo());
    }
}