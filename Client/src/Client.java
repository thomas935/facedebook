
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;




// Client class
class Client {
    private static ArrayList<messagerieFacedeBook> messagerieFacedeBooks = new ArrayList<>();
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
                    messagerieFacedeBooks.add(new messagerieFacedeBook(out,words[1],words[2],words[4]));
                    for (messagerieFacedeBook messagerieFacedeBook : messagerieFacedeBooks) {
                        messagerieFacedeBook.Statut(words[3]);
                    }
                }
                else if (Objects.equals(words[0], "message")){
                    StringBuilder message = new StringBuilder();

                    for (int i = 4; i < words.length; i++) {
                        message.append(words[i]).append(" ");
                    }
                    for (messagerieFacedeBook messagerieFacedeBook : messagerieFacedeBooks) {
                        messagerieFacedeBook.displayMessage(message,words[2],words[3]);
                    }
                } else if (Objects.equals(words[0],"deconnexion")) {
                    for (messagerieFacedeBook messagerieFacedeBook : messagerieFacedeBooks) {
                        messagerieFacedeBook.Statut(words[1]);
                    }
                } else if (Objects.equals(words[0],"option")) {
                    for (messagerieFacedeBook messagerieFacedeBook : messagerieFacedeBooks) {
                        if (Objects.equals(messagerieFacedeBook.getUsername(), words[1]) && Objects.equals(messagerieFacedeBook.getPassword(), words[2])){
                            switch (words[3]){
                                case "user":
                                    messagerieFacedeBook.UserOption();
                                    break;
                                case "Modo":
                                    messagerieFacedeBook.ModoOption(out);
                                    break;
                                case "Admin":
                                    messagerieFacedeBook.AdminOption(out);
                                    break;
                            }
                        }
                    }

                } else if (Objects.equals(words[0],"bannir")) {
                    for (messagerieFacedeBook messagerieFacedeBook : messagerieFacedeBooks) {
                        messagerieFacedeBook.Statut(words[1]);
                    }
                } else if (Objects.equals(words[0], "getdata")){

                    new test_data();
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


