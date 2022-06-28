import java.util.*;

public class Nopanheitto {  
    
    private int permutations = 0;   
    
    public long laske(int n) {
        long[] noppa = laskeAlkeistapaukset();
        
        if (n < 7) {
            System.out.println(noppa[n-1]);
            return noppa[n-1];
        }
        for(int i = 6; i <= n; i++) {
            noppa[i] = noppa[i-1] + noppa[i-2] + noppa[i-3] + noppa[i-4] + noppa[i-5] + noppa[i-6];
        } 
        System.out.println(noppa[n-1]);
        return noppa[n-1];
    }

    public int kombinoi(int soFar, int summa) {
        if(summa == 0) {
            permutations++;
        }
        else {
            kombinoi(soFar += 1, summa - 1);
            
            if(summa - 2 >= 0) {
                kombinoi(soFar += 2, summa - 2);
            }
            if(summa - 3 >= 0) {
                kombinoi(soFar += 3, summa - 3);
            }
            if(summa - 4 >= 0) {
                kombinoi(soFar += 4, summa - 4);
            }
            if(summa - 5 >= 0) {
                kombinoi(soFar += 5, summa - 5);
            }
            if(summa - 6 >= 0) {
                kombinoi(soFar += 6, summa - 6);
            }
        }
        return permutations;
    }
    public long[] laskeAlkeistapaukset() {
        
        long[] noppa = new long[51];
        
        for(int i = 0; i < 6; i++) {
            noppa[i] = kombinoi(0,i);
        }
        return noppa;
    }
}