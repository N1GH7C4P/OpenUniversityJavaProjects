public class Lista {
    
    int[] t = new int[10];
    //indeksi 0 -> 9
    
    int lukujaYhteensa = 0;
    int aloituskohta = 4;
    int lopetuskohta = 6;
    boolean stats = false;
    
    void tulostaLista(){
        if(stats) {
            System.out.println("Aloituskohta: "+aloituskohta);
            System.out.println("Lopetuskohta: "+lopetuskohta);
            System.out.println("Taulukon koko: "+t.length);
            System.out.println("ukuja yhteensä: "+lukujaYhteensa);

            for(int i = 0; i < t.length; i++) {
                System.out.print("["+t[i]+"]");
                if( i > 1 && (i+1) % 10 == 0) {
                    System.out.println("\n");
                }
            }
        }
    }
    
    void lisaaAlkuun(int x) {
        if(aloituskohta == 4 && lopetuskohta == 6) {
            lopetuskohta++;
        }
        if(aloituskohta == -1) {
            if(stats)System.out.println("Laajennetaan Alusta");
            laajennaAlusta();
        }
        t[aloituskohta+1] = x;
        aloituskohta--;
        lukujaYhteensa++;
    }
    
    void lisaaLoppuun(int x) {
        if(aloituskohta == 4 && lopetuskohta == 6) {
            aloituskohta--;
        }
        if(lopetuskohta == t.length+1) {
            if(stats)System.out.println("Laajennetaan lopusta");
            laajennaLopusta();
        }
        t[lopetuskohta - 1] = x;
        lopetuskohta++;
        lukujaYhteensa++;
    }
    
    void laajennaAlusta() {
        int[] t2 = new int [2*t.length];
        
        int uusiAloituskohta = t2.length - t.length -1;
        int uusiLopetuskohta = t2.length - 1;
         
        for(int i = 0; i < t.length; i++) {
            t2[i + uusiAloituskohta] = t[i];
        }
        
        aloituskohta = uusiAloituskohta-1;
        lopetuskohta = uusiLopetuskohta;
        
        t = t2;
    }
    
    void laajennaLopusta() {
        int[] t2 = new int [2*t.length];
        
        int uusiAloituskohta = t2.length - t.length -1;
        int uusiLopetuskohta = t2.length - t.length + 1;
        
        for(int i = 0; i < t.length-aloituskohta; i++) {
            t2[i + uusiAloituskohta] = t[i + aloituskohta];
        }
        
        aloituskohta = uusiAloituskohta;
        lopetuskohta = uusiLopetuskohta + lukujaYhteensa;
        
        t = t2;
    }
    
    
    int haeAlkio(int k) {
        tulostaLista();
        return t[aloituskohta+k+2];
    }    
}
