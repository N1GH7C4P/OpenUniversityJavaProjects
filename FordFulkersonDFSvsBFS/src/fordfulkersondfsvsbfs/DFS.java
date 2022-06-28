package fordfulkersondfsvsbfs;

import java.util.*;

public class DFS {     
    
    private int n;
    private int[][] verkko;
    private int[] tila;
    private ArrayDeque<Integer> polku = new ArrayDeque<>();
    private boolean loytyi;
    private int masksimivirtaus;
    private int pienin;
    
    public DFS(int n) {
        this.n = n;
        this.verkko = new int[n+1][n+1];
        this.tila = new int[n+1];
        this.loytyi = false;
        this.masksimivirtaus = 0;
        this.pienin = 0;
    }
    
    public void lisaaKaari(int a, int b, int p) {
        this.verkko[a][b] += p;
    }
    
    public void syvyyshaku(int s) {
        if (tila[s] == 1) {
            return;
        }
        if (loytyi) {
            return;
        }
        polku.addLast(s);
        if (s == n) {
            loytyi = true;
            this.tila = new int[this.n+1];
            return;
        }
        tila[s] = 1;
        for (int i = 1; i < this.n+1; i++) {
            if (this.verkko[s][i] > 0) {
                syvyyshaku(i);
            }
        }
        if (loytyi) {
            return;
        }
        polku.removeLast();
    }
    public int laske() {
        this.maksimivirtaus();
        return this.masksimivirtaus;
    }
    
    public void maksimivirtaus() {
        
        this.loytyi = false;
        this.polku = new ArrayDeque<>();

        syvyyshaku(1);
        if (this.loytyi) {
            this.pienin = Integer.MAX_VALUE;
            int edellinen = Integer.MIN_VALUE;
            
            for (Integer nykyinen : polku) {
                if (edellinen != Integer.MIN_VALUE) {
                    this.pienin = Math.min(this.pienin,verkko[edellinen][nykyinen]);
                }
                edellinen = nykyinen;
            }
            if(this.pienin < 1) {
                return;
            }
            else {
                this.masksimivirtaus += this.pienin;
            }
            edellinen = 0;
            for (Integer nykyinen : polku) {
                if (edellinen != 0) {
                    this.verkko[edellinen][nykyinen] -= this.pienin;
                    this.verkko[nykyinen][edellinen] += this.pienin;
                }
                edellinen = nykyinen;
            }
            maksimivirtaus();
        }
    }
}
