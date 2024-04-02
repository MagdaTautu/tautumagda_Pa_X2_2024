package com.company.documents;

import com.company.documents.exceptions.ExceptionsRepository;
import com.company.documents.models.Document;
import com.company.documents.models.Person;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Clasa pentru repository-ul de documente al companiei.
 */
public class DocumentRepository {
    private final File masterDirectory;

    /**
     * Constructor pentru DocumentRepository.
     * @param masterDirectoryPath Calea către directorul principal al repository-ului.
     * @throws ExceptionsRepository Excepție aruncată în caz de director principal inexistent sau nevalid.
     */
    public DocumentRepository(String masterDirectoryPath) throws ExceptionsRepository {
        this.masterDirectory = new File(masterDirectoryPath);
        if (!this.masterDirectory.exists() || !this.masterDirectory.isDirectory()) {
            throw new ExceptionsRepository("Directorul principal nu există sau nu este un director valid");
        }
    }

    /**
     * Returnează o listă de angajați.
     * @return List<Person> Lista de angajați.
     */
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

    /**
     * Returnează o listă de documente pentru un anumit angajat.
     * @param employeeId ID-ul angajatului pentru care se cer documentele.
     * @return List<Document> Lista de documente pentru angajatul dat.
     */
    public List<Document> getDocumentsForEmployee(String employeeId) {
        List<Document> documents = new ArrayList<>();
        File employeeDirectory = new File(masterDirectory, employeeId);
        if (employeeDirectory.exists() && employeeDirectory.isDirectory()) {
            File[] files = employeeDirectory.listFiles();
            if (files != null) {
                for (File file : files) {
                    // Extrage numele și formatul fișierului
                    String fileName = file.getName();
                    int lastIndex = fileName.lastIndexOf('.');
                    String format = lastIndex != -1 ? fileName.substring(lastIndex + 1) : "";

                    // Adaugă documentul în listă
                    documents.add(new Document(fileName, format));
                }
            }
        }
        return documents;
    }

}
