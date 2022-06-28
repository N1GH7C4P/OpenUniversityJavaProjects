import java.util.*;

public class Siirto {
    String suunta; // V = vaaka, P = pysty
    int kohta; // 1..n

    public Siirto(String suunta, int kohta) {
        this.suunta = suunta;
        this.kohta = kohta;
    }
    
    public String toString() {
        return "("+suunta+","+kohta+")";
    }
}
