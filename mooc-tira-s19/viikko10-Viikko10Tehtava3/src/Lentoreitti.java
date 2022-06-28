import java.util.*; 

public class Lentoreitti {  
    
    private ArrayDeque<Solmu> jono;
    private Integer[] etaisyys;
    private Solmu[] verkko;
    private Solmu solmu;
    private Boolean vastausonyksi = false;
    
    public Lentoreitti(int n) {
        this.jono = new ArrayDeque();
        this.etaisyys = new Integer[n];
        this.verkko = new Solmu[n+1];
        for(int i = 1; i < n+1 ; i++){ 
            this.verkko[i] = new Solmu(i);
        }
    }
    
    ArrayList<Integer> getYhteydet(int a) {
        return(this.verkko[a].getYhteydet());
    }
    
    void lisaaYhteys(int a, int b) {
        System.out.println("Yhteys lisatty: "+a+" -> "+b);
        this.verkko[a].lisaaYhteys(verkko[b]);
        this.verkko[b].lisaaYhteys(verkko[a]);
    }
    public int laske(int x, int y) {
       
        if(x==y || verkko[x].getYhteydet().contains(y)){
            return 0;
        }
        if(this.vastausonyksi) {
            return 1;
        }
        if(verkko[x].getYhteydet().isEmpty()) {
            return -1;
        }
        this.leveyshaku(x,y,solmu);
        return(this.verkko[y].getEtaisyys()-1);
    }
    public void leveyshaku(int alku, int loppu, Solmu solmu) {
        
        System.out.println("(1) Lisataan jonoon: "+this.verkko[alku].getId());
        this.jono.addLast(this.verkko[alku]);
        this.verkko[alku].visit();
        System.out.println("(2) Jonon pituus: "+this.jono.size());
        while(!this.jono.isEmpty()) {
            if(this.verkko[loppu].getVisitStatus()) {
                System.out.println(verkko[loppu].toString());
                return;
            }
            Solmu uusi = jono.getFirst();
            System.out.println("vanha: "+solmu);
            System.out.println("uusi: "+uusi);
            while(solmu == uusi) {
                if(jono.isEmpty()) {
                    return;
                }
                uusi = jono.pollFirst();
            }
            solmu = uusi;
            
            System.out.println("(3) Otetaan jonosta: "+solmu.getId());
            System.out.println("(4) Kaydään läpi naapurit: "+solmu.getYhteydet().size());
            System.out.println("(5) joiden idt: "+solmu.getYhteydet());
            for(int i = 0; i < solmu.getNaapurit().size(); i++) {
                Solmu naapuri = solmu.getNaapurit().get(i);
                System.out.println("(6) Visit status: "+naapuri.getVisitStatus());
                if(naapuri.getVisitStatus()) {
                    continue;
                }
                this.jono.addFirst(naapuri);
                System.out.println("(7) lisataan jonoon: "+naapuri.getId());
                naapuri.visit();
                naapuri.setEtaisyys(solmu.getEtaisyys()+1);
            }
        }
    }
}
