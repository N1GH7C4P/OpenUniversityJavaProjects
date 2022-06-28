import java.util.*;

public class Tormays {
    
    
    char c1 = 97;
    char c2 = 98;
    String mj1 = "";
    String mj2 = "";
    Random rand = new Random();
    int n = rand.nextInt(20)+10;
    
    String luoMerkkijono() {
        String mj = "";
        
        for(int i = 0; i < n; i++) {
            Boolean b = rand.nextBoolean();
            if(b) {mj += c1;}
            else {mj += c2;}
        }
        return mj;
    }
    
    HashMap<Integer, String> luoMontaMerkkijonoa() {
        HashMap<Integer, String> mjt = new HashMap();
        for(int i = 0; i < 10000000; i++) {
            String mj = luoMerkkijono();
            mjt.put(mj.hashCode(), mj);
        }
        return mjt;
    }
    
    ArrayList<String> jarjestaMerkkijonot(HashMap<Integer,String> mjt) {
        ArrayList<String> tulos = new ArrayList<String>();
        List<Integer> jarjestetty = new ArrayList<>(mjt.keySet());
        Collections.sort(jarjestetty);
        for(int i = 1; i < jarjestetty.size(); i++) {
            if(jarjestetty.get(i) == jarjestetty.get(i-1)) {
                System.out.println(mjt.get(i));
                System.out.println(mjt.get(i-1));
                tulos.add(mjt.get(i));
                tulos.add(mjt.get(i-1));
                return tulos;
            }
            //System.out.println(jarjestetty.get(i));
        }
        System.out.println(tulos.toString());
        return tulos;
    }
    
    String merkkijono1() {
       
        String x = "";
        return x;
    }

    String merkkijono2() {
        
        String x = "";
        return x;
    }

}
