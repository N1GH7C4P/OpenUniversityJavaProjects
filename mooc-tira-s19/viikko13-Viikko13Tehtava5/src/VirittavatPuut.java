import java.util.*;

public class VirittavatPuut {     
    
    public int laske(int n) {
        if(n<2) {
            return n;
        }   
        int a = 1;
        for(int i = 0; i < n-2; i++) {
            a = a*n;
        }
        return a;
    }
}
