/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kekovssortvsbrure;

/**
 *
 * @author nightcap
 */
import java.util.*;
public class KekoVsSortVsBrure {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        
        int x = 10000;
        PriorityQueue<Integer> k = new PriorityQueue();
        int[] t = new int[1000000];
    
        Random r = new Random();
        for(int i = 0; i < t.length-1; i++) {
            int a = r.nextInt(10000000);
            t[i] = a;
            k.add(a);
        }
        
        int isoinLisatty = 0;
        int pienin = 999999999;
        int[] luvut = new int[x];
        
        float t1 = System.nanoTime();
        
        for(int j = 0; j < x; j++) {
            for(int i = 0; i < t.length; i++) {
                if(t[i] < pienin && t[i] > isoinLisatty) {
                    pienin = t[i];
                }
            }
            isoinLisatty = pienin;
            luvut[j] = isoinLisatty;
            pienin = 999999999;
            
        }
        
        float t2 = System.nanoTime();
        
        //for(int i = 0; i < luvut.length; i++) {
        //    System.out.println(luvut[i]);
        //}
        
        float dt1 = (t2-t1) / 1000000000;
        System.out.println("Brute force - Aikaa kului: "+dt1);
        // TODO code application logic here
        
        int[] luvut2 = new int[x];
        float t3 = System.nanoTime();
        Arrays.sort(t);
        
        for(int i = 0; i < x; i++) {
            luvut2[i] = t[i];
        }
        float t4 = System.nanoTime();
        float dt2 = (t4-t3) / 1000000000;
        System.out.println("Sorttaus - Aikaa kului: "+dt2);
        
        //for(int i = 0; i < luvut.length; i++) {
        //    System.out.println(luvut2[i]);
        //}
        
        
        int[] luvut3 = new int[x];
        
        float t5 = System.nanoTime();
        
        for(int i = 0; i < x; i++) {
            luvut3[i] = k.poll();
        }
        
        float t6 = System.nanoTime();
        
        float dt3 = (t6-t5) / 1000000;
        System.out.println("Keko - Aikaa kului: "+dt3);
    }
}
