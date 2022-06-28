/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kimmo
 */
import java.util.*;

public class Solmu {
    
    private ArrayList<Kaari> kaaret;
    private int id;
    private Boolean kasitelty;
    
    public Solmu(int id) {
        this.kasitelty = false;
        this.id = id;
        this.kaaret = new ArrayList();
    }
    public void lisaaKaari(Solmu kohde, int pituus) {
        Kaari a = new Kaari(this.getId(),kohde.getId(),pituus);
        this.kaaret.add(a);
    }
    public ArrayList<Kaari> getKaaret() {
        return this.kaaret;
    }
    public int getId() {
        return this.id;
    }
}
