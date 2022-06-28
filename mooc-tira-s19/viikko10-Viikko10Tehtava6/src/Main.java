import java.util.*;

public class Main {
    public static void main(String[] args) {
        Labyrintti l = new Labyrintti();
        char[][] t = {{'#','#','#','#','#','#','#'},
                      {'#','x','#','.','y','b','#'},
                      {'#','.','#','A','#','#','#'},
                      {'#','b','B','.','B','a','#'},
                      {'#','#','#','#','#','#','#'}};
        System.out.println(l.etsi(t)); // AAOOOOVVYYO
    }
}
