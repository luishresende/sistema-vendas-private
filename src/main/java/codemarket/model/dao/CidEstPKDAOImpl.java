package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbCidEstPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CidEstPKDAOImpl implements CidEstPKDAO {

    EntityManager manager;

    public CidEstPKDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbCidEstPK cidestpk) {
        manager.getTransaction().begin();
        manager.persist(cidestpk);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbCidEstPK cidestpk) {
        manager.getTransaction().begin();
        manager.merge(cidestpk);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbCidEstPK cidestpk) {
        manager.getTransaction().begin();
        manager.remove(cidestpk);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbCidEstPK> listarTodos() {
        String jpql = "SELECT ce FROM TbCidEstPK ce";
        Query query = manager.createQuery(jpql);
        List<TbCidEstPK> cidEstPKList = query.getResultList();
        return cidEstPKList;
    }

    @Override
    public TbCidEstPK listarUm(int id) {
        String jpql = "SELECT ce FROM TbCidEstPK ce WHERE ce.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbCidEstPK) obj;
    }
}
