package com.company.documents;

import com.company.documents.DocumentRepository;
import com.company.documents.models.Person;

import java.util.List;
import com.company.documents.exceptions.ExceptionsRepository;
import com.company.documents.models.Document;
public class Main {
    public static void main(String[] args) {
        try {

            DocumentRepository repository = new DocumentRepository("D:/Facultate 6/JAVA/Laborator5/directories");

            List<Person> employees = repository.listEmployees();

            System.out.println("Employees in the repository:");
            for (Person employee : employees) {
                System.out.println(employee.name());
            }
        } catch (ExceptionsRepository e) {
            System.err.println("Error initializing document repository: " + e.getMessage());
        }
    }
}