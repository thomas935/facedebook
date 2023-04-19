import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    private static final String EXIT = "exit";

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            System.out.println("Client started");
            System.out.println("Enter your name: ");
            String name = console.readLine();
            out.println(name);
            String str = null;
            while (true) {
                str = console.readLine();
                out.println(str);
                if (Objects.equals(str, EXIT)) {
                    break;
                }
                str = in.readLine();
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
