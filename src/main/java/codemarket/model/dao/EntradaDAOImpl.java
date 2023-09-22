package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbEntrada;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EntradaDAOImpl implements EntradaDAO {

    EntityManager manager;

    public EntradaDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbEntrada entrada) {
        manager.getTransaction().begin();
        manager.persist(entrada);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbEntrada entrada) {
        manager.getTransaction().begin();
        manager.merge(entrada);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbEntrada entrada) {
        manager.getTransaction().begin();
        manager.remove(entrada);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbEntrada> listarTodos() {
        String jpql = "SELECT e FROM TbEntrada e";
        Query query = manager.createQuery(jpql);
        List<TbEntrada> entradaList = query.getResultList();
        return entradaList;
    }

    @Override
    public TbEntrada listarUm(int id) {
        String jpql = "SELECT e FROM TbEntrada e WHERE e.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbEntrada) obj;
    }
}
