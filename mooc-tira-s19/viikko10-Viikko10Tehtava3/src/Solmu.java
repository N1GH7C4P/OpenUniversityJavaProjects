/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kimmo
 */
import java.util.*;

public class Solmu implements Comparable<Solmu> {
    private ArrayList<Solmu> yhteydet;
    private Boolean visited;
    private Integer etaisyys;
    private Integer id;
    public Solmu(int id) {
        this.yhteydet = new ArrayList<Solmu>();
        this.visited = false;
        this.etaisyys = 0;
        this.id = id;
    }
    public void lisaaYhteys(Solmu kohde) {
        this.yhteydet.add(kohde);
    }
    public ArrayList<Solmu> getNaapurit() {
        return this.yhteydet;
    }
    public void visit() {
        this.visited = true;
    }
    public void unVisit() {
        this.visited = false;
    }
    public Boolean getVisitStatus() {
        return this.visited;
    }
    public void setEtaisyys(Integer a) {
        this.etaisyys = a;
    }
    public Integer getEtaisyys() {
        return this.etaisyys;
    }
    public Integer getId() {
        return this.id;
    }
    public ArrayList<Integer> getYhteydet() {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i = 0; i < this.getNaapurit().size(); i++) {
            a.add(this.getNaapurit().get(i).getId());
        }
        return a;
    }
    public String toString() {
        
        String a = "id: "+this.id+"\n";
        a += "visited: "+this.visited+"\n";
        a += "etaisyys: "+this.etaisyys+"\n";
        a += "yhteydet lkm: "+this.getNaapurit().size()+"\n";
        a += "yhteydet"+this.getYhteydet()+"\n";
        
        return a;
    }
    public int compareTo(Solmu b) {
        if(this.id > b.id) {
            return -1;
        }else if(this.id < b.id) {
            return 1;
        }else return 0;
    } 
}
