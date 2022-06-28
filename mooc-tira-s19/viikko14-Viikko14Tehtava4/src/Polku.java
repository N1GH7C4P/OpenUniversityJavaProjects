import java.util.*;

public class Polku {
    ArrayList<Integer> solmut = new ArrayList<>();
    
    public void lisaaSolmu(int s) {
        solmut.add(s);
    }
    
    public String toString() {
        if (solmut.size() == 0) return "";
        String tulos = ""+solmut.get(0);
        for (int i = 1; i < solmut.size(); i++) {
            tulos += "->"+solmut.get(i);
        }
        return tulos;
    }
}
