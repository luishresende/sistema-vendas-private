package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbStatus;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class StatusDAOImpl implements StatusDAO {

    EntityManager manager;

    public StatusDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbStatus status) {
        manager.getTransaction().begin();
        manager.persist(status);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbStatus status) {
        manager.getTransaction().begin();
        manager.merge(status);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbStatus status) {
        manager.getTransaction().begin();
        manager.remove(status);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbStatus> listarTodos() {
        String jpql = "SELECT s FROM TbStatus s";
        Query query = manager.createQuery(jpql);
        List<TbStatus> statusList = query.getResultList();
        return statusList;
    }

    @Override
    public TbStatus listarUm(int id) {
        String jpql = "SELECT s FROM TbStatus s WHERE s.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbStatus) obj;
    }
}
