import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Thread clientThread = new Thread(() ->{

            try {
                Client client  = new Client("localhost", 1234);
                client.connect();
                client.sendMessage("hello");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        clientThread.start();


    }
}
