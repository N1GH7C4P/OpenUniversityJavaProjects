public class Pari {
    int opiskelija1; // Kumpulan opiskelija
    int opiskelija2; // Viikin opiskelija
    
    public Pari(int a, int b) {
        opiskelija1 = a;
        opiskelija2 = b;
    }
    
    public String toString() {
        return "("+opiskelija1+","+opiskelija2+")";
    }
}
