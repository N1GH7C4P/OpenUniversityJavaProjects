import java.util.*;

public class Kunnostus {     
    
    private int[] vanhempi;
    private int[] koko;
    private int yhdistymisia;
    private int n;
    private int kokonaisHinta;
    private Stack<Kaari> tiet;
    
    public Kunnostus(int n) {
        this.tiet = new Stack();
        this.n = n;
        this.vanhempi = new int[n+1];
        this.koko = new int[n+1];
        this.yhdistymisia = 0;
        for(int i = 1; i < n+1; i++) {
            this.koko[i] = 1;
            this.vanhempi[i] = i;           
        }
    }

    public Boolean yhdista(int a, int b) {
        a = etsiHuippu(a);
        b = etsiHuippu(b);
      
        if(a == b) {
            return false;
        }
        if(koko[a] > koko[b]) {
            vanhempi[b] = a;
            koko[a] += koko[b];
        }else {
            vanhempi[a] = b;
            koko[b] += koko[a];
        }
        this.yhdistymisia++;
        return true;
    }

    public int etsiHuippu(int a) {
        while(vanhempi[a] != a) {
            a = vanhempi[a];
        }
        return a;
    }
    
    public void lisaaTie(int a, int b, int x) {
        this.tiet.add(new Kaari(a,b,x));
    }
    
    public int laske() {
        if(n == 0 || n == 1) {
            return 0;
        }
        Collections.sort(tiet);
        while(!tiet.isEmpty()) {
            Kaari tie = tiet.pop();
            int alku = tie.getAlku();
            int loppu = tie.getLoppu();
            if(yhdista(alku,loppu)) {
                int hinta = tie.getPituus();
                this.kokonaisHinta += hinta;
                if(n-yhdistymisia == 1) {
                    return kokonaisHinta;
                }
            }
        }
        return -1;
    }
}
