package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbCidEst;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CidEstDAOImpl implements CidEstDAO {

    EntityManager manager;

    public CidEstDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbCidEst cidest) {
        manager.getTransaction().begin();
        manager.persist(cidest);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbCidEst cidest) {
        manager.getTransaction().begin();
        manager.merge(cidest);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbCidEst cidest) {
        manager.getTransaction().begin();
        manager.remove(cidest);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbCidEst> listarTodos() {
        String jpql = "SELECT c FROM TbCidEst c";
        Query query = manager.createQuery(jpql);
        List<TbCidEst> cidestList = query.getResultList();
        return cidestList;
    }

    @Override
    public TbCidEst listarUm(int id) {
        String jpql = "SELECT c FROM TbCidEst c WHERE c.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbCidEst) obj;
    }
}
