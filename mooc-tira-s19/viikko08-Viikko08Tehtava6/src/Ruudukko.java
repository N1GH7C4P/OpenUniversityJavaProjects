/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nightcap
 */
public class Ruudukko {
    private Boolean[][] kayty;
    private int x;
    private int y;
    private int n;
    
    public void Ruudukko(int n) {
        this.n = n;
        this.kayty = new Boolean[n][n]; 
    }
    public Boolean yritaOikealle() {
        if(kayty[x+1][y]) {
            return false;
        }else {
            kayty[x+1][y] = true;
            x++;
            return true;
        }
    }
    public Boolean yritaVasemmalle() {
        if(kayty[x-1][y]) {
            return false;
        }else {
            kayty[x-1][y] = true;
            x--;
            return true;
        }
    }
    public Boolean yritaAlas() {
        if(kayty[x][y+1]) {
            return false;
        }else {
            kayty[x][y+1] = true;
            y++;
            return true;
        }
    }
    public Boolean yritaYlos() {
        if(kayty[x][y-1]) {
            return false;
        }else {
            kayty[x][y-1] = true;
            x++;
            return true;
        }
    }
    public Boolean etsiReitti() {
        while(true) {
            if(this.x == this.n && this.y == this.n) {
                return true;
            } 
            else if(this.yritaOikealle()){
                continue;
            }
            else if(this.yritaAlas()) {
                continue;
            }
            else if(this.yritaVasemmalle()) {
                continue;
            }
            else if(this.yritaYlos()) {
                continue;
            }
            return false;
        }
    }
}
