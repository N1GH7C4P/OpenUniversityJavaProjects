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
    
    private int pituus;
    private int alku;
    private int loppu;
    
    public Kaari(int a, int l, int p) {
        this.alku = a;
        this.loppu = l;
        this.pituus = p;
    }
    public int getAlku() {
        return this.alku;
    }
    public int getLoppu() {
        return this.loppu;
    }
    public int getPituus() {
        return this.pituus;
    }
    @Override
    public int compareTo(Kaari toinen) {
        if(this.pituus > toinen.pituus) {
            return -1;
        }else if(this.pituus < toinen.pituus) {
            return 1;
        }return 0;
    }
    @Override
    public String toString() {
        String a = "alku: "+this.alku;
        a += "\nloppu: "+this.loppu;
        a += "\npituus: "+this.pituus;
        return a;
    }
}
