package org.example;
import java.sql.*;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemo";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection = null;
    private static Statement statement;
    private static ResultSet resultSet;
    public Database() {}
    public static Connection getConnection() {
        return connection;
    }
    public void createConnection() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(URL,USER, PASSWORD);
            System.out.println(connection.getCatalog());
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
//    public static void closeConnection() { TODO }
}
