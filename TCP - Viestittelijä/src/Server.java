import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) throws Exception {
        int Port = 6666;

        //Luodaan ServerSocket, joka alkaa tarkkailla valittua porttia
        ServerSocket serveri = new ServerSocket(Port);

        while (true) {
            //Clienthandlerit ovat säikeitä, jotka käsittelevät serveriin yhdistäviä asiakkaita samanaikaisesti
            new ClientHandler(serveri.accept()).start();
        }
    }
}