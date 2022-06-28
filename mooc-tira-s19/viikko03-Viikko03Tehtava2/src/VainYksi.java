import java.util.*;

public class VainYksi {
    
    
    int etsi(int[] t) {
        
        Arrays.sort(t);
        
        if(t.length == 1) {
                return t[0];
        }
        if(t[0] != t[1]) {
                return t[0];
        }
        if(t[t.length-1] != t[t.length-2]) {
                return t[t.length-1];
        }
        
        for(int i = 1; i<t.length-1; i++) {   
            if(t[i] != t[i-1] && t[i] != t[i+1]) {
                return t[i];
            }
        }
        return 0;
    }
}

