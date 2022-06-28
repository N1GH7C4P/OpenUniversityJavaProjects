import java.util.*;

public class Saavutettavuus {  
    
    static Verkko verkko;
    
    public Saavutettavuus(int n) {
        this.verkko = new Verkko(n);
    }
    
    public void lisaaYhteys(int a, int b) {
        this.verkko.lisaaYhteys(a, b);
    }
    
    public int laske(int solmu) {     
        int a = -1;
        
        this.verkko.syvyyshaku(solmu);
        
        for(int i = 0; i < this.verkko.getVierailtu().length; i++) {
            if(this.verkko.getVierailtu()[i] == true) {
                a++;
            }
        }
        return a;
    }
}
