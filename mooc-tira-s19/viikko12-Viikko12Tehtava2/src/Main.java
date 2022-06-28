import java.util.*;

public class Main {
    public static void main(String[] args) {
        Kurssit k = new Kurssit();
        k.lisaaKurssi("OHPE");
        k.lisaaKurssi("OHJA");
        k.lisaaKurssi("TIRA");
        k.lisaaKurssi("OHTE");
        k.lisaaVaatimus("OHPE","OHJA");
        k.lisaaVaatimus("OHJA","TIRA");
        k.lisaaVaatimus("OHJA","OHTE");
        System.out.println(k.muodosta()); // [OHPE, OHJA, OHTE, TIRA]
    }
}
