/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kimmo
 */
public class Kaari implements Comparable<Kaari>{
    
    private int alku;
    private int loppu;
    private int pituus;
    
    public Kaari(int alku, int loppu, int pituus) {
        this.alku = alku;
        this.loppu = loppu;
        this.pituus = pituus;
    }
    public int getPituus() {
        return this.pituus;
    }
    public int getAlku() {
        return this.alku;
    }
    public int getLoppu() {
        return this.loppu;
    }
    public int compareTo(Kaari toinen) {
        if(this.pituus > toinen.pituus) {
            return -1;
        }else if(this.pituus < toinen.pituus) {
            return 1;
        }
        else return 0;
    }
}
