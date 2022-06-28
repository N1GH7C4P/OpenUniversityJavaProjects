import java.util.*;

public class Jarjestykset {     
    
    Graph verkko;
    
    public Jarjestykset(int n) {
        this.verkko = new Graph(n);
    }

    public void lisaaKaari(int a, int b) {
        this.verkko.addEdge(a-1, b-1);
    }
    
    public int laske() {
        this.verkko.allTopologicalSorts();
        return this.verkko.numberOfSolutions();
    }
    //Java program to print all topolgical sorts of a graph  
}
