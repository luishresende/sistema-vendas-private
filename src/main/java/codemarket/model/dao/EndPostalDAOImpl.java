package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbEndPostal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EndPostalDAOImpl implements EndPostalDAO {

    EntityManager manager;

    public EndPostalDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbEndPostal endpostal) {
        manager.getTransaction().begin();
        manager.persist(endpostal);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbEndPostal endpostal) {
        manager.getTransaction().begin();
        manager.merge(endpostal);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbEndPostal endpostal) {
        manager.getTransaction().begin();
        manager.remove(endpostal);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbEndPostal> listarTodos() {
        String jpql = "SELECT e FROM TbEndPostal e";
        Query query = manager.createQuery(jpql);
        List<TbEndPostal> endpostalList = query.getResultList();
        return endpostalList;
    }

    @Override
    public TbEndPostal listarUm(int id) {
        String jpql = "SELECT e FROM TbEndPostal e WHERE e.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbEndPostal) obj;
    }
}
