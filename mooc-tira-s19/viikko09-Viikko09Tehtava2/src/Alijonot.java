import java.util.*;

public class Alijonot {  
    
    int[] pisin;
    long kaikistaPisin;
    
    public void printStats(int[]t,int[]pisin,int k, int x) {
            System.out.println("k: "+k);
            System.out.println("x: "+x);
            System.out.println("t[x]: "+t[x]);
            System.out.println("t[k]: "+t[k]);
            System.out.println("pisin[k]: "+pisin[k]);
            System.out.println("pisin[x]: "+pisin[x]);
            System.out.println("");
    }
    
    public void printPisimmat(int[] pisin) {
        for(int i = 0; i < pisin.length;i++) {
            System.out.println(pisin[i]);
        }
    }
    
    public long laske(int[] t) {
        
        int[] pisin = new int[t.length];
        long kaikistaPisin = 1;
        kaikistaPisin = etsiPisin(t, pisin, kaikistaPisin);
        return kaikistaPisin;
        
    }
    public long etsiPisin(int[] t, int[] pisin, long kaikistaPisin) {
        int n = t.length;
        for(int k = 0; k < n; k++) {
            pisin[k] = 1;
            for(int x = 0; x < k; x++) {
                if (t[x] == t[k]+1 || t[x] == t[k]-1) {
                    //printStats(t,pisin,k,x);
                    if(pisin[x]+1 > pisin[k]) {
                        pisin[k] = pisin[x]+1;
                        if(pisin[k] > kaikistaPisin) {
                            kaikistaPisin = pisin[k];
                        }
                    }
                }
            }
        }
        return kaikistaPisin;
    }
}
