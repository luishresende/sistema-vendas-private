package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbPais;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PaisDAOImpl implements PaisDAO {

    EntityManager manager;

    public PaisDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbPais pais) {
        manager.getTransaction().begin();
        manager.persist(pais);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbPais pais) {
        manager.getTransaction().begin();
        manager.merge(pais);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbPais pais) {
        manager.getTransaction().begin();
        manager.remove(pais);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbPais> listarTodos() {
        String jpql = "SELECT p FROM TbPais p";
        Query query = manager.createQuery(jpql);
        List<TbPais> paisList = query.getResultList();
        return paisList;
    }

    @Override
    public TbPais listarUm(int id) {
        String jpql = "SELECT p FROM TbPais p WHERE p.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbPais) obj;
    }
}
