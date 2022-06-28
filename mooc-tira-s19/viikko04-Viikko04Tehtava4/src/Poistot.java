public class Poistot {
    
    int nollat = 0;
    boolean stats = false;
    
    int laske(int[] t) {

        
        while(true) {
            
            for(int i = 1; i < t.length; i++) {
                if(t[i-1] == t[i]) {
                    t[i-1] = 0;
                    t[i] = 0;
                    nollat += 2;
                }
            }
            int[] t2 = new int[t.length-nollat];
            int lisatty = 0;
            for(int i = 0; i < t.length; i++) {
                if(t[i] != 0) {
                    
                    if(stats){
                        System.out.println("");
                        for(int j = 0; j < t.length; j++) {
                            System.out.print("["+t[j]+"]");
                        }
                        System.out.println("");
                        System.out.println("t.length: "+t.length);
                        System.out.println("nollat: "+nollat);
                        System.out.println("t2.length: "+t2.length);
                        System.out.println("i: "+i);
                        System.out.println("lisatty: "+lisatty);
                        System.out.println("lisataan: "+t[i]+" indeksiin: "+i);
                    }
                    
                    if(t.length - nollat == 0) {
                        break;
                    }
                    t2[lisatty] = t[i];
                    lisatty++;
                }
            }
            lisatty = 0;
            t = t2;
            if(nollat==0 || t.length==0) {
                break;
            }
            nollat = 0;
        }
    System.out.println("Lopputulos: ");
    return t.length;
    }
}
