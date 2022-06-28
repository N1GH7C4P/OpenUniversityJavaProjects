
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kimmo
 */
public class Verkko {
    
    private int paiva;
    private Solmu[] solmut;
    
    public Verkko(int n) {
        this.solmut = new Solmu[n+1];
        for(int i = 1; i < n+1; i++) {
            this.solmut[i] = new Solmu(i);
        }
        this.paiva = 0;
    }
    
    public Solmu getSolmu(int n) {
        return this.solmut[n];
    }
    
    public Solmu etsiHuippu(Solmu a) {
        int id = a.getId();
        if(this.solmut[id].getVanhempi() != id) {
            id = this.solmut[id].getVanhempi();
            etsiHuippu(this.solmut[id]);
        }
        return this.solmut[id];
    }
    
    public Boolean onkoYhteys(Solmu a, Solmu b) {
        if(this.etsiHuippu(a) == this.etsiHuippu(b)) {
            System.out.println("Yhteys "+a+" - "+b+" löytyi.");
            return true;
        }
        System.out.println("Yhteys "+a+" - "+b+" ei löytynyt.");
        return false;
    }
    
    public void yhdista(Solmu a, Solmu b) {
        
        System.out.println("Yhdistetään "+a.getId()+" ja "+b.getId());
        
        this.paiva++;
        
        a = etsiHuippu(a);
        b = etsiHuippu(b);
        
        System.out.println("1. Huippu: "+a.getId());
        System.out.println("2. Huippu: "+b.getId());
        
        if(a==b){
            return;
        }
        
        if(a.getKoko() > b.getKoko()) {
            b.paivataVanhempi(a.getId(), this.paiva);
            int uusiKoko = a.getKoko()+ b.getKoko();
            a.setKoko(uusiKoko);
        }else{
            a.paivataVanhempi(b.getId(), this.paiva);
            int uusiKoko = b.getKoko()+ a.getKoko();
            b.setKoko(uusiKoko);
        }
    }
    public int etsiYhdistysPaiva(Solmu a, Solmu b) {
        System.out.println("Etsitään solmujen "+a.getId()+" ja "+b.getId()+" yhdistys päivä.");
        PriorityQueue<Pair<Integer,Integer>> ap = a.getVanhemmat();
        PriorityQueue<Pair<Integer,Integer>> bp = b.getVanhemmat();
        
        Pair app = new Pair(0,0);
        Pair bpp = new Pair(0,0);
        
        while(!ap.isEmpty() && !bp.isEmpty()) {
            
            if(!ap.isEmpty()) {
                app = ap.poll();
                System.out.println("Solmun "+a+" vanhempi "+app.first+" ");
            }
            if(!bp.isEmpty()) {
                bpp = bp.poll();
            }
            if(app.first == bpp.first) {
                return Math.min((int) app.second,(int) bpp.second);
            }
        }
        return -1;
    }
}
