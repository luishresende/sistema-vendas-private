package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbEstado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EstadoDAOImpl implements EstadoDAO{
    EntityManager manager;
        
    public EstadoDAOImpl(){
        manager = ConexaoHibernate.getInstance();
    }
    
    public void salvar(TbEstado estado){
        manager.getTransaction().begin();
        manager.persist(estado);
        manager.getTransaction().commit();
    }
    
    @Override
    public List<String> listar(){
        String sql = "SELECT est.estDescricao FROM TbEstado est";
        Query query = (Query) manager.createQuery(sql);
        List<String> estados =  query.getResultList();
        
        return estados;
    }
}
