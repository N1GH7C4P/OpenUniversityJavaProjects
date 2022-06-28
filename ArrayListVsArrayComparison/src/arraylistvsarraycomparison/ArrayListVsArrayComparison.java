/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylistvsarraycomparison;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author nightcap
 */
public class ArrayListVsArrayComparison {

    /**
     * @param args the command line arguments
     */
    
    static int[] vaihdaArvot(int[] t){
        
        Random rand = new Random();
        int a1 = rand.nextInt(t.length);
        int a2 = rand.nextInt(t.length);
        int b1 = t[a1];
        int b2 = t[a2];
        t[a1] = b2;
        t[a2] = b1;
        
        return t;
    }
    
    static ArrayList<Integer> vaihdaArvot(ArrayList<Integer> t) {
        
        Random rand = new Random();
        int a1 = rand.nextInt(t.size());
        int a2 = rand.nextInt(t.size());
        int b1 = t.get(a1);
        int b2 = t.get(a2);
        t.set(a1, b2);
        t.set(a2, b1);
        
        return t;
    }
    
    
    public static void main(String[] args) {
        Random rand = new Random();
        int arr[] = new int[10000000];
        ArrayList<Integer> lista = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100000000);
            lista.add(rand.nextInt(100000000));
        }

        float t1 = System.nanoTime();
        for(int i = 0; i < 100000; i++){
            arr = vaihdaArvot(arr);
        }
        float t2 = System.nanoTime();
        float dt = (t2-t1) / 1000000000;
        System.out.println(dt);

        float t3 = System.nanoTime();
        for(int i = 0; i < 100000; i++){
            lista = vaihdaArvot(lista);
        }
        float t4 = System.nanoTime();
        float dt2 = (t4-t3) / 1000000000;
        System.out.println(dt2);
    }
    
}
