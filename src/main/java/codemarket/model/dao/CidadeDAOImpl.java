package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbCidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CidadeDAOImpl implements CidadeDAO {

    EntityManager manager;

    public CidadeDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbCidade cidade) {
        manager.getTransaction().begin();
        manager.persist(cidade);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbCidade cidade) {
        manager.getTransaction().begin();
        manager.merge(cidade);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbCidade cidade) {
        manager.getTransaction().begin();
        manager.remove(cidade);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbCidade> listarTodos() {
        String jpql = "SELECT c FROM TbCidade c";
        Query query = manager.createQuery(jpql);
        List<TbCidade> cidadeList = query.getResultList();
        return cidadeList;
    }

    @Override
    public TbCidade listarUm(int id) {
        String jpql = "SELECT c FROM TbCidade c WHERE c.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbCidade) obj;
    }
}
