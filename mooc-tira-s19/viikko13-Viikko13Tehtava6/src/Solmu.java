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
    
    private int koko;
    private int id;
    private PriorityQueue<Pair<Integer,Integer>> vanhemmat;
    private int vanhempi;
    
    public Solmu(int id) {
        this.koko = 1;
        this.id = id;
        this.vanhemmat = new PriorityQueue();
        this.vanhempi = id;
    }
    public int getId() {
        return this.id;
    }
    public void paivataVanhempi(int id, int paiva) {
        this.vanhempi = id;
        this.vanhemmat.add(new Pair(id,paiva));
    } 
    public int getVanhempi() {
        return this.vanhempi;
    }
    public PriorityQueue<Pair<Integer,Integer>> getVanhemmat() {
        PriorityQueue<Pair<Integer,Integer>> vanhemmatKopio = this.vanhemmat;
        return vanhemmatKopio;
    }
    
    public void setKoko(int i) {
        this.koko = i;
    }
    public int getKoko() {
        return this.koko;
    }
}
