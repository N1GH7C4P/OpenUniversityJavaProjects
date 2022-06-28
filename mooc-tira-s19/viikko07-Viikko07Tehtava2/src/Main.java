import java.util.*;

public class Main {
    public static void main(String[] args) {
        Tehtavat t = new Tehtavat();
        t.lisaa("apina",30);
        t.lisaa("banaani",70);
        t.lisaa("cembalo",20);
        System.out.println(t.hae()); // banaani
        System.out.println(t.hae()); // apina
        t.lisaa("aybabtu",100);
        System.out.println(t.hae()); // aybabtu
    }
}
