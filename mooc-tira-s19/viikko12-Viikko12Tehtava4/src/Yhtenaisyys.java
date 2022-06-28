import java.util.*;

public class Yhtenaisyys {     
    
    private Graph verkko;
    private Boolean connected;
    
    public Yhtenaisyys(int n) {
        this.verkko = new Graph(n);
        this.connected = true;
    }

    public void lisaaKaari(int a, int b) {
        this.verkko.addEdge(a-1, b-1);
    }
        
    public boolean tutki() {
        return this.verkko.vahvaYhteys() ;
    }

}
