import java.util.*;

public class Main {
    
    
    
    public static void main(String[] args) {
        Mediaani m = new Mediaani();
        
        m.lisaa(3);
        
        System.out.println(m.toString());
        System.out.println("tulos: "+m.mediaani()); // 3
        
        m.lisaa(1);
        System.out.println(m.toString());
        System.out.println("tulos: "+m.mediaani()); // 1
        
        m.lisaa(4);
        System.out.println(m.toString());
        System.out.println("tulos: "+m.mediaani()); // 3
        
        m.lisaa(7);
        System.out.println(m.toString());
        System.out.println("tulos: "+m.mediaani()); // 3
        
        m.lisaa(1);
        System.out.println(m.toString());
        System.out.println("tulos: "+m.mediaani()); // 3
        
        m.lisaa(1);
        System.out.println(m.toString());
        System.out.println("tulos: "+m.mediaani()); // 3
        
        m.lisaa(1);
        System.out.println(m.toString());
        System.out.println("tulos: "+m.mediaani()); // 3
        
        m.lisaa(1);
        System.out.println(m.toString());
        System.out.println("tulos: "+m.mediaani()); // 3
        
        m.lisaa(1);
        System.out.println(m.toString());
        System.out.println("tulos: "+m.mediaani()); // 3
        
        
        
        
    }
}
