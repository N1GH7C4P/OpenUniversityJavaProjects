import java.util.*;

public class Main {
    public static void main(String args[]) 
	{ 
        int cost[][] = { {1, 2, 3}, 
                       {4, 8, 2}, 
                       {1, 5, 3} }; 
        Ruudukko r = new Ruudukko();
        System.out.print(r.laske(cost)); 
	}
}
