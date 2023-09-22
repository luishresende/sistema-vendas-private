package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbCategoriaProduto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CategoriaProdutoDAOImpl implements CategoriaProdutoDAO {

    EntityManager manager;

    public CategoriaProdutoDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbCategoriaProduto categoriaproduto) {
        manager.getTransaction().begin();
        manager.persist(categoriaproduto);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbCategoriaProduto categoriaproduto) {
        manager.getTransaction().begin();
        manager.merge(categoriaproduto);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbCategoriaProduto categoriaproduto) {
        manager.getTransaction().begin();
        manager.remove(categoriaproduto);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbCategoriaProduto> listarTodos() {
        String jpql = "SELECT cp FROM TbCategoriaProduto cp";
        Query query = manager.createQuery(jpql);
        List<TbCategoriaProduto> categoriaProdutoList = query.getResultList();
        return categoriaProdutoList;
    }

    @Override
    public TbCategoriaProduto listarUm(int id) {
        String jpql = "SELECT cp FROM TbCategoriaProduto cp WHERE cp.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbCategoriaProduto) obj;
    }
}
