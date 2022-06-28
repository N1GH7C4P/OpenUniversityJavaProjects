import java.util.*;

public class SamatLuvut {
    
    TreeMap<Integer,Integer> tm = new TreeMap();
    
    public void lisaa(int x) {
        tm.put(x, tm.getOrDefault(x, 0)+1);
    }

    public void poista(int x) {
        tm.put(x, tm.getOrDefault(x, 1)-1);
        if(tm.get(x) == 0) {
            tm.remove(x);
        }
    }    
    
    public int pienin() {
        return tm.firstKey();
    }
}
