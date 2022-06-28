import java.util.*;
public class Yhteydet {
    
    private Verkko verkko;
    
    public Yhteydet(int n) {
        this.verkko = new Verkko(n);
    }
    
    public void yhdista(int a, int b) {
        Solmu c = this.verkko.getSolmu(a);
        Solmu d = this.verkko.getSolmu(b);
        this.verkko.yhdista(c, d);
    }
    
    public int tutki(int a, int b) {
        Solmu c = this.verkko.getSolmu(a);
        Solmu d = this.verkko.getSolmu(b);
        int paiva = this.verkko.etsiYhdistysPaiva(c, d);
        return paiva;
    }
}
