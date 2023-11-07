/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codemarket.model.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.parsers.ParserConfigurationException;
import org.hibernate.HibernateException;

/**
 *
 * @author Luis Resende
 */
public class HibernateConnection {

    private static EntityManagerFactory factory;
    private static EntityManager manager;
    PersistenceManipulation persistenceManipulation;

    public static EntityManager getInstance() {
        PersistenceManipulation persistenceManipulation = PersistenceManipulation.getInstance();
        
        if (manager == null) {
            synchronized (HibernateConnection.class) {
                if (manager == null) {
                    try {
                        persistenceManipulation.decryptSensitiveData();
                        factory = Persistence.createEntityManagerFactory("Hibernate");
                        manager = factory.createEntityManager();
                        
                    } catch (HibernateException he) {
                        System.out.println("Erro: " + he.getMessage());
                    } finally {
                        persistenceManipulation.encryptSensitiveData();
                    }
                }
            }
        }

        return manager;
    }

    public static void close() {
        manager.close();
        factory.close();
    }
}
