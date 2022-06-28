import java.util.*;

public class Tehtavat {
    
    PriorityQueue<Tehtava> keko = new PriorityQueue();
    
    public void lisaa(String nimi, int kiireellisyys) {
        Tehtava a = new Tehtava(nimi, kiireellisyys);
        keko.add(a);
    }
    
    public String hae() {
        String a = keko.peek().getNimi();
        keko.poll();
        return a;
    }
}
