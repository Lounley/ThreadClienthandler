import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
    
    
    public void run() {
        try {  
            
            //in lukee vastaan tulevia bittejä ja out lähettää niitä asiakkaalle
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String rivi;

            //Vastaanotetaan viestejä ja vastataan niihin eri tavoilla riippuen viestin sisällöstä
            while (true){
                rivi = in.readLine();
                System.out.println(rivi);

                //"quit" - viestin vastaanottaessaan säie sammuttaa palvelimen ja asiakkaan välisen yhdeyden ja itsensä
                if (rivi.equals("quit")) {
                    System.out.println("Suljetaan yhteys");
                    socket.close();
                    break;

                //"Hello" - viestin vastaanottaessaan viestiin vastataan viestillä "Ack"
                } else if (rivi.equals("Hello")) {
                    out.write("Ack\n");
                    out.flush();
                } 
                
                //Mikäli viesti on mitä tahansa muuta vastataan siihen viestillä "Ei Hello"
                else {
                    out.write("Ei Hello\n"); 
                    out.flush();
                }
            }
        } catch (Exception e) {}
    }
}
