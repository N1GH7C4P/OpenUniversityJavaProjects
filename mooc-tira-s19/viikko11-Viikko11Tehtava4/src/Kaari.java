public class Kaari {
    int alku; // mistä solmusta kaari alkaa
    int loppu; // mihin solmuun kaari päättyy
    int pituus;
    
    public Kaari(int alku, int loppu, int pituus) {
        this.alku = alku;
        this.loppu = loppu;
        this.pituus = pituus;
    }
    
    public String toString() {
        return "("+alku+","+loppu+","+pituus+")";
    }
}
