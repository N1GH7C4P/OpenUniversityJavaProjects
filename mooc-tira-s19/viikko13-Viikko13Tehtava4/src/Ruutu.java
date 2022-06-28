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

public class Ruutu {
    
    private int x;
    private int y;
    private int vanhempi;
    private ArrayList<Ruutu> naapurit;
    
    public Ruutu(int x,int y, int vanhempi) {
        this.x = x;
        this.y = y;
        this.vanhempi = vanhempi;
        this.naapurit = new ArrayList();
    }
    public void lisaaNaapuri(Ruutu a) {
        this.naapurit.add(a);
    }
    public ArrayList<Ruutu> getNaapurit() {
        return this.naapurit;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getVanhempi() {
        return this.vanhempi;
    }
    public void setVanhempi(int vanhempi) {
        this.vanhempi = vanhempi;
    }
    
    @Override
    public String toString() {
        String a = "";
        a += "["+this.vanhempi+"]";
        return a;
    }
}
