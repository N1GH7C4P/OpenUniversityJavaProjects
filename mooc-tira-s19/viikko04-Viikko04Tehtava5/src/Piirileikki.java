import java.util.ArrayList;
public class Piirileikki {
    
    boolean stats = false;
    
    void printStats(int[] t, int nollat) {
        if(stats) {
            System.out.println("Tilasto: \n");
            System.out.println("nollat: "+nollat);
            for(int i = 1; i < t.length; i++) {
                System.out.print("["+t[i]+"]");
            }
             System.out.println("\n");
        } 
    }
    
    int viimeinen(int n) {
        int[] t = new int[n+1];
        int nollat = -1;
        int lisatty = 1;
        
        for(int i = 0; i < n+1; i++) {
            t[i] = i;
        }
        
        boolean parillinen = true;
        
        while(true) {    
            
            for(int i = 0; i < t.length; i++) {
                if(parillinen) {
                    t[i] = 0;
                    nollat++;
                    parillinen = false;
                }else{
                    parillinen = true;
                }
            }
            
            printStats(t,nollat);
            
            int[] t2 = new int[t.length - nollat];
            for(int i = 0; i < t.length; i++) {
                if(t[i] != 0) {
                    System.out.println(t[i]+" =//= "+"0");
                    t2[lisatty] = t[i];
                    lisatty++;
                }
                else{
                    System.out.println(t[i]+" == "+"0");
                }
            }
            
            if(parillinen = false){
                parillinen = true;
            }else{
                parillinen = false;
            }
            
            nollat = 0;
            lisatty = 0;
            t = t2.clone();
            printStats(t,nollat);
            
            if(t.length == 1) {
                break;
            }
        }
        System.out.println("Tulos: ");
        return t[0];
    }
}
