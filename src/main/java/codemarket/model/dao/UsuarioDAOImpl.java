package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbUsuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsuarioDAOImpl implements UsuarioDAO{
    
    EntityManager manager;
    
    public UsuarioDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }
    
    @Override
    public void salvar(TbUsuario usuario) {
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();   
    }

    @Override
    public void atualizar(TbUsuario usuario) {
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit(); 
    }

    @Override
    public void excluir(TbUsuario usuario) {
        manager.getTransaction().begin();
        manager.remove(usuario);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbUsuario> listarTodos() {
        String jpql = " SELECT u FROM TbUsuario u";
        Query query = manager.createQuery(jpql);
        List<TbUsuario> objects = query.getResultList();
        return objects;      
    }

    @Override
    public TbUsuario listarUm(String id) {
        String jpql = " SELECT u FROM TbUsuario u WHERE u.usuUsuario = " + id;
        Query query = manager.createQuery (jpql);
        Object obj = query.getSingleResult();
        return (TbUsuario) obj;
    }
    
}
