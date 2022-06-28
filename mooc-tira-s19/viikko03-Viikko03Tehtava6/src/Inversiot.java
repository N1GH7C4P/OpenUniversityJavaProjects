import java.util.*;

public class Inversiot {
    int[] muodosta(int n, long k) {
        
        int[] t = new int[n]; 
                
        for(int i = 0; i < n; i++) {
            t[i] = i+1;
        }
        
        int kierros = 0;
        for(int j = 0; j < k; j++) {
            int a = t[j];
            int b = t[j+1];
            t[j] = b;
            t[j+1] = a;
            if(j > n-kierros) {
                j = 0;
                kierros++;
            }
        }
        return t;
    }
}
