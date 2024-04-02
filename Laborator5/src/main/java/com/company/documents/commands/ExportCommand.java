package com.company.documents.commands;

import com.company.documents.DocumentRepository;
import com.company.documents.exceptions.ExceptionsRepository;
import com.company.documents.interfaces.Command;
import com.company.documents.models.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Comanda pentru exportul datelor repository-ului în format JSON.
 */
public class ExportCommand implements Command {
    private final DocumentRepository repository;

    /**
     * Constructor pentru ExportCommand.
     * @param repository Repository-ul de documente.
     */
    public ExportCommand(DocumentRepository repository) {
        this.repository = repository;
    }

    /**
     * Executează comanda de export.
     * @throws ExceptionsRepository Excepție aruncată în caz de eroare la export.
     */
    @Override
    public void execute() throws ExceptionsRepository {
        try {
            // Obține lista de angajați din repository
            List<Person> employees = repository.listEmployees();

            // Inițializează obiectul ObjectMapper pentru serializare în JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Specifică fișierul de ieșire pentru export
            File outputFile = new File("document_repository_data.json");

            // Exportă lista de angajați în fișierul JSON
            objectMapper.writeValue(outputFile, employees);

            // Afișează mesajul de confirmare a exportului
            System.out.println("Datele repository-ului au fost exportate în fișierul JSON: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            // Aruncă excepție în caz de eroare la export
            throw new ExceptionsRepository("Eroare la exportul datelor repository-ului în format JSON: " + e.getMessage());
        }
    }
}
