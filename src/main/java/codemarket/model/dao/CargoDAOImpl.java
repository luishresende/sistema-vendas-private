package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbCargo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CargoDAOImpl implements CargoDAO{
    EntityManager manager;
        
    public CargoDAOImpl(){
        manager = ConexaoHibernate.getInstance();
    }
    
    @Override
    public void salvar(TbCargo cargo) {
        manager.getTransaction().begin();
        manager.persist(cargo);
        manager.getTransaction().commit();
    }

    @Override
    public void remover(TbCargo cargo) {
        manager.getTransaction().begin();
        manager.remove(cargo);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbCargo cargo) {
        manager.getTransaction().begin();
        manager.merge(cargo);
        manager.getTransaction().commit();
    }

    @Override
    public List<String> listarCargos() {
        String sql = "SELECT car FROM TbCargo car";
        Query query = (Query) manager.createQuery(sql);
        List<String> cargos =  query.getResultList();
        
        return cargos;
    }
    
}
