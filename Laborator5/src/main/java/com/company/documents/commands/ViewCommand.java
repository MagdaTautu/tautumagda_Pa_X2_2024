package com.company.documents.commands;

import com.company.documents.exceptions.ExceptionsRepository;
import com.company.documents.interfaces.Command;
import com.company.documents.models.Document;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Comandă pentru vizualizarea unui document.
 */
public class ViewCommand implements Command {
    private final Document document;

    /**
     * Constructor pentru ViewCommand.
     * @param document Documentul de vizualizat.
     */
    public ViewCommand(Document document) {
        this.document = document;
    }

    /**
     * Executează comanda de vizualizare a documentului.
     * @throws ExceptionsRepository Excepție aruncată în caz de eroare la vizualizare.
     */
    @Override
    public void execute() throws ExceptionsRepository {
        try {
            // Creează un obiect File pentru document
            File file = new File(document.fileName());

            // Verifică dacă fișierul există
            if (!file.exists()) {
                throw new ExceptionsRepository("Fișierul documentului nu există.");
            }

            // Deschide documentul folosind aplicația nativă a sistemului de operare
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            // Aruncă excepție în caz de eroare la deschiderea documentului
            throw new ExceptionsRepository("Eroare la deschiderea documentului: " + e.getMessage());
        }
    }
}
