package codemarket.model.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.HibernateException;

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
                        persistenceManipulation.updateProperties();
                        factory = Persistence.createEntityManagerFactory("Hibernate", persistenceManipulation.getProperties());
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
