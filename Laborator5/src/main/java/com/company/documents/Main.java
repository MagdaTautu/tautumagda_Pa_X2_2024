package com.company.documents;

import com.company.documents.DocumentRepository;
import com.company.documents.commands.ExportCommand;
import com.company.documents.commands.ReportCommand;
import com.company.documents.commands.ViewCommand;
import com.company.documents.models.Person;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import com.company.documents.exceptions.ExceptionsRepository;
import com.company.documents.models.Document;
public class Main {
    public static void main(String[] args) {

        try {
            DocumentRepository repository = new DocumentRepository("D:/Facultate 6/JAVA/Laborator5/directories");
            Scanner scanner = new Scanner(System.in);


            while (true) {
                System.out.println("Enter command (view/report/export):");
                String command = scanner.nextLine();

                if ("view".equalsIgnoreCase(command)) {
                    List<Person> employees = repository.listEmployees();
                    System.out.println("Enter the name of the employee:");
                    String employeeName = scanner.nextLine();
                    for (Person employee : employees) {
                        if (employee.name().equalsIgnoreCase(employeeName)) {
                            File employeeDirectory = new File("D:/Facultate 6/JAVA/Laborator5/directories/" + employee.name());
                            File[] files = employeeDirectory.listFiles();
                            if (files != null && files.length > 0) {
                                System.out.println("Existing files in the employee directory:");
                                for (File file : files) {
                                    System.out.println(file.getName());
                                }
                            } else {
                                System.out.println("No files found in the employee directory.");
                            }
                        }
                    }
                } else if ("report".equalsIgnoreCase(command)) {
                    new ReportCommand(repository).execute(); //nu merge
                } else if ("export".equalsIgnoreCase(command)) {
                    new ExportCommand(repository).execute();
                } else {
                    System.out.println("Invalid command. Please try again.");
                }
            }
        } catch (ExceptionsRepository e) {
            System.err.println("Error initializing document repository: " + e.getMessage());
        }
    }
}