package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbFornecedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FornecedorDAOImpl implements FornecedorDAO {

    EntityManager manager;

    public FornecedorDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbFornecedor fornecedor) {
        manager.getTransaction().begin();
        manager.persist(fornecedor);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbFornecedor fornecedor) {
        manager.getTransaction().begin();
        manager.merge(fornecedor);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbFornecedor fornecedor) {
        manager.getTransaction().begin();
        manager.remove(fornecedor);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbFornecedor> listarTodos() {
        String jpql = "SELECT f FROM TbFornecedor f";
        Query query = manager.createQuery(jpql);
        List<TbFornecedor> fornecedorList = query.getResultList();
        return fornecedorList;
    }

    @Override
    public TbFornecedor listarUm(int id) {
        String jpql = "SELECT f FROM TbFornecedor f WHERE f.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbFornecedor) obj;
    }
}
