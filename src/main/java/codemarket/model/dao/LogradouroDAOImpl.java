package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbLogradouro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class LogradouroDAOImpl implements LogradouroDAO {

    EntityManager manager;

    public LogradouroDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbLogradouro logradouro) {
        manager.getTransaction().begin();
        manager.persist(logradouro);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbLogradouro logradouro) {
        manager.getTransaction().begin();
        manager.merge(logradouro);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbLogradouro logradouro) {
        manager.getTransaction().begin();
        manager.remove(logradouro);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbLogradouro> listarTodos() {
        String jpql = "SELECT l FROM TbLogradouro l";
        Query query = manager.createQuery(jpql);
        List<TbLogradouro> logradouroList = query.getResultList();
        return logradouroList;
    }

    @Override
    public TbLogradouro listarUm(int id) {
        String jpql = "SELECT l FROM TbLogradouro l WHERE l.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbLogradouro) obj;
    }
}
