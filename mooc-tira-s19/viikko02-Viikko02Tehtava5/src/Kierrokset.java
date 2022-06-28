
import java.util.Arrays;

public class Kierrokset {
    int laske(int[] t) {
        
        int kierrokset = 0;
        int luku = 1;
        int min = 0;
        
        while(luku <= t.length) {
            
            int pieninNahty = t.length;
            for (int i = min; i < t.length; i++) {
                
                if(t[i] < pieninNahty && t[i] > luku) {
                    pieninNahty = t[i];
                }
                
                if(t[i] == luku) {
                    luku++;
                    if(luku == pieninNahty) {
                        break;
                    }
                }
            }
            kierrokset++;
        }
        return kierrokset;
    }
}
