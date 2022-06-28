import java.util.*;

public class Komponentit {     
    
    private int[] vanhempi;
    private int[] koko;
    private int yhdistymisia;
    private int n;
    
    public Komponentit(int n) {
        this.n = n;
        this.vanhempi = new int[n+1];
        this.koko = new int[n+1];
        this.yhdistymisia = 0;
        for(int i = 1; i < n+1; i++) {
            this.koko[i] = 1;
            this.vanhempi[i] = i;
            
        }
    }

    public void yhdista(int a, int b) {
        a = etsiHuippu(a);
        b = etsiHuippu(b);
      
        if(a == b) {
            return;
        }
        if(koko[a] > koko[b]) {
            vanhempi[b] = a;
            koko[a] += koko[b];
        }else {
            vanhempi[a] = b;
            koko[b] += koko[a];
        }
        this.yhdistymisia++;
    }

    public int etsiHuippu(int a) {
        while(vanhempi[a] != a) {
            a = vanhempi[a];
        }
        return a;
    }
    
    public void tulosta(int[] t) {
        for(int i = 1; i < t.length; i++) {
            System.out.println("vanhempi["+i+"]: "+etsiHuippu(i));
        }
    }
    
    public int laske() {
        return this.n-this.yhdistymisia;
    }
}
