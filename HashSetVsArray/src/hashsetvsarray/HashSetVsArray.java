/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hashsetvsarray;
import java.util.*;

/**
 *
 * @author nightcap
 */
public class HashSetVsArray {

    int[] t = new int[10000000];
    Random rand = new Random();
    int i = 0;
    HashSet hs = new HashSet();
    
    void alusta() {
        for(i = 0; i < t.length; i++) {
            boolean b = rand.nextBoolean();
            if(b) {
                int a = rand.nextInt(10000000);
                t[i]++;
                hs.add(a);
            }
        }
    }
    
    int laskeTaulukonArvot() {
        int arvot = 0;
        for(int i = 0; i < t.length; i++) {
            if(t[i] != 0) {
                arvot++;
            }
        }
        return arvot;
    }
    
    int laskeHashSetinArvot() {
        return hs.size();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HashSetVsArray a = new HashSetVsArray();
        a.alusta();
        
        float t1 = System.nanoTime();
        int taulukonArvot = a.laskeTaulukonArvot();
        float t2 = System.nanoTime();
        
        float dt = (t2-t1) / 1000000000;
        System.out.println("Taulukon arvot: "+taulukonArvot);
        System.out.println("aikaa kului:"+ dt);

        float t3 = System.nanoTime();
        int hsArvot = a.laskeHashSetinArvot();
        float t4 = System.nanoTime();
        float dt2 = (t4-t3) / 1000000000;
        System.out.println("HashSetin arvot: "+hsArvot);
        System.out.println("aikaa kului: " +dt2);
    }
    
}
