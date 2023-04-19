import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
    private static final int PORT = 8080;
    private static final String EXIT = "exit";
    private static final ArrayList<Socket> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started");
            while (true) {
                Socket socket = serverSocket.accept();
                clients.add(socket);
                System.out.println("Client connected");
                new Thread(new ClientHandler(socket)).start();
            }
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket socket;
        private final BufferedReader in;
        private final PrintWriter out;

        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream(), true);
        }

        @Override
        public void run() {
            String str;
            try {
                while (true) {
                    str = in.readLine();
                    System.out.println(str);
                    for (Socket client : clients) {
                        if (client != socket) {
                            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                            out.println(str);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
