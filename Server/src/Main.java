import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Thread serverThread = new Thread(() -> {
            Server server = new Server();
            while(true){
                try {
                    server.acceptClient();
                    server.receivedMessage();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

        });
    serverThread.start();
    }
}
