import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("12.2")
public class KurssitTest {
    ArrayList<String> kurssit = new ArrayList<>();
    HashMap<String,ArrayList<String>> vaatimukset = new HashMap<>();
    Kurssit k;
    HashMap<String,Integer> milloin = new HashMap<>();
    
    void alusta() {
        kurssit.clear();
        vaatimukset.clear();
        milloin.clear();
        k = new Kurssit();
    }
    
    void lisaaKurssi(String s) {
        kurssit.add(s);
        vaatimukset.put(s,new ArrayList<>());
        k.lisaaKurssi(s);
    }
    
    void lisaaVaatimus(String a, String b) {
        vaatimukset.get(a).add(b);
        k.lisaaVaatimus(a,b);
    }
    
    void testi(boolean voiko) {
        ArrayList<String> tulos = k.muodosta();
        if (!voiko && tulos == null) return;
        if (!voiko) fail("Kursseja ei voi suorittaa mutta luokkasi antaa järjestyksen");
        if (tulos == null) fail("Kurssit voi suorittaa mutta luokkasi ei anna järjestystä");
        if (kurssit.size() != tulos.size()) fail("Kurssien määrä järjestyksessä on väärä");
        int laskuri = 0;
        for (String x : tulos) {
            milloin.put(x,++laskuri);
        }
        for (String x : kurssit) {
            if (!milloin.containsKey(x)) fail("Järjestyksessä on tuntematon kurssi");
        }
        for (String a : kurssit) {
            for (String b : vaatimukset.get(a)) {
                if (milloin.get(a) > milloin.get(b)) {
                    fail("Järjestys ei ole kelvollinen");
                }
            }
        }
    }
    
    @Test(timeout = 1000)
    public void testi1() {
        alusta();
        lisaaKurssi("OHPE");
        testi(true);
    }        

    @Test(timeout = 1000)
    public void testi2() {
        alusta();
        lisaaKurssi("OHPE");
        lisaaKurssi("OHJA");
        lisaaVaatimus("OHPE","OHJA");
        testi(true);
    }        

    @Test(timeout = 1000)
    public void testi3() {
        alusta();
        lisaaKurssi("OHPE");
        lisaaKurssi("OHJA");
        lisaaVaatimus("OHPE","OHJA");
        lisaaVaatimus("OHJA","OHPE");
        testi(false);
    }        

    @Test(timeout = 1000)
    public void testi4() {
        alusta();
        lisaaKurssi("TIRA");
        // TIRA on rekursiivinen kurssi
        lisaaVaatimus("TIRA","TIRA");
        testi(false);
    }        

    @Test(timeout = 1000)
    public void testi5() {
        alusta();
        lisaaKurssi("OHPE");
        lisaaKurssi("OHJA");
        lisaaKurssi("TIRA");
        lisaaKurssi("LAMA");
        lisaaVaatimus("OHPE","OHJA");
        lisaaVaatimus("OHJA","TIRA");
        lisaaVaatimus("TIRA","LAMA");
        testi(true);
    }        
    
    @Test(timeout = 1000)
    public void testi6() {
        alusta();
        lisaaKurssi("OHPE");
        lisaaKurssi("OHJA");
        lisaaKurssi("TIRA");
        lisaaKurssi("LAMA");
        testi(true);
    }        

    @Test(timeout = 1000)
    public void testi7() {
        alusta();
        lisaaKurssi("OHPE");
        lisaaKurssi("OHJA");
        lisaaKurssi("TIRA");
        lisaaKurssi("LAMA");
        lisaaVaatimus("OHPE","OHJA");
        lisaaVaatimus("OHJA","TIRA");
        lisaaVaatimus("TIRA","LAMA");
        lisaaVaatimus("LAMA","OHJA");
        testi(false);
    }        
    
    String nimi(int x) {
        String s = "";
        for (int i = 0; i < 4; i++) {
            s += (char)('A'+x%26);
            x /= 26;
        }
        return s;
    }

    @Test(timeout = 1000)
    public void testi8() {
        alusta();
        int n = 100;
        for (int i = 0; i < n; i++) {
            lisaaKurssi(nimi(i));
        }
        for (int i = 0; i < n-1; i++) {
            lisaaVaatimus(nimi(i),nimi(i+1));
        }
        testi(true);
    }        

    @Test(timeout = 1000)
    public void testi9() {
        alusta();
        int n = 100;
        for (int i = 0; i < n; i++) {
            lisaaKurssi(nimi(i));
        }
        for (int i = 0; i < n-1; i++) {
            lisaaVaatimus(nimi(i),nimi(i+1));
        }
        lisaaVaatimus(nimi(n-1),nimi(0));
        testi(false);
    }        

    @Test(timeout = 1000)
    public void testi10() {
        alusta();
        int n = 100;
        for (int i = 0; i < n; i++) {
            lisaaKurssi(nimi(i));
        }
        int m = 5000;
        Random r = new Random(1337);
        for (int i = 0; i < m; i++) {
            int a = r.nextInt(n-1);
            int b = a+r.nextInt(n-a-1)+1;
            lisaaVaatimus(nimi(a),nimi(b));
        }
        testi(true);
    }        

    @Test(timeout = 1000)
    public void testi11() {
        alusta();
        int n = 100;
        for (int i = 0; i < n; i++) {
            lisaaKurssi(nimi(i));
        }
        int m = 5000;
        Random r = new Random(1337);
        for (int i = 0; i < m; i++) {
            int a = r.nextInt(n);
            int b = r.nextInt(n);
            lisaaVaatimus(nimi(a),nimi(b));
        }
        testi(false);
    }        

    @Test(timeout = 1000)
    public void testi12() {
        alusta();
        int n = 100;
        for (int i = 0; i < n; i++) {
            lisaaKurssi(nimi(i));
        }
        testi(true);
    }        

    @Test(timeout = 1000)
    public void testi13() {
        alusta();
        lisaaKurssi("OHPE");
        lisaaKurssi("OHJA");
        lisaaVaatimus("OHPE","OHJA");
        lisaaVaatimus("OHPE","OHJA");
        testi(true);
    }        

    @Test(timeout = 1000)
    public void testi14() {
        alusta();
        int n = 100;
        for (int i = 0; i < n; i++) {
            lisaaKurssi(nimi(i));
        }
        for (int i = 1; i < n; i++) {
            lisaaVaatimus(nimi(0),nimi(i));
        }
        testi(true);
    }        

    @Test(timeout = 1000)
    public void testi15() {
        alusta();
        int n = 100;
        for (int i = 0; i < n; i++) {
            lisaaKurssi(nimi(i));
        }
        for (int i = 0; i < n-1; i++) {
            lisaaVaatimus(nimi(i),nimi(n-1));
        }
        testi(true);
    }        

    @Test(timeout = 1000)
    public void testi16() {
        alusta();
        int n = 100;
        for (int i = 0; i < n; i++) {
            lisaaKurssi(nimi(i));
        }
        int m = 5000;
        for (int i = 0; i < m; i++) {
            lisaaVaatimus(nimi(0),nimi(n-1));
        }
        testi(true);
    }        

    @Test(timeout = 1000)
    public void testi17() {
        alusta();
        lisaaKurssi("AYBA");
        lisaaKurssi("BTUA");
        lisaaKurssi("YBAB");
        lisaaKurssi("TUAY");
        lisaaKurssi("BABT");
        lisaaKurssi("UAYB");
        lisaaKurssi("ABTU");
        lisaaVaatimus("AYBA","YBAB");
        lisaaVaatimus("BTUA","AYBA");
        lisaaVaatimus("BTUA","YBAB");
        lisaaVaatimus("BTUA","BABT");
        lisaaVaatimus("TUAY","ABTU");
        lisaaVaatimus("BABT","YBAB");
        lisaaVaatimus("UAYB","AYBA");
        lisaaVaatimus("UAYB","BABT");
        testi(true);
    }        
    
}
