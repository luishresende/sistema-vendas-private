package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbAlmoxarifado;
import codemarket.model.pojo.TbEstado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AlmoxarifadoDAOImpl implements AlmoxarifadoDAO{
    EntityManager manager;
        
    public AlmoxarifadoDAOImpl(){
        manager = ConexaoHibernate.getInstance();
    }
    
    @Override
    public void salvar(TbAlmoxarifado almoxarifado){
        manager.getTransaction().begin();
        manager.persist(almoxarifado);
        manager.getTransaction().commit();
    }
    
    @Override
    public void excluir(TbAlmoxarifado almoxarifado){
        manager.getTransaction().begin();
        manager.remove(almoxarifado);
        manager.getTransaction().commit();
    }
    
    @Override
    public void atualizar(TbAlmoxarifado almoxarifado){
        manager.getTransaction().begin();
        manager.merge(almoxarifado);
        manager.getTransaction().commit();
    }
    
    @Override
    public List<String> listarAlmoxarifados(){
        String sql = "SELECT al FROM TbAlmoxarifado al";
        Query query = (Query) manager.createQuery(sql);
        List<String> almoxarifados =  query.getResultList();
        
        return almoxarifados;
    }
}
