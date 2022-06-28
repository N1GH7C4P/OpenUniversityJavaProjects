import java.util.*;

public class Toistuminen {
    
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    int laskuri = 0;
    int vanha = 0;
    int uusiLuku(int x) {
        
        vanha = hm.getOrDefault(x,-1);
        laskuri++;
        hm.put(x, laskuri);
        
        if(vanha == -1) {
            return - 1;
        }
        
        System.out.println("tulos: ");
        return laskuri - vanha-1;
    }
}
