package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbBairro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class BairroDAOImpl implements BairroDAO {
    
    EntityManager manager;
    
    public BairroDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }
    @Override
    public void salvar(TbBairro bairro) {
        manager.getTransaction().begin();
        manager.persist(bairro);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbBairro bairro) {
        manager.getTransaction().begin();
        manager.persist(bairro);
        manager.getTransaction().commit();    }

    @Override
    public void excluir(TbBairro bairro) {
        manager.getTransaction().begin();
        manager.remove(bairro);
        manager.getTransaction().commit();    }

    @Override
    public List<TbBairro> listarTodos() {
        String jpql = " SELECT b FROM TbBairro b";
        Query query = manager.createQuery(jpql);
        List<TbBairro> objects = query.getResultList();
        return objects;    
    }

    @Override
    public TbBairro listarUm(int id) {
        String jpql = " SELECT b FROM TbBairro b WHERE b.baiId = " + id;
        Query query = manager.createQuery (jpql);
        Object obj = query.getSingleResult();
        return (TbBairro) obj;    
    }
    
}
