import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

import static java.lang.Integer.parseInt;

// Server class
class Server {
    public static void main(String[] args)
    {

        String[] request = {
            "CREATE DATABASE IF NOT EXISTS Facedebook",
            "CREATE TABLE IF NOT EXISTS User (ID INT PRIMARY KEY, USERNAME VARCHAR(255) NOT NULL,FIRSTNAME VARCHAR(255) NOT NULL,LASTNAME VARCHAR(255) NOT NULL, EMAIL VARCHAR(255) NOT NULL,PASSWORD VARCHAR(255) NOT NULL,PERMISSION VARCHAR(255) NOT NULL, LAST_CONNECTION_TIME DATETIME)",
            "CREATE TABLE IF NOT EXISTS MESSAGE (ID INT PRIMARY KEY, USER_ID INT NOT NULL, TIMESTAMP DATETIME NOT NULL, CONTENT VARCHAR(255) NOT NULL, FOREIGN KEY (USER_ID) REFERENCES USER(ID))",
            "CREATE TABLE IF NOT EXISTS LOG (ID INT PRIMARY KEY, USER_ID INT NOT NULL, TIMESTAMP DATETIME NOT NULL, TYPE VARCHAR(50) NOT NULL, FOREIGN KEY (USER_ID) REFERENCES USER(ID))",
                //"INSERT INTO `User`(`ID`, `USERNAME`, `FIRSTNAME`, `LASTNAME`, `EMAIL`, `PASSWORD`, `PERMISSION`, `LAST_CONNECTION_TIME`) SELECT '1', 'user1', 'Marie', 'Dubois', 'marie.dubois@example.com', 'mdp1', 'user', '2023-04-21 12:00:00' UNION SELECT '2', 'user2', 'Alexandre', 'Lefebvre', 'alexandre.lefebvre@example.com', 'mdp2', 'user', '2023-04-21 12:00:00' UNION SELECT '3', 'user3', 'Aurélie', 'Martin', 'aurelie.martin@example.com', 'mdp3', 'user', '2023-04-21 12:00:00' UNION SELECT '4', 'user4', 'Maxime', 'Lecomte', 'maxime.lecomte@example.com', 'mdp4', 'user', '2023-04-21 12:00:00' UNION SELECT '5', 'user5', 'Emilie', 'Girard', 'emilie.girard@example.com', 'mdp5', 'user', '2023-04-21 12:00:00' UNION SELECT '6', 'user6', 'Nicolas', 'Dupont', 'nicolas.dupont@example.com', 'mdp6', 'user', '2023-04-21 12:00:00' UNION SELECT '7', 'user7', 'Laura', 'Perrin', 'laura.perrin@example.com', 'mdp7', 'user', '2023-04-21 12:00:00' UNION SELECT '8', 'user8', 'Hugo', 'Rousseau', 'hugo.rousseau@example.com', 'mdp8', 'user', '2023-04-21 12:00:00' UNION SELECT '9', 'user9', 'Camille', 'Fournier', 'camille.fournier@example.com', 'mdp9', 'user', '2023-04-21 12:00:00' UNION SELECT '10', 'user10', 'Lucas', 'Moreau', 'lucas.moreau@example.com', 'mdp10', 'user', '2023-04-21 12:00:00' UNION SELECT '11', 'user11', 'Clara', 'Brun', 'clara.brun@example.com', 'mdp11', 'user', '2023-04-21 12:00:00' UNION SELECT '12', 'user12', 'Louis', 'Gauthier', 'louis.gauthier@example.com', 'mdp12', 'user', '2023-04-21 12:00:00' UNION SELECT '13', 'user13', 'Chloé', 'Blanchard', 'chloe.blanchard@example.com', 'mdp13', 'user', '2023-04-21 12:00:00' UNION SELECT '14', 'user14', 'Théo', 'Roussel', 'theo.roussel@example.com', 'mdp14', 'user', '2023-04-21 12:00:00'"
        };
        Database.CreateDatabase(request);

        ServerSocket server = null;
        Database.connect();

        try {
            // server is listening on port 1234
            server = new ServerSocket(1234);
            server.setReuseAddress(true);
            // running infinite loop for getting
            // client request
            while (true) {

                // socket object to receive incoming client
                // requests

                Socket client = server.accept();

                // Displaying that new client is connected
                // to server
                System.out.println("New client connected"
                        + client.getInetAddress()
                        .getHostAddress());

                // create a new thread object
                ClientHandler clientSock
                        = new ClientHandler(client);

                // This thread will handle the client
                // separately
                new Thread(clientSock).start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (server != null) {
                try {
                    server.close();
                    Database.disconnect();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // ClientHandler class
    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        // Constructor
        public ClientHandler(Socket socket)
        {
            this.clientSocket = socket;
        }

        public void run()
        {


            PrintWriter out = null;
            BufferedReader in = null;
            try {

                // get the outputstream of client
                out = new PrintWriter(
                        clientSocket.getOutputStream(), true);

                // get the inputstream of client
                in = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));

                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Received from client: " + line);
                    //verify the first word received from client
                    String[] words = line.split(" ");
                    if (words[0].equals("connexion")) {
                        String username = words[1];
                        String password = words[2];
                        if (Database.identification("SELECT*FROM `User` WHERE USERNAME ='" +username+"' AND PASSWORD = '"+password+"'")) {
                            out.println("connexion "+username+" "+password);
                            Database.LogConnexion(username,password);
                        }else {
                            out.println("wrong identifiants");
                        }
                    }
                    else if (words[0].equals("message")){
                        StringBuilder message = new StringBuilder();
                        for (int i = 3; i < words.length; i++) {
                            message.append(words[i]+" ");
                        }
                        String[] informationMessage;
                        informationMessage = Database.LogMessage(message,words[1],words[2]);
                        out.println("message " +informationMessage[0]+" "+informationMessage[1]+" "+message);
                    }
                    else if (words[0].equals("getdata")){
                        String[][] result = Database.recoltData("SELECT * FROM `log`");
                        //out.println("getdata "+ Arrays.deepToString(result));
                        //System.out.println("database "+ Arrays.deepToString(result));
                    }
                    else if (words[0].equals("deconnexion")) {
                        Database.LogDeconnexion(words[1],words[2]);
                    } else if (words[0].equals("exit")){
                        break;
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                    if (in != null) {
                        in.close();
                        clientSocket.close();
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
