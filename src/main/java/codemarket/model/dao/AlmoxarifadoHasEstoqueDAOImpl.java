package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbAlmoxarifadoHasEstoque;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AlmoxarifadoHasEstoqueDAOImpl implements AlmoxarifadoHasEstoqueDAO {

    EntityManager manager;

    public AlmoxarifadoHasEstoqueDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbAlmoxarifadoHasEstoque almoxarifadohasestoque) {
        manager.getTransaction().begin();
        manager.persist(almoxarifadohasestoque);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbAlmoxarifadoHasEstoque almoxarifadohasestoque) {
        manager.getTransaction().begin();
        manager.merge(almoxarifadohasestoque);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbAlmoxarifadoHasEstoque almoxarifadohasestoque) {
        manager.getTransaction().begin();
        manager.remove(almoxarifadohasestoque);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbAlmoxarifadoHasEstoque> listarTodos() {
        String jpql = "SELECT ae FROM TbAlmoxarifadoHasEstoque ae";
        Query query = manager.createQuery(jpql);
        List<TbAlmoxarifadoHasEstoque> almoxarifadoHasEstoqueList = query.getResultList();
        return almoxarifadoHasEstoqueList;
    }

    @Override
    public TbAlmoxarifadoHasEstoque listarUm(int id) {
        String jpql = "SELECT ae FROM TbAlmoxarifadoHasEstoque ae WHERE ae.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbAlmoxarifadoHasEstoque) obj;
    }
}
