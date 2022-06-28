import java.util.*;

public class PieninEtaisyys {
    
    int ero = 999999999;
    TreeSet<Integer> ts = new TreeSet();
    
    public void lisaa(int x) {
        ts.add(x);
        if(ts.higher(x) != null) {
            int a = ts.higher(x);
            int b = Math.abs(a-x);
            if(b < ero) {
                ero = b;
            }
        }
        
        if(ts.lower(x) != null) {
            int a = ts.lower(x);
            int b = Math.abs(a-x);
            if(b < ero) {
                ero = b;
            }
        }
    }

    public int laske() {
        return ero;
    }
}
