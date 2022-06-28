import java.util.*;
import java.util.stream.Collectors;

public class HatutJaPallot {
    
    HashMap<Integer, Integer> hatut = new HashMap();
    int suurinMaara = 0;
    
    void lisaaPallo(int x) {
        if(hatut.get(x) == null) {
            hatut.put(x, 1);
        } else{
            hatut.put(x, hatut.get(x) + 1);
        }
        if(hatut.get(x) > suurinMaara) {
            suurinMaara = hatut.get(x);
        }
    }
    
    int monessakoYksi() {
        return hatut.size();
    }
    
    int suurinMaara() {
        return suurinMaara;
    }
}
