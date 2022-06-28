import java.util.*;

public class Main {
    public static void main(String[] args) {
        Kierrokset k = new Kierrokset();
        ArrayList<Kaari> a = k.muodosta(20);
        System.out.println(a); // [(1,2,5), (2,3,3), (3,4,4), (1,3,7)]
    }
}
