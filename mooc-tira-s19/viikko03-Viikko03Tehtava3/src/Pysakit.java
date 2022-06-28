import java.util.*;

public class Pysakit {
    int laske(int[] t, int k) {
        Arrays.sort(t);
        int pysakit = 1;
        int pysakki = t[0] + k;
        
        for(int i = 0; i < t.length; i++){
            if(pysakki + k < t[i]) {
                pysakit++;
                pysakki = t[i] + k;
            }
        }
        
        return pysakit;
    }
}
