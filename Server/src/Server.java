import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
    private ArrayList<Socket> clientSockets = new ArrayList<>();
    private ServerSocket serverSocket;
    private Socket Client;

    public Server() {
        try {
            serverSocket = new ServerSocket(1234);
        } catch (IOException e) {
            System.out.println("Erreur lors de la creation du serveur");
        }
    }

    public void acceptClient() throws IOException {
        Client = serverSocket.accept();
        System.out.println("connexion established");
        clientSockets.add(Client);
    }

    public void receivedMessage() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Client.getInputStream()));
        String line = bufferedReader.readLine();
        System.out.println(line);
    }

    public void SendMessage(String message) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(Client.getOutputStream()));
        bufferedWriter.write(message);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
}
