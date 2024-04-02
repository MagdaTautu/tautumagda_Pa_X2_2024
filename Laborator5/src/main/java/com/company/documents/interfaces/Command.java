package com.company.documents.interfaces;

import com.company.documents.exceptions.ExceptionsRepository;

/**
 * Interfață pentru comenzi executabile.
 */
public interface Command {

    /**
     * Execută comanda.
     * @throws ExceptionsRepository Excepție aruncată în caz de eroare la executarea comenzii.
     */
    void execute() throws ExceptionsRepository;
}
