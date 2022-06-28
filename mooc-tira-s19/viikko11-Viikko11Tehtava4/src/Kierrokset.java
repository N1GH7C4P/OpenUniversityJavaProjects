import java.util.*;

public class Kierrokset {
    
    private boolean muutos;
    private ArrayList<Kaari> kaaret;
    private ArrayList<Solmu> solmut;
    int[] etaisyydet;
    int kierrokset = 0;
    
    public void lisaaKaari(Solmu alku, Solmu loppu, int pituus) {
        Kaari k = new Kaari(alku.getId(), loppu.getId(), pituus);
        this.kaaret.add(k);
    }
    
    public ArrayList<Kaari> muodosta(int x) {
        
        kierrokset = 1;
        kaaret = new ArrayList();
        solmut = new ArrayList();
        etaisyydet = new int[100];
        
        if(x==1) {
            return new ArrayList();
        }
        
        for(int i = 0; i < 100; i++) {
            solmut.add(new Solmu(i));
            etaisyydet[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < x; i++) {
            this.lisaaKaari(solmut.get(x), solmut.get(x-i), x);
        }
       
        while(true) {
            kierrokset++;
            muutos = false;
            for(Kaari k : kaaret) {
                System.out.println("alku: "+k.alku);
                System.out.println("loppu: "+k.loppu);
                int nyky = etaisyydet[k.loppu];
                int uusi = etaisyydet[k.alku]+k.pituus;
                if(uusi < nyky) {
                    etaisyydet[k.loppu] = uusi;
                    muutos = true;
                }
            }if (!muutos) {
                break;
            }
        }
        System.out.println("Kierrokset: "+kierrokset);
        return kaaret;
    }
}
