/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nightcap
 */
public class Tehtava implements Comparable<Tehtava> {
    
    private String nimi;
    private int kiireellisyys;
    
    public Tehtava(String nimi, int kiireellisyys) {
        this.nimi = nimi;
        this.kiireellisyys = kiireellisyys;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    @Override
    public int compareTo(Tehtava a) {
        if(this.kiireellisyys != a.kiireellisyys) {
            return a.kiireellisyys - this.kiireellisyys;
        }else if(this.nimi != a.nimi) {
            return -1*(a.nimi.compareTo(this.nimi));
        }  
        return 0;
    }
}
