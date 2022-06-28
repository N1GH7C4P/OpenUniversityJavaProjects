import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        //long t1 = System.nanoTime();
        
        Lista l = new Lista();
        long summa = 0;
        int n = 1000000;
        int[] t1 = new int[n];
        int [] t2 = new int[n];
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) {
            t1[i] = r.nextInt(1000000000)+1;
            if (i != 0) t2[i] = r.nextInt(i);
        }
        for (int i = 1; i <= 500000; i++) {
            if (i%2 == 0) l.lisaaAlkuun(t1[i]);
            else l.lisaaLoppuun(t1[i]); 
            summa += l.haeAlkio(t2[i]);
        }
    
        //long t2 = System.nanoTime();
        //long dt = t2-t1;
        //System.out.println(dt);
    }
}
