import java.util.*;

public class Latinalaiset {  
    
    int laskuri;
    
    public int laske(int n) {
        laskuri = 0;
        
        LatinSquare nelio = new LatinSquare(n);
        haku(0, nelio, n);
        
        return laskuri;
    }
    
    public void haku(int y, LatinSquare nelio, int n) {
        if (y == n) {
            laskuri += 1;
            System.out.println("nelio: ");
            System.out.println(nelio.toString());
            nelio = new LatinSquare(n);
        }
        else {
            for (int x = 0; x < n; x++) {
                if(nelio.check(x, y, x)) {
                    nelio.set(x, y, x);
                    haku(y+1, nelio, n);
                }
            }
        }
    }
} 
