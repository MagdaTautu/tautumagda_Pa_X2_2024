package org.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryManager {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");

    private EntityManagerFactoryManager() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public static void closeEntityManagerFactory() {
        emf.close();
    }
}
