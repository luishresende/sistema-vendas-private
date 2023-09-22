package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbEntidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EntidadeDAOImpl implements EntidadeDAO {

    EntityManager manager;

    public EntidadeDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbEntidade entidade) {
        manager.getTransaction().begin();
        manager.persist(entidade);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbEntidade entidade) {
        manager.getTransaction().begin();
        manager.merge(entidade);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbEntidade entidade) {
        manager.getTransaction().begin();
        manager.remove(entidade);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbEntidade> listarTodos() {
        String jpql = "SELECT e FROM TbEntidade e";
        Query query = manager.createQuery(jpql);
        List<TbEntidade> entidadeList = query.getResultList();
        return entidadeList;
    }

    @Override
    public TbEntidade listarUm(int id) {
        String jpql = "SELECT e FROM TbEntidade e WHERE e.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbEntidade) obj;
    }
}
