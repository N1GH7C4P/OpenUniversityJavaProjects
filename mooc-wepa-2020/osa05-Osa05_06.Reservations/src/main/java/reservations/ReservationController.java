package reservations;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {
    
    @Autowired
    DateTimeOverlapService dtos;
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    @PostMapping("/reservations")
    public String addReservation(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reservationFrom,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reservationTo) {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.isAuthenticated()) {
            String name = auth.getName();
            List<Account> accounts = accountRepository.findAll();
            for(Account account : accounts) {
                if(account.getUsername().equals(name)) {
                    
                    List<Reservation> reservations = reservationRepository.findAll();
                    
                    Reservation reservation = new Reservation(account,reservationFrom,reservationTo);
                    for(Reservation r : reservations) {
                        if(dtos.IsOverlapped(r,reservation)) {
                            throw new DateUnavailableException();
                        }
                        reservationRepository.save(reservation);
                    }
                }
            }
        }
        return "redirect:/reservations";
    }
    
    @GetMapping("/reservations")
    public String viewReservations(Model model) {
        model.addAttribute("reservations",reservationRepository.findAll());
        return "reservations";
    }
}
