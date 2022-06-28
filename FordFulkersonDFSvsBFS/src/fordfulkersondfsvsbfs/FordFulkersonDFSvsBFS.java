/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fordfulkersondfsvsbfs;

/**
 *
 * @author kimmo
 */
import java.util.Random;

public class FordFulkersonDFSvsBFS {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        
        BFS bfs = new BFS(1000);
        DFS dfs = new DFS(1000);
        Random r = new Random(1337);
        
        for(int i = 0; i < 10000; i++) {
            Integer a = r.nextInt(1000)+1;
            Integer l = r.nextInt(1000)+1;
            Integer p = r.nextInt(1000)+1;
            bfs.lisaaKaari(a, l, p);
            dfs.lisaaKaari(a, l, p);
        }
        
        long t1 = System.nanoTime();
        
        System.out.print("BFS-Ford-Fulkerson Max Flow: ");
        System.out.println(bfs.laske());
        
        long t2 = System.nanoTime();
        
        System.out.print("DFS-Ford-Fulkerson Max Flow: ");
        System.out.println(dfs.laske());
        
        long t3 = System.nanoTime();
        
        long dt1 = (t2-t1) / 1000000;
        long dt2 = (t3-t2) / 1000000;
        
        System.out.println("BFS: "+dt1+" ms");
        System.out.println("DFS: "+dt2+" ms");
        
    }
}
