package com.company.documents;

import com.company.documents.exceptions.ExceptionsRepository;
import com.company.documents.models.Document;
import com.company.documents.models.Person;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DocumentRepository {
    private final File masterDirectory;

    public DocumentRepository(String masterDirectoryPath) throws ExceptionsRepository {
        this.masterDirectory = new File(masterDirectoryPath);
        if (!this.masterDirectory.exists() || !this.masterDirectory.isDirectory()) {
            throw new ExceptionsRepository("Master directory does not exist or is not a directory");
        }
    }

    public List<Person> listEmployees() {
        List<Person> employees = new ArrayList<>();
        File[] employeeDirectories = masterDirectory.listFiles(File::isDirectory);
        if (employeeDirectories != null) {
            for (File employeeDirectory : employeeDirectories) {
                employees.add(new Person(employeeDirectory.getName(), ""));
            }
        }
        return employees;
    }

    // Other methods for managing documents can be added here
}
