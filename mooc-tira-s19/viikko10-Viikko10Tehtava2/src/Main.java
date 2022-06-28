import java.util.*;

public class Main {
    public static void main(String[] args){
        int n = 5000;
        Komponentit g = new Komponentit(n); 
          
        for (int i = 1; i+1 <= n; i++) g.lisaaYhteys(i,i+1);
        System.out.println(g.laske()); 
    }
}
