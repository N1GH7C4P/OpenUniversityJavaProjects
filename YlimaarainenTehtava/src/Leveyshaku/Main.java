/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leveyshaku;

/**
 *
 * @author kimmo
 */
import java.util.*;

public class Main {
    
    static double keskiarvo(List <Double> lista) {
        Double summa = 0.0;
        if(!lista.isEmpty()) {
          for (Double a : lista) {
              summa += a;
          }
          return summa / lista.size();
        }
        return summa;
    }
    
    public static void main(String[] args) {
        ArrayList<Double> ajat = new ArrayList();
        ArrayList<Double> polkujenPituudet = new ArrayList();
        
        Random r = new Random(715517);
        Leveyshaku lh = new Leveyshaku(10000);
        for(int i = 0; i < 50000; i++) {
            int a = r.nextInt(10000);
            int b = r.nextInt(10000);
            lh.verkko.lisaaKaari(a, b);
        }
        for(int i = 0; i < 10000; i++) {
            int alku = 0; 
            int loppu = i;
            
            double[] palautukset = lh.bfs(lh.verkko, alku, loppu, lh.vanhempi);
            if(palautukset[0] == 1.0) {
                ajat.add(palautukset[1]);
                polkujenPituudet.add(palautukset[2]);
            }
        }
        System.out.println("Aikojen keskiarvo: "+keskiarvo(ajat));
        System.out.println("Polkujen pituuksien keskiarvo: "+keskiarvo(polkujenPituudet));
    }
}
