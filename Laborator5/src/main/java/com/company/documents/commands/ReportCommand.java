package com.company.documents.commands;

import com.company.documents.DocumentRepository;
import com.company.documents.exceptions.ExceptionsRepository;
import com.company.documents.interfaces.Command;
import com.company.documents.models.Person;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Comandă pentru generarea și afișarea unui raport HTML al repository-ului de documente.
 */
public class ReportCommand implements Command {
    private final DocumentRepository repository;

    /**
     * Constructor pentru ReportCommand.
     * @param repository Repository-ul de documente.
     */
    public ReportCommand(DocumentRepository repository) {
        this.repository = repository;
    }

    /**
     * Executează comanda de generare și afișare a raportului HTML.
     * @throws ExceptionsRepository Excepție aruncată în caz de eroare la generare sau afișare a raportului.
     */
    @Override
    public void execute() throws ExceptionsRepository {
        try {
            // Obține lista de angajați din repository
            List<Person> employees = repository.listEmployees();

            // Inițializează configurarea FreeMarker
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
            cfg.setDirectoryForTemplateLoading(new File("D:\\Facultate 6\\JAVA\\Laborator5\\templates"));

            // Obține șablonul pentru raport
            Template template = cfg.getTemplate("report_template.ftl");

            // Construiește modelul de date pentru șablon
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("employees", employees);

            // Specifică fișierul de ieșire pentru raport
            File outputFile = new File("document_repository_report.html");
            FileWriter writer = new FileWriter(outputFile);

            // Procesează șablonul și scrie rezultatul în fișier
            template.process(dataModel, writer);
            writer.close();

            // Deschide raportul generat în browserul implicit
            Desktop.getDesktop().open(outputFile);
        } catch (IOException | TemplateException e) {
            // Aruncă excepție în caz de eroare la generare sau afișare a raportului
            throw new ExceptionsRepository("Eroare la generarea raportului HTML: " + e.getMessage());
        }
    }
}
