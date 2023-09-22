package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbTipoPagamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TipoPagamentoDAOImpl implements TipoPagamentoDAO {

    EntityManager manager;

    public TipoPagamentoDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbTipoPagamento tipopagamento) {
        manager.getTransaction().begin();
        manager.persist(tipopagamento);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbTipoPagamento tipopagamento) {
        manager.getTransaction().begin();
        manager.merge(tipopagamento);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbTipoPagamento tipopagamento) {
        manager.getTransaction().begin();
        manager.remove(tipopagamento);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbTipoPagamento> listarTodos() {
        String jpql = "SELECT t FROM TbTipoPagamento t";
        Query query = manager.createQuery(jpql);
        List<TbTipoPagamento> tipopagamentoList = query.getResultList();
        return tipopagamentoList;
    }

    @Override
    public TbTipoPagamento listarUm(int id) {
        String jpql = "SELECT t FROM TbTipoPagamento t WHERE t.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbTipoPagamento) obj;
    }
}
