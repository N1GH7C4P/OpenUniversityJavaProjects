package dijkstravsbellman;

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
    
    private Solmu alku;
    private Solmu loppu;
    private int pituus;
    
    public Kaari(Solmu alku, Solmu loppu, int pituus) {
        this.alku = alku;
        this.loppu = loppu;
        this.pituus = pituus;
    }
    public int getPituus() {
        return this.pituus;
    }
    public Solmu getAlku() {
        return this.alku;
    }
    public Solmu getLoppu() {
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
    public String toString() {
        String a = "";
        String b = String.valueOf(this.alku);
        String c = String.valueOf(this.loppu);
        String d = String.valueOf(this.pituus);
        a += "alku: "+this.alku.getId();
        a += " loppu: "+this.loppu.getId();
        a += " pituus: "+this.pituus+"\n";
        return a;
    }
}
