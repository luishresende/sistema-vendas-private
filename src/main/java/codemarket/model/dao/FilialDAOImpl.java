package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbFilial;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FilialDAOImpl implements FilialDAO {

    EntityManager manager;

    public FilialDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbFilial filial) {
        manager.getTransaction().begin();
        manager.persist(filial);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbFilial filial) {
        manager.getTransaction().begin();
        manager.merge(filial);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbFilial filial) {
        manager.getTransaction().begin();
        manager.remove(filial);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbFilial> listarTodos() {
        String jpql = "SELECT f FROM TbFilial f";
        Query query = manager.createQuery(jpql);
        List<TbFilial> filialList = query.getResultList();
        return filialList;
    }

    @Override
    public TbFilial listarUm(int id) {
        String jpql = "SELECT f FROM TbFilial f WHERE f.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbFilial) obj;
    }
}
