import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class Client {

    public static void main(String[] args) throws Exception {
        //Määritellään osoite, johon yhdistetään "loopback" = 127.0.0.1, sekä portti, jota haluttu palvelin tarkkailee
        InetAddress osoite = InetAddress.getByName("loopback");
        int port = 6666;

        //Luodaan socketti annetulla osoitteella ja portilla
        Socket socket = new Socket(osoite, port);
        
        //out lähettää bittejä palvelimelle ja in vastaanottaa niitä
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        //Testataan palvelimen ja clienthandlerin toimintaa lähettämällä ja vastaanottamalla viestejä
        out.write("Hllo\n");
        out.flush();
        System.out.println(in.readLine());

        out.write("Hello\n");
        out.flush();
        
        if(in.readLine().equals("Ack")) {
            System.out.println("Varmistus saatu");
            out.write("quit\n");
            out.flush();
        } 

        //Testi sulkeeko Clienthandler yhteyden
        try {
            while (true) {
                out.write("Oletko vielä hereillä?\n");
                out.flush();
                Thread.sleep(1000);
            }
        } catch (SocketException e) {
            System.out.println("Yhteys on suljettu");
        }
    }
}