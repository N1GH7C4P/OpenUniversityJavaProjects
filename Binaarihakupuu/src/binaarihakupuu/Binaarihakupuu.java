/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaarihakupuu;

/**
 *
 * @author nightcap
 */
public class Binaarihakupuu {
    
    private Solmu juuri;
    
    public Binaarihakupuu() {
        this.juuri = null;
    }
    
    public class Solmu {
        private int arvo;
        private Solmu oikea;
        private Solmu vasen;
        
        public Solmu(int arvo) {
            this.arvo = arvo;
            this.oikea = null;
            this.vasen = null;
        }
        
        public void AsetaArvo(int a) {
            this.arvo = a;
        }
        public void AsetaOikea(Solmu a) {
            this.oikea = a;
        }
        public void AsetaVasen(Solmu a) {
            this.vasen = a;
        }
        public int getArvo() {
            return this.arvo;
        }
    }
    
    private Solmu lisaaRekursiolla(Solmu nykyinen, int arvo) {
        if (nykyinen == null) {
            return new Solmu(arvo);
        }
        if (arvo < nykyinen.arvo) {
            nykyinen.vasen = lisaaRekursiolla(nykyinen.vasen, arvo);
        } else if (arvo > nykyinen.arvo) {
            nykyinen.oikea = lisaaRekursiolla(nykyinen.oikea, arvo);
        } else {
            return nykyinen;
        }
        return nykyinen;
    }
    
    public void lisaa(int arvo) {
        juuri = lisaaRekursiolla(juuri, arvo);
    }
    
    void tulosta(Solmu solmu) {
        if (solmu == null) {
            return;
        }
        
        tulosta(solmu.vasen);
        System.out.println(solmu.arvo);
        tulosta(solmu.oikea);
    }
        
    
    int korkeus(Solmu solmu) {
        if (solmu == null) {
            return -1;
        }
        return 1 + Math.max(korkeus(solmu.vasen), korkeus(solmu.oikea));
    }
    
    int laskePuunKorkeus() {
        return(korkeus(juuri));
    } 
    
    int laskeSolmut(Solmu solmu) {
        if (solmu == null) {
            return 0;
        }

        return 1 + laskeSolmut(solmu.vasen) + laskeSolmut(solmu.oikea);
    }
}
