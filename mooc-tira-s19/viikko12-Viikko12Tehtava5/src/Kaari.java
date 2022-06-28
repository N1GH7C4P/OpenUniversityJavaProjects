public class Kaari {
    int alku; // mistä solmusta kaari alkaa
    int loppu; // mihin solmuun kaari päättyy
    private boolean kaannetty;
    
    public Kaari(int alku, int loppu) {
        this.alku = alku;
        this.loppu = loppu;
    }
    public void kaannaKaari() {
        
        int a = this.alku;
        int b = this.loppu;
        
        this.alku = b;
        this.loppu = a;
        this.kaannetty = true;
    }
    public boolean getKaannetty() {
        return this.kaannetty;
    }
    
    public String toString() {
        return "("+alku+","+loppu+")";
    }
}
