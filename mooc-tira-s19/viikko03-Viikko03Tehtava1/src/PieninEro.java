import java.util.*;

public class PieninEro {
    
    
    
    int laske(int[] t) {
        
        int min = 1000000000;
        Arrays.sort(t);
        for(int i = 0; i < t.length-1; i++){
            if(t[i+1]-t[i] < min) {
                min = t[i+1]-t[i];
            }
        }    
    return min;
    }
}
