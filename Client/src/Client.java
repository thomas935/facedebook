import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;

// Client class
class Client {

    // driver code
    public static void main(String[] args)
    {
        // establish a connection by providing host and port
        // number
        try (Socket socket = new Socket("localhost", 1234)) {
            //test


            // writing to server
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            // reading from server
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));


            String line = null;
            new Login("Login",out);
            while (!"exit".equalsIgnoreCase(line)) {

                // reading from user
                line = in.readLine();
                String[] words = line.split(" ");
                if (Objects.equals(words[0], "connexion")){
                    System.out.println("Connection established");
                    new messagerieFacedeBook(out);
                }
                else if (Objects.equals(words[0], "message")){

                }
                else{
                    JOptionPane.showMessageDialog(null, "Identifiants invalides.");
                }

            }


        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
