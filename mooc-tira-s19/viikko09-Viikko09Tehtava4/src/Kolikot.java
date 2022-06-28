import java.util.*;

public class Kolikot {  
    public int laske(int[] t) {
        
        int s = Arrays.stream(t).sum();
        boolean[] eriArvot = new boolean[s+1];
        eriArvot[0] = true;
        int n = t.length;
        for(int i = 0;  i < n; i++) {
            for(int j = s; j >= 0; j--) {
                if(eriArvot[j]) {
                    eriArvot[j + t[i]] = true;
                }
            }
        }
        int arvot = -1;
        for(int i = 0; i < eriArvot.length; i++) {
            if(eriArvot[i]) {
                arvot++;
            }
        }
        return arvot;
    }
}
