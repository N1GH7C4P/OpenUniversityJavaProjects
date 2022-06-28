import java.util.ArrayList;

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
    
    private ArrayList<Integer>[] verkko;
    private boolean[] vierailtu;
    
    public Verkko(int n) {
        this.verkko = new ArrayList[n+1];
        this.vierailtu = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            this.verkko[i] = new ArrayList<>();
        }
    }
    public void lisaaYhteys(int a, int b) {
        this.verkko[a].add(b);
        this.verkko[b].add(a);
    }
    public void syvyyshaku(int solmu) {
        if(this.vierailtu[solmu]) {
            return;
        }
        vierailtu[solmu] = true;
        
        for (int naapuri : this.verkko[solmu]) {
            syvyyshaku(naapuri);
        }
    }
    public boolean[] getVierailtu() {
        return this.vierailtu;
    }
}
