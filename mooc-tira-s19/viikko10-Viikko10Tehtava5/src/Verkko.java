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
    
    private Solmu[][] verkko;
    private Solmu alku;
    private Solmu loppu;
    
    public Verkko(char[][] laby) {
        
        this.verkko = new Solmu[laby.length][laby[0].length];
        System.out.println(laby.length);
        System.out.println(verkko.length);
        System.out.println(laby[0].length);
        System.out.println(verkko[0].length);
        
        for(int i = 0; i < verkko.length; i++) {
            for(int j = 0; j < verkko[0].length; j++) {
                if(laby[i][j] == 'x') {
                    alku = new Solmu(laby[i][j],i,j);
                }
                else if(laby[i][j] == 'y') {
                    loppu = new Solmu(laby[i][j],i,j);
                }
                verkko[i][j] = new Solmu(laby[i][j],i,j);
                System.out.print(verkko[i][j].getMerkki());
            }
            System.out.println("");
        }
    }
    public int getLeveys() {
        return this.verkko.length;
    }
    public int getKorkeus() {
        return this.verkko[0].length;
    }
    public Solmu getAlku() {
        return this.alku;
    }
    public Solmu getLoppu() {
        return this.loppu;
    }
    public Solmu getSolmu(int x, int y) {
        return this.verkko[x][y];
    }
    public void setSolmu(int x, int y, Solmu a) {
        this.verkko[x][y] = a;
    }
    public void tulostaVerkko() {
        for(int i = 0; i < this.verkko.length; i++) {
            for(int j = 0; j < this.verkko[0].length; j++) {
                System.out.print(this.getSolmu(i, j).getMerkki());
            }
            System.out.println();
        }
    }
}
