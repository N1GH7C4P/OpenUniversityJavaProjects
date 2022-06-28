/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leveyshaku;

import java.util.LinkedList;

/**
 *
 * @author kimmo
 */
public class Leveyshaku {
    
    int n;
    int[] vanhempi;
    Verkko verkko;
    
    
    public Leveyshaku(int n) {
        this.vanhempi = new int[n+1];
        this.verkko = new Verkko(n);  
    }
    
    public void lisaaYhteys(int a, int b) {
        this.verkko.lisaaKaari(a, b);
    }
    
    public double[] bfs(Verkko verkko, int alku, int kohde, int vanhempi[]) {
        double[] palautukset = new double[3];
        double t1 = System.nanoTime();
        boolean[] nahty = new boolean[verkko.getSolut()];
        for (int i = 0; i < verkko.getSolut(); i++)
            nahty[i] = false;
 
        LinkedList<Integer> jono = new LinkedList<Integer>();
 
        jono.add(alku);
        nahty[alku] = true;
        vanhempi[alku] = -1;
 
        while (!jono.isEmpty()) {
            int i = jono.poll();
            for (Integer j : verkko.naapurit(i)) {
                if ((nahty[j] == false) && (verkko.getNaapurit()[i][j] > 0)) {
                    jono.add(j);
                    nahty[j] = true;
                    vanhempi[j] = i;
                }
            }
        }
        
        double t2 = System.nanoTime();
        double dt = (t2-t1)/1000000;
        if(nahty[kohde]) {
            
            int solmu = kohde;
            int laskuri = 0;
            System.out.println("Polku: ");
            while(solmu != alku) {
                laskuri++;
                System.out.print(solmu+", ");
                solmu = vanhempi[solmu];
            }
            
            //Ohjelma palauttaa double-taulukossa kolme asiaa:
            // [0] : Löytyikö polku? 0.0 / 1.0
            // [1] : Polun pituus kuljettuina solmuina
            // [2] : Polun löytämiseen kulunut aika millisekunteina
            
            palautukset[0] = 1.0;
            palautukset[1] = dt;
            palautukset[2] = laskuri;
            System.out.println("Kohdesolmuun päästiin");
            System.out.println("Kuljettiin "+laskuri+" solmun kautta.");
            System.out.println("Aikaa kului: "+dt+" ms");
        } else {
            palautukset[0] = 0.0;
            System.out.println("Kohteeseen ei polkua!");
        }        
        return palautukset;
    }
}
