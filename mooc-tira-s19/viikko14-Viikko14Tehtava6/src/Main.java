import java.util.*;

public class Main {
    public static void main(String[] args) {
        Ruudukko r = new Ruudukko();
        int[][] x = {{1,0,0},
                     {0,1,1},
                     {1,0,0}};
        System.out.println(r.muodosta(x)); // [(V,2), (P,1)]
    }
}
