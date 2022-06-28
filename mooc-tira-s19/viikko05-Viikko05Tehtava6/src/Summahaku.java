import java.util.*;

public class Summahaku {
    int[] alkiot = new int [200];
    
    long laske(int[] t, int x) {
        for(int i = 0; i < t.length; i++) {
            alkiot[t[i]+100]++;
        }
        
    }
}
