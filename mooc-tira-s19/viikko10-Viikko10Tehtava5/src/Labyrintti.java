import java.util.*;

public class Labyrintti {  
    
    private ArrayDeque<Solmu> jono;
    private Solmu solmu;
    private Verkko verkko;
    private Solmu naapuri;
    private String reitti;
    private Character valinta;
    private Boolean maalissa;
    
    public Labyrintti() {
    }
    
    public String etsi(char[][] laby) {
        this.maalissa = false;
        this.reitti = "";
        this.jono = new ArrayDeque<Solmu>();
        this.verkko = new Verkko(laby);
        this.verkko.tulostaVerkko();
        this.leveyshaku(this.verkko.getAlku(), this.verkko.getLoppu(), this.solmu);
        this.verkko.tulostaVerkko();
        //if(!this.maalissa) {
        //    return null;
        //}
        return this.reitti;
    }
    
    public void leveyshaku(Solmu alku, Solmu loppu, Solmu solmu) {

        this.jono.addLast(alku);
        this.verkko.getSolmu(alku.getX(), alku.getY()).setMerkki('X');
        while(!this.jono.isEmpty()) {
            if(loppu.getMerkki() == 'X') {
                System.out.println("Maalissa!");
                this.maalissa = true;
                return;
            }
            Solmu uusi = jono.getFirst();
            while(solmu == uusi) {
                if(jono.isEmpty()) {
                    return;
                }
                uusi = jono.pollFirst();
            }
            solmu = uusi;
            
            if(solmu.getX() < verkko.getLeveys() && verkko.getSolmu(solmu.getX()+1, solmu.getY()).getMerkki() != 'X' && verkko.getSolmu(solmu.getX()+1, solmu.getY()).getMerkki() != '#'){
                naapuri = verkko.getSolmu(solmu.getX()+1, solmu.getY());
                this.valinta = 'A';
            }
            else if(solmu.getX() < verkko.getLeveys() && verkko.getSolmu(solmu.getX()-1, solmu.getY()).getMerkki() != 'X' && verkko.getSolmu(solmu.getX()-1, solmu.getY()).getMerkki() != '#'){
                naapuri = verkko.getSolmu(solmu.getX()-1, solmu.getY());
                this.valinta = 'Y';
            }
            else if(solmu.getY() < verkko.getKorkeus() && verkko.getSolmu(solmu.getX(), solmu.getY()+1).getMerkki() != 'X' && verkko.getSolmu(solmu.getX(), solmu.getY()+1).getMerkki() != '#'){
                naapuri = verkko.getSolmu(solmu.getX(), solmu.getY()+1);
                this.valinta = 'O';
            }
            else if(solmu.getY() < verkko.getKorkeus() && verkko.getSolmu(solmu.getX(), solmu.getY()-1).getMerkki() != 'X' && verkko.getSolmu(solmu.getX(), solmu.getY()-1).getMerkki() != '#'){
                naapuri = verkko.getSolmu(solmu.getX(), solmu.getY()-1);
                this.valinta = 'V';
            }
            else{
                break;
            }
            this.jono.addFirst(this.naapuri);
            if(this.naapuri.getMerkki() == 'x') {
                this.reitti += this.valinta;
                this.maalissa = true;
                break;
            }
            this.naapuri.setMerkki('X');
            this.reitti += this.valinta;
        }
    }
}