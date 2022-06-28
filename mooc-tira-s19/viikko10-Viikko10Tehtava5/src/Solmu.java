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

public class Solmu {
    private Solmu alas;
    private Solmu ylos;
    private Solmu vasen;
    private Solmu oikea;
    private Character merkki;
    private int x;
    private int y;
    private Boolean up;
    private Boolean down;
    private Boolean left;
    private Boolean rigth;
    
    public Solmu(Character merkki, int x, int y) {
        this.rigth = false;
        this.left = false;
        this.up = false;
        this.down = false;
        this.merkki = merkki;
        this. x = x;
        this.y = y;
    }
    public Character getMerkki() {
        return this.merkki;
    }
    public Integer getX() {
        return this.x;
    }
    public Integer getY() {
        return this.y;
    }
    public void setMerkki(Character a) {
        this.merkki = a;
    }
    public String toString() {
        
        String a = "merkki: "+this.merkki+"\n";
        a += "x: "+this.x+"\n";
        a += "y: "+this.y+"\n";
        
        return a;
    }
}
