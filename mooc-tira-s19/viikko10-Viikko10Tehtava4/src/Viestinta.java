import java.util.*;

public class Viestinta {  
   
    private Integer n;
    private boolean[][] yhteydet;
    private boolean[] vierailtu;
   
    public Viestinta(int n) {
        this.n = n;
        this.yhteydet = new boolean[n+1][n+1];
        for(int i = 1; i < n+1 ; i++){ 
            this.yhteydet[i] = new boolean[n+1];
        } 
    }
    
    public void unvisitAll() {
        this.vierailtu = new boolean[this.n+1];
    }
    
    public void lisaaYhteys(int a, int b) {
        this.yhteydet[a][b] = true;
        this.yhteydet[b][a] = true;
        //System.out.println("lisataan yhteys: "+a+" --> "+b);
    }
    
    void syvyyshaku(int a) {
        this.vierailtu[a] = true;
        //System.out.println("Käydään läpi solmun: "+a+" naapurit.");
        for (int i = 1; i < this.n+1; i++) {
                //System.out.println("i: "+i);
                //System.out.println("solu: "+this.verkko[a].get(i));
                //System.out.println("naapurin status: "+this.visited[this.verkko[a].get(i)]);
                if(!this.vierailtu[i]){
                    //System.out.println("tehdään syvyyshaku: "+this.verkko[a].get(i));
                    this.syvyyshaku(i);
                }
        } 
    } 
    
    public boolean tarkasta(int x, int y) {
        //System.out.println("yhteyksia: "+verkko[x].size());
        //System.out.println("n: "+this.n);
        
        this.unvisitAll();
       
        syvyyshaku(x);
        if(this.vierailtu[y]) {
            return true;
        }
        return false;
    }
}
