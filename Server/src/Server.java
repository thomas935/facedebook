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
            "CREATE TABLE IF NOT EXISTS User (ID INT PRIMARY KEY, USERNAME VARCHAR(255) NOT NULL,FIRSTNAME VARCHAR(255) NOT NULL,LASTNAME VARCHAR(255) NOT NULL, EMAIL VARCHAR(255) NOT NULL,PASSWORD VARCHAR(255) NOT NULL,PERMISSION VARCHAR(255) NOT NULL, LAST_CONNECTION_TIME DATETIME, STATUT INT DEFAULT 0)",
            "CREATE TABLE IF NOT EXISTS MESSAGE (ID INT AUTO_INCREMENT PRIMARY KEY, USER_ID INT NOT NULL, TIMESTAMP DATETIME NOT NULL, CONTENT VARCHAR(255) NOT NULL, FOREIGN KEY (USER_ID) REFERENCES USER(ID))",
            "CREATE TABLE IF NOT EXISTS LOG (ID INT AUTO_INCREMENT PRIMARY KEY, USER_ID INT NOT NULL, TIMESTAMP DATETIME NOT NULL, TYPE VARCHAR(50) NOT NULL, FOREIGN KEY (USER_ID) REFERENCES USER(ID))",
            "INSERT INTO `User`(`ID`, `USERNAME`, `FIRSTNAME`, `LASTNAME`, `EMAIL`, `PASSWORD`, `PERMISSION`, `LAST_CONNECTION_TIME`) SELECT '1', 'user1', 'Marie', 'Dubois', 'marie.dubois@example.com', 'mdp1', 'user', '2023-04-21 12:00:00' UNION SELECT '2', 'user2', 'Alexandre', 'Lefebvre', 'alexandre.lefebvre@example.com', 'mdp2', 'user', '2023-04-21 12:00:00' UNION SELECT '3', 'user3', 'Aurélie', 'Martin', 'aurelie.martin@example.com', 'mdp3', 'Modo', '2023-04-21 12:00:00' UNION SELECT '4', 'user4', 'Maxime', 'Lecomte', 'maxime.lecomte@example.com', 'mdp4', 'user', '2023-04-21 12:00:00' UNION SELECT '5', 'user5', 'Emilie', 'Girard', 'emilie.girard@example.com', 'mdp5', 'user', '2023-04-21 12:00:00' UNION SELECT '6', 'user6', 'Nicolas', 'Dupont', 'nicolas.dupont@example.com', 'mdp6', 'user', '2023-04-21 12:00:00' UNION SELECT '7', 'user7', 'Laura', 'Perrin', 'laura.perrin@example.com', 'mdp7', 'user', '2023-04-21 12:00:00' UNION SELECT '8', 'user8', 'Hugo', 'Rousseau', 'hugo.rousseau@example.com', 'mdp8', 'user', '2023-04-21 12:00:00' UNION SELECT '9', 'user9', 'Camille', 'Fournier', 'camille.fournier@example.com', 'mdp9', 'user', '2023-04-21 12:00:00' UNION SELECT '10', 'user10', 'Lucas', 'Moreau', 'lucas.moreau@example.com', 'mdp10', 'Admin', '2023-04-21 12:00:00' UNION SELECT '11', 'user11', 'Clara', 'Brun', 'clara.brun@example.com', 'mdp11', 'user', '2023-04-21 12:00:00' UNION SELECT '12', 'user12', 'Louis', 'Gauthier', 'louis.gauthier@example.com', 'mdp12', 'Modo', '2023-04-21 12:00:00' UNION SELECT '13', 'user13', 'Chloé', 'Blanchard', 'chloe.blanchard@example.com', 'mdp13', 'user', '2023-04-21 12:00:00' UNION SELECT '14', 'user14', 'Théo', 'Roussel', 'theo.roussel@example.com', 'mdp14', 'user', '2023-04-21 12:00:00'"
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
                        if (Database.identification("SELECT*FROM `User` WHERE USERNAME ='" +username+"' AND PASSWORD = '"+password+"'")&&Database.Banned("SELECT PERMISSION FROM `User` WHERE USERNAME ='" +username+"' AND PASSWORD = '"+password+"'")) {
                            Database.LogConnexion(username,password);
                            StringBuilder connected = Database.whoConnected("SELECT STATUT FROM `User`");
                            String Permission = Database.query("SELECT PERMISSION FROM `User` WHERE USERNAME ='" +username+"' AND PASSWORD = '"+password+"'");

                            out.println("connexion "+username+" "+password+" "+connected+" "+Permission);
                        }else {
                            out.println("wrong identifiants");
                        }
                    }
                    else if (words[0].equals("message")){
                        if (Database.Banned("SELECT PERMISSION FROM `User` WHERE USERNAME ='" +words[1]+"' AND PASSWORD = '"+words[2]+"'")){
                        StringBuilder message = new StringBuilder();
                        for (int i = 3; i < words.length; i++) {
                            message.append(words[i]+" ");
                        }
                        String[] informationMessage;
                        informationMessage = Database.LogMessage(message,words[1],words[2]);
                        out.println("message " +informationMessage[0]+" "+informationMessage[1]+" "+message);}
                    }
                    else if (words[0].equals("getdata")){
                        String[][] result = Database.recoltData("SELECT * FROM `log`");
                        out.println("getdata "+ Arrays.deepToString(result));
                        //System.out.println("database "+ Arrays.deepToString(result));
                    }
                    else if (words[0].equals("deconnexion")) {
                        Database.LogDeconnexion(words[1],words[2]);
                        StringBuilder connected = Database.whoConnected("SELECT STATUT FROM `User`");

                        out.println("deconnexion "+connected);

                    } else if (words[0].equals("option")) {

                        String Permission = Database.query("SELECT PERMISSION FROM user WHERE USERNAME ='"+words[1]+"' AND PASSWORD = '"+words[2]+"'");

                        out.println("option "+words[1]+" "+words[2]+" "+ Permission);
                    } else if (words[0].equals("bannir")) {
                        if (!Objects.equals(Database.query("SELECT PERMISSION FROM user WHERE ID = '"+words[1]+"'"), Database.query("SELECT PERMISSION FROM user WHERE USERNAME ='"+words[2]+"' AND PASSWORD = '"+words[3]+"'")) && !Objects.equals(Database.query("SELECT PERMISSION FROM user WHERE ID = '"+words[1]+"'"), "Admin")){
                            Database.LogBannir(Integer.parseInt(words[1]));
                            Database.queryUpdate("UPDATE user SET PERMISSION = 'banni' WHERE ID = '"+words[1]+"'");
                            StringBuilder connected = Database.whoConnected("SELECT STATUT FROM `User`");
                            out.println("bannir "+connected);
                        } else{
                            out.println("bannirerreur");
                        }
                    } else if (words[0].equals("promouvoir")) {
                        if (Objects.equals(Database.query("SELECT PERMISSION FROM user WHERE ID = '"+words[1]+"'"), "user")) {
                            Database.queryUpdate("UPDATE user SET PERMISSION = 'Modo' WHERE ID = '"+words[1]+"'");
                            String Permission = Database.query("SELECT PERMISSION FROM user WHERE ID = '"+words[1]+"'");
                            String Username = Database.query("SELECT USERNAME FROM user WHERE ID = '"+words[1]+"'");
                            String Password = Database.query("SELECT PASSWORD FROM user WHERE ID = '"+words[1]+"'");
                            out.println("promouvoir "+Username+" "+Password+" "+Permission);
                        } else if (Objects.equals(Database.query("SELECT PERMISSION FROM user WHERE ID = '"+words[1]+"'"), "Modo")){
                            Database.queryUpdate("UPDATE user SET PERMISSION = 'Admin' WHERE ID = '"+words[1]+"'");
                            String Permission = Database.query("SELECT PERMISSION FROM user WHERE ID = '"+words[1]+"'");
                            String Username = Database.query("SELECT USERNAME FROM user WHERE ID = '"+words[1]+"'");
                            String Password = Database.query("SELECT PASSWORD FROM user WHERE ID = '"+words[1]+"'");
                            out.println("promouvoir "+Username+" "+Password+" "+Permission);
                        } else if (Objects.equals(Database.query("SELECT PERMISSION FROM user WHERE ID = '"+words[1]+"'"), "Admin")) {
                            out.println("promouvoirAdmin");
                        }
                    } else if (words[0].equals("exit")){
                        Database.queryUpdate("DROP TABLE user, message, log");
                        out.println("exit");
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
