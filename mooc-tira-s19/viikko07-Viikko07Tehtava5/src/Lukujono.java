import java.util.*;

public class Lukujono {
    
    long laske(int n) {
        
        int m = n*20;
        
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return 3;
        }
        
        int x = 0;
        TreeSet<Integer> ts = new TreeSet();
        int i = 2;
        
        while(i < m) {
            ts.add(i);
            i = (int) Math.pow(i,2);
            System.out.println(i);
        }
        
        i = 3;
        while(i < m) {
            ts.add(i);
            i = (int) Math.pow(i,3);
            
        }
        
        i = 5;
        while(i < m) {
            ts.add(i);
            i = (int) Math.pow(i,5);
        }
        
        for(int j = 0; j < n; j++) {
            x = ts.pollFirst();
            System.out.println(x);
        }
        return x;
    }
}
