/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstravsbellman;

import java.util.ArrayList;

/**
 *
 * @author kimmo
 */
public class BellmanFord {
    
    private boolean muutos;
    private ArrayList<Solmu> solmut;
    private int[] etaisyydet;
    
    public BellmanFord(int n) {
        this.solmut = new ArrayList();
        this.etaisyydet = new int[n];
        for(int i = 0; i < n; i++) {
            this.solmut.add(new Solmu(i));
            this.etaisyydet[i] = 999999;
        }
    }
    
    public ArrayList<Solmu> getSolmut() {
        return this.solmut;
    }
   
    public void lisaaKaari(Solmu alku, Solmu loppu, int pituus) {
        Kaari k = new Kaari(alku, loppu, pituus);
        Kaari k2 = new Kaari(loppu, alku, pituus);
        this.solmut.get(alku.getId()).lisaaKaari(loppu, pituus);
        this.solmut.get(loppu.getId()).lisaaKaari(alku, pituus);
    }
    
    public int laske(int y) {
        this.etaisyydet[1] = 0;
        while(true) {
            this.muutos = false;
            for(int i = 0; i < this.solmut.size(); i++) {
                //System.out.println("solmu: "+this.solmut.get(i).getId());
                for(Kaari k : this.getSolmut().get(i).getKaaret()) {
                    //System.out.println("kaari: "+k.getAlku().getId()+" "+k.getLoppu().getId());
                    int nyky = etaisyydet[k.getLoppu().getId()];
                    int uusi = etaisyydet[k.getAlku().getId()]+k.getPituus();
                    if(uusi < nyky) {
                        this.etaisyydet[k.getLoppu().getId()] = uusi;
                        this.muutos = true;
                    }
                }
            }
            if (!this.muutos) {
                break;
            }
        }
        
        return this.etaisyydet[y];
    }
}
