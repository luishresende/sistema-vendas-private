package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbProduto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ProdutoDAOImpl implements ProdutoDAO {

    EntityManager manager;

    public ProdutoDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbProduto produto) {
        manager.getTransaction().begin();
        manager.persist(produto);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbProduto produto) {
        manager.getTransaction().begin();
        manager.merge(produto);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbProduto produto) {
        manager.getTransaction().begin();
        manager.remove(produto);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbProduto> listarTodos() {
        String jpql = "SELECT p FROM TbProduto p";
        Query query = manager.createQuery(jpql);
        List<TbProduto> produtoList = query.getResultList();
        return produtoList;
    }

    @Override
    public TbProduto listarUm(int id) {
        String jpql = "SELECT p FROM TbProduto p WHERE p.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbProduto) obj;
    }
}
