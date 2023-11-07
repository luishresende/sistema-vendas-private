package codemarket.model.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.commons.validator.routines.InetAddressValidator;

public class ConnectionValidator {

    private EntityManagerFactory factory;
    private EntityManager manager;

    public boolean testConnection(String address, String user, String password, String databaseName) {
        if (!(isValidAddress(address) && isValidUser(user) && isValidPassword(password) && isValidDatabaseName(databaseName))) {
            return false;
        }

        try {
            javax.persistence.spi.PersistenceProviderResolverHolder.setPersistenceProviderResolver(null);
            this.factory = Persistence.createEntityManagerFactory("Hibernate");
            this.manager = factory.createEntityManager();
            
            if(manager.isOpen()){
                manager.close();
                factory.close();
                return true;
            }
        } catch (Exception e) {
            // Lidar com qualquer exceção que possa ocorrer
            e.printStackTrace();
        }
        
        return false; // Se as informações não são válidas ou ocorreram exceções, retorne falso
    }

    private boolean isValidAddress(String address) {
        InetAddressValidator validator = InetAddressValidator.getInstance();
        int twoPointsIndex = address.indexOf(":");
        int barIndex = address.indexOf("/");
        // Verificando se existe ":" no endereço, e se não existe barras
        if (twoPointsIndex == -1 || barIndex != -1) {
            return false;
        } else {
            try {
                // Verificando se a string porta pode ser convertida para um número
                int port = Integer.parseInt(address.substring(twoPointsIndex + 1));
                String ip = address.substring(0, twoPointsIndex);
                // Verificando se o IP e a porta é valida
                if ((ip.equals("localhost") || validator.isValid(ip)) && port >= 0) {
                    return true;
                }
            } catch (NumberFormatException e) {
                return false;
            }

        }
        return false;
    }

    private boolean isValidDatabaseName(String databaseName) {
        // Verificando se o nome informado tem tamanho maior que 0
        if (databaseName.length() > 0) {
            char firstChar = databaseName.charAt(0);
            // Verificando se começa com um digito, caso sim, retorna falso
            return !Character.isDigit(firstChar);
        }
        return false;
    }

    private boolean isValidUser(String user) {
        // Verificando se o usuario informado tem tamanho maior que 0
        if (user.length() > 0) {
            char firstChar = user.charAt(0);
            // Verificando se começa com um digito, caso sim, retorna falso
            return !Character.isDigit(firstChar);
        }
        return false; // Trate o caso de uma string vazia ou nula
    }

    private boolean isValidPassword(String password) {
        // Verificando se a senha tem tamanho maior que 0
        return password.length() > 0;
    }
}
