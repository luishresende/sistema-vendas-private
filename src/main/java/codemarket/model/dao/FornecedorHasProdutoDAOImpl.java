package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbFornecedorHasProduto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FornecedorHasProdutoDAOImpl implements FornecedorHasProdutoDAO {

    EntityManager manager;

    public FornecedorHasProdutoDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbFornecedorHasProduto fornecedorhasproduto) {
        manager.getTransaction().begin();
        manager.persist(fornecedorhasproduto);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbFornecedorHasProduto fornecedorhasproduto) {
        manager.getTransaction().begin();
        manager.merge(fornecedorhasproduto);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbFornecedorHasProduto fornecedorhasproduto) {
        manager.getTransaction().begin();
        manager.remove(fornecedorhasproduto);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbFornecedorHasProduto> listarTodos() {
        String jpql = "SELECT fhp FROM TbFornecedorHasProduto fhp";
        Query query = manager.createQuery(jpql);
        List<TbFornecedorHasProduto> fornecedorHasProdutoList = query.getResultList();
        return fornecedorHasProdutoList;
    }

    @Override
    public TbFornecedorHasProduto listarUm(int id) {
        String jpql = "SELECT fhp FROM TbFornecedorHasProduto fhp WHERE fhp.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbFornecedorHasProduto) obj;
    }
}
