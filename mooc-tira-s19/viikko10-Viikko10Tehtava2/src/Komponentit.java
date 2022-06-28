import java.util.ArrayList; 
class Komponentit { 

    private int n; 
    ArrayList<Integer>[] verkko;
    private int komponentit;
    private Boolean yhteyksia;
 
    Komponentit(int n) {
        this.yhteyksia = false;
        this.komponentit = 0;
        this.n = n;  
        this.verkko = new ArrayList[n+1]; 

        for(int i = 0; i < n+1 ; i++){ 
            this.verkko[i] = new ArrayList<Integer>(); 
        } 
    } 
    void lisaaYhteys(int a, int b) {  
        this.yhteyksia = true;
        this.verkko[a].add(b);
        this.verkko[b].add(a);
    }
    void syvyyshaku(int i, boolean[] vierailtu) { 
        vierailtu[i] = true; 
        for (int x : verkko[i]) { 
                if(!vierailtu[x]) syvyyshaku(x,vierailtu); 
        } 
    } 
    int laske() { 
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        if(!yhteyksia) {
            return n;
        }
        boolean[] vierailtu = new boolean[n+1];
        
        for(int i = 1; i < n; i++) { 
            if(!vierailtu[i]) {
                komponentit++;
                syvyyshaku(i,vierailtu);  
            } 
        }
        return komponentit;
    }
}