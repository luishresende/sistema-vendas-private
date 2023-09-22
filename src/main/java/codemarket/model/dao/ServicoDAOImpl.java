package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbServico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ServicoDAOImpl implements ServicoDAO {

    EntityManager manager;

    public ServicoDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbServico servico) {
        manager.getTransaction().begin();
        manager.persist(servico);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbServico servico) {
        manager.getTransaction().begin();
        manager.merge(servico);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbServico servico) {
        manager.getTransaction().begin();
        manager.remove(servico);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbServico> listarTodos() {
        String jpql = "SELECT s FROM TbServico s";
        Query query = manager.createQuery(jpql);
        List<TbServico> servicoList = query.getResultList();
        return servicoList;
    }

    @Override
    public TbServico listarUm(int id) {
        String jpql = "SELECT s FROM TbServico s WHERE s.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbServico) obj;
    }
}
