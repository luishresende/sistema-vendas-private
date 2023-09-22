package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbVenda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class VendaDAOImpl implements VendaDAO {
    EntityManager manager;
    
    public VendaDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }
    
    @Override
    public void salvar(TbVenda venda) {
        manager.getTransaction().begin();
        manager.persist(venda);
        manager.getTransaction().commit();    }

    @Override
    public void atualizar(TbVenda venda) {
        manager.getTransaction().begin();
        manager.persist(venda);
        manager.getTransaction().commit();    }

    @Override
    public void excluir(TbVenda venda) {
        manager.getTransaction().begin();
        manager.remove(venda);
        manager.getTransaction().commit();    }

    @Override
    public List<TbVenda> listarTodos() {
        String jpql = " SELECT v FROM TbVenda v";
        Query query = manager.createQuery(jpql);
        List<TbVenda> objects = query.getResultList();
        return objects;        
    }

    @Override
    public TbVenda listarUm(int id) {
        String jpql = " SELECT v FROM TbVenda v WHERE v.venId = " + id;
        Query query = manager.createQuery (jpql);
        Object obj = query.getSingleResult();
        return (TbVenda) obj;        
    }
    
}
