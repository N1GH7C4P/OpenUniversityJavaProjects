import java.util.*;

public class Ruudukko {     
    
    private Ruutu[][] ruudukko;
    private int laskuri;
    private int n;
    private int[] vanhempi;
    private int[][] koko;
    private int[][] lattia;
    
    public Ruudukko(int n) {
        
        this.koko = new int[n+1][n+1];
        this.lattia = new int[n+1][n+1];
        this.n = n;
        this.laskuri = 0;
        this.ruudukko = new Ruutu[n+1][n+1];
        this.vanhempi = new int[(n+1)*(n+1)];
        
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                this.laskuri++;
                this.vanhempi[laskuri] = laskuri; 
                this.ruudukko[j][i] = new Ruutu(j,i,laskuri);
                this.koko[j][i] = 1;
            }
        }
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                this.lisaaNaapurit(j,i);
            }
        }
    }
    public void tulostaRuudunNaapurit(int y, int x) {
        System.out.println(this.ruudukko[y][x].getNaapurit());
    }
    public void tulostaRuutu(int y, int x) {
        System.out.println(this.ruudukko[y][x]);
    }
    
    public int etsiHuippu(int a) {
        while(this.vanhempi[a] != a) {
            a = this.vanhempi[a];
        }
        return a;
    }
    
    public void tulostaVanhemmat() {
        laskuri = 0;
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                laskuri++;
                if(this.lattia[j][i] == 1) {
                    System.out.print("["+this.vanhempi[laskuri]+"]");
                }
                else{
                    System.out.print("[ ]");
                }
            }
            System.out.println("");
        }
    }
    
    public void tulostaLattia() {
        laskuri = 0;
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                System.out.print("["+this.lattia[j][i]+"]");
            }
            System.out.println("");
        }
    }
    
    
    public void lisaaNaapurit(int y, int x) {
        if(y > 1) {
            this.ruudukko[y][x].lisaaNaapuri(this.ruudukko[y-1][x]);
        }
        if(y < n) {
            this.ruudukko[y][x].lisaaNaapuri(this.ruudukko[y+1][x]);
        }
        if (x > 1) {
            this.ruudukko[y][x].lisaaNaapuri(this.ruudukko[y][x-1]);
        }
        if (x < n) {
            this.ruudukko[y][x].lisaaNaapuri(this.ruudukko[y][x+1]);
        }   
    }
    
    public void teeLattia(int y, int x) {
        if(this.lattia[y][x] == 1) {
            return;
        }
        
        this.lattia[y][x] = 1;
        int vanhempiA = etsiHuippu(this.ruudukko[y][x].getVanhempi());
        
        for(Ruutu r : this.ruudukko[y][x].getNaapurit()) {
            if(this.lattia[r.getY()][r.getX()] == 1) {
                int vanhempiB = etsiHuippu(r.getVanhempi());
                if(vanhempiA == vanhempiB) {
                    continue;
                }
                int kokoA = koko[y][x];
                int kokoB = koko[r.getY()][r.getX()];
                
                if(kokoA < kokoB) {
                    vanhempi[vanhempiA] = vanhempiB;
                    this.ruudukko[y][x].setVanhempi(vanhempiB);
                    this.koko[r.getY()][r.getX()] += kokoA;
                }
                else{
                    vanhempi[vanhempiB] = vanhempiA;
                    this.ruudukko[r.getY()][r.getX()].setVanhempi(vanhempiA);
                    this.koko[y][x] += kokoB;
                }
            }
        }
    }
    
    public int laskeHuoneet() {
        HashSet<Integer> eriVanhempia = new HashSet();
        laskuri = 0;
        
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < n+1; j++) {
                laskuri++;
                if(this.lattia[j][i] == 1) {
                    eriVanhempia.add(this.vanhempi[laskuri]);
                }
            }
        }
        return eriVanhempia.size();
    }
}
