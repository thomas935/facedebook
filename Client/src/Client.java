import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class Client {
    private String hostname;
    private int port;
    private Socket socket;



    public Client(String hostname, int port) throws IOException {
        this.hostname = hostname;
        this.port = port;
    }

    public void connect() throws IOException {
        this.socket = new Socket(hostname,port);
        System.out.println("Connecte au serveur");
    }

    public void sendMessage(String message) throws IOException {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            if (!Objects.equals(message, "")){
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
            message = "";
        }catch (IOException e) {
            System.err.println("Erreur lors de la communication avec le serveur : " + e.getMessage());
        }
    }

    public void respondReceived() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String response = bufferedReader.readLine();
            if (!Objects.equals(response,"")){
                System.out.println(response);
            }
        }catch (IOException e) {
            System.err.println("Erreur lors de la communication avec le serveur : " + e.getMessage());
        }
    }
}
