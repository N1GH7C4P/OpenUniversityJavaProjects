

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;

public class HelloServer {

    public static void main(String[] args) throws Exception {
        
        ServerSocket server = new ServerSocket(8080);
        boolean kaynnissa = true;
        System.out.println("Luetaan tiedosto.");
        File sivu = new File("index.html");        
        Scanner tiedostonLukija = new Scanner(sivu);
        String s = "";
        while(tiedostonLukija.hasNextLine()) {
            s += tiedostonLukija.nextLine();
        }
        System.out.println(s);
        
        while(kaynnissa) {
            System.out.println("Kuunnellaan porttia 8080.");
            
            Socket socket = server.accept();
            Scanner lukija = new Scanner(socket.getInputStream());
            PrintWriter kirjoittaja = new PrintWriter(socket.getOutputStream());     
            String rivi = lukija.nextLine();
            while(lukija.hasNextLine()) {    
                if(rivi.equals("/quit")) {
                    System.out.println("lopetetaan!");
                    kaynnissa = false;
                    lukija.close();
                    kirjoittaja.close();
                    socket.close();
                    break;
                }
            }
            System.out.println("200");
            kirjoittaja.print(s);
        }
    }
}
