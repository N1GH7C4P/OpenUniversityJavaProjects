/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloadheroes;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kimmo
 */
@Service
public class ScoreService {
    
    private String[] names = {"Kalle", "Pekka", "Eemeli", "Juuso", "Risto", "Maija", "Kaisa", "Heikki", "Mika", "Riitta", "Emilia", "Katja", "Samuel"};
    
    @Autowired
    private HttpSession session;
    
    @Autowired
    private ReloadStatusRepository reloadStatusRepository;
    
    private ReloadStatus rs;
    private Integer score;
    
    public void incrementScore() {
        
        if(session.getAttribute("status") == null) {
            rs = new ReloadStatus();
            rs.setName(names[(int) reloadStatusRepository.count()]);
            score = 0;
            rs.setReloads(score);
            session.setAttribute("status", rs);
        }
        else {
            rs = (ReloadStatus) session.getAttribute("status");
            score = reloadStatusRepository.getOne(rs.getId()).getReloads();
        }
        rs.setReloads(score+1);
        reloadStatusRepository.save(rs);
    }
    public ReloadStatus getPlayerReloadStatus() {
        return rs;
    }
}