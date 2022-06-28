/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstravsbellman;

/**
 *
 * @author kimmo
 */
import java.util.*;

public class DijkstraVsBellman {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        
        Random r = new Random();
        Dijkstra d = new Dijkstra(9999);
        BellmanFord bf = new BellmanFord(9999);
        for(int i = 0; i < 9999; i++) {
            for(int j = 0; j < 10; j++) {
                int a = r.nextInt(9998)+1;
                int b = r.nextInt(9998)+1;
                int c = r.nextInt(1000);
                d.lisaaTie(a, b, r.nextInt(1000));
                bf.lisaaKaari(bf.getSolmut().get(a),bf.getSolmut().get(b), c);
            }
        }
        double t1 = System.nanoTime();
        System.out.println(d.laske(9998));
        double t2 = System.nanoTime();
        double dt1 = (t2-t1)/1000000;
        double t3 = System.nanoTime();
        System.out.println(bf.laske(9998));
        double t4 = System.nanoTime();
        double dt2 = (t4-t3)/1000000;
        
        System.out.println("dijkstralla meni: "+dt1);
        System.out.println("bellman-fordilla meni: "+dt2);
    }
}
