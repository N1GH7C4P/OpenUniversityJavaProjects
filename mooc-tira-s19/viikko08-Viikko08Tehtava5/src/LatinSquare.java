/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nightcap
 */
public class LatinSquare {
    private int[][] grid;
    private int n;
    
    LatinSquare(int n) {
        this.grid = new int[n][n];
        this.n = n;
    }
    public int get(int x, int y) {
        return this.grid[x][y];
    }
    public void set(int x, int y, int a) {
        this.grid[x][y] = a;
    }
    public boolean check(int x, int y, int a) {
        for(int i = 0; i < n; i++) {
            if(this.grid[i][y] == a) {
                return false;
            }
        }
        for(int i = 0; i < n; i++) {
            if(this.grid[x][i] == a) {
                return false;
            }
        }
        return true;
    }
    public String toString() {
        String a = "";
        for(int i = 0; i < this.n; i++) {
            for(int j = 0; j < this.n; j++) {
                a += "["+this.grid[j][i]+"]";
            }
            a += "\n";
        }
        return a;
    }
}
