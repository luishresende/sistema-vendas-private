package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbOrdemServico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class OrdemServicoDAOImpl implements OrdemServicoDAO {

    EntityManager manager;

    public OrdemServicoDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbOrdemServico ordemservico) {
        manager.getTransaction().begin();
        manager.persist(ordemservico);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbOrdemServico ordemservico) {
        manager.getTransaction().begin();
        manager.merge(ordemservico);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbOrdemServico ordemservico) {
        manager.getTransaction().begin();
        manager.remove(ordemservico);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbOrdemServico> listarTodos() {
        String jpql = "SELECT os FROM TbOrdemServico os";
        Query query = manager.createQuery(jpql);
        List<TbOrdemServico> ordemServicoList = query.getResultList();
        return ordemServicoList;
    }

    @Override
    public TbOrdemServico listarUm(int id) {
        String jpql = "SELECT os FROM TbOrdemServico os WHERE os.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbOrdemServico) obj;
    }
}
