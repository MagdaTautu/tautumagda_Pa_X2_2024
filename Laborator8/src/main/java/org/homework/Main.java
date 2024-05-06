package org.homework;

import java.io.IOException;
import java.sql.SQLException;

import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String args[]) throws SQLException, IOException {
        try {
            Database mydatabase = new Database();

            ImportTool importTool = new ImportTool(mydatabase);
            importTool.importBooks("D:\\Facultate 6\\JAVA\\laborator8\\books.csv");

        } catch (SQLException e) {
            System.err.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
