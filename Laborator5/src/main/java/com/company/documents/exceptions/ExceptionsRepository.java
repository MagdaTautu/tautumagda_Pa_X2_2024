package com.company.documents.exceptions;

/**
 * Excepție specifică pentru erorile legate de gestionarea repository-ului de documente.
 */
public class ExceptionsRepository extends Exception {

    /**
     * Constructor pentru ExceptionsRepository.
     * @param message Mesajul de eroare asociat excepției.
     */
    public ExceptionsRepository(String message) {
        super(message);
    }
}
