import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Database {
    private static final String host = "localhost";
    private static final String port = "3306";
    private static final String user = "root";
    private static final String password = "";
    private static String database = "Facedebook";
    private static String url = "jdbc:mysql://" + host + ":" + port + "/";
    public static Connection connection = null;






    public static void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connection successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Database connection failed");
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Database disconnection failed");
        }
    }

    public static String[][] recoltData(String request) {
        Statement statement = null;
        int index=0;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            // get number of rows
            resultSet.last();
            int rowCount = resultSet.getRow();
            resultSet.beforeFirst();

            String[][] data = new String[rowCount][columnCount];


            for (int j = 1; j <= columnCount; j++) {
                System.out.print(resultSetMetaData.getColumnName(j) + "\t");

            }
            String verification;
            System.out.println();
            while (resultSet.next()) {

                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                    verification = Arrays.toString(resultSet.getString(i).split(" "));
                    data[index][i-1] = Arrays.toString(resultSet.getString(i).split(" "));
                }
                System.out.println();
                index++;
            }
            return data;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            ;
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }return null;
    }
    public static String query(String request) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            resultSet.next();
            String data = resultSet.getString(1);
            return data;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }return null;
    }
    public static StringBuilder whoConnected(String request) {
        Statement statement = null;
        StringBuilder connected = new StringBuilder();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(request);
            while(resultSet.next()){
                connected.append(resultSet.getString(1));
            }

            return connected;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }return null;
    }

    public static Boolean identification(String request) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(request);
            if (result.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void queryUpdate(String request) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(request);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void CreateDatabase(String[] request){
        Statement statement = null;
        String[] word = request[0].split(" ");

        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            statement.execute(request[0]);
            database = word[word.length-1];
            url = url + database;
            statement.close();
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            for (int i = 1; i < request.length; i++) {
                statement.execute(request[i]);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDatabase(String request){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(request);
            if (result.next()) {
                return result.getString(1);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void LogConnexion(String username, String password){
        LocalDateTime myDateObj;
        myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        // insert the connection in the database
        int USER_ID = Integer.parseInt(Objects.requireNonNull(Database.getDatabase("SELECT ID FROM `User` WHERE USERNAME ='" +username+"' AND PASSWORD = '"+password+"'"))) ;
        Database.queryUpdate("INSERT INTO `log`(`USER_ID`, `TIMESTAMP`, `TYPE`) VALUES ('"+USER_ID+"','"+formattedDate+"' ,'connexion')");
        Database.queryUpdate("UPDATE user SET STATUT = 1 WHERE USERNAME ='" +username+"' AND PASSWORD = '"+password+"'");
    }
    public static void LogDeconnexion(String username, String password){
        LocalDateTime myDateObj;
        myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        // insert the connection in the database
        int USER_ID = Integer.parseInt(Objects.requireNonNull(Database.getDatabase("SELECT ID FROM `User` WHERE USERNAME ='" +username+"' AND PASSWORD = '"+password+"'"))) ;
        Database.queryUpdate("INSERT INTO `log`(`USER_ID`, `TIMESTAMP`, `TYPE`) VALUES ('"+USER_ID+"','"+formattedDate+"' ,'deconnexion')");
        Database.queryUpdate("UPDATE user SET STATUT = 0 WHERE USERNAME ='" +username+"' AND PASSWORD = '"+password+"'");

    }
    public static void LogBannir(int USER_ID){
        LocalDateTime myDateObj;
        myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        // insert the connection in the database
        Database.queryUpdate("INSERT INTO `log`(`USER_ID`, `TIMESTAMP`, `TYPE`) VALUES ('"+USER_ID+"','"+formattedDate+"' ,'deconnexion')");
        Database.queryUpdate("UPDATE user SET STATUT = 2 WHERE ID ='" +USER_ID+"'");

    }
    public static String[] LogMessage(StringBuilder message, String username, String password){
        String[] informationMessage = new String[2];
        LocalDateTime myDateObj;
        myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        int USER_ID = Integer.parseInt(Objects.requireNonNull(Database.getDatabase("SELECT ID FROM `User` WHERE USERNAME ='" +username+"' AND PASSWORD = '"+password+"'"))) ;
        Database.queryUpdate("INSERT INTO `log`(`USER_ID`, `TIMESTAMP`, `TYPE`) VALUES ('"+USER_ID+"','"+formattedDate+"' ,'message')");
        Database.queryUpdate("INSERT INTO `message`(`USER_ID`, `TIMESTAMP`, `CONTENT`) VALUES ('"+USER_ID+"','"+formattedDate+"','"+message+"')");

        informationMessage[0] = formattedDate;
        informationMessage[1] = query("SELECT FIRSTNAME FROM user WHERE USERNAME ='" +username+"' AND PASSWORD = '"+password+"'");
        return informationMessage;
    }



}