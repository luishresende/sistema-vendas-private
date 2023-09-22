package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbUnidadeMedida;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UnidadeMedidaDAOImpl implements UnidadeMedidaDAO {

    EntityManager manager;

    public UnidadeMedidaDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbUnidadeMedida unidademedida) {
        manager.getTransaction().begin();
        manager.persist(unidademedida);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbUnidadeMedida unidademedida) {
        manager.getTransaction().begin();
        manager.merge(unidademedida);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbUnidadeMedida unidademedida) {
        manager.getTransaction().begin();
        manager.remove(unidademedida);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbUnidadeMedida> listarTodos() {
        String jpql = "SELECT u FROM TbUnidadeMedida u";
        Query query = manager.createQuery(jpql);
        List<TbUnidadeMedida> unidademedidaList = query.getResultList();
        return unidademedidaList;
    }

    @Override
    public TbUnidadeMedida listarUm(int id) {
        String jpql = "SELECT u FROM TbUnidadeMedida u WHERE u.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbUnidadeMedida) obj;
    }
}
