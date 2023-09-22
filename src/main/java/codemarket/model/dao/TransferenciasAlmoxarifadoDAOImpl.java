package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbTransferenciasAlmoxarifado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TransferenciasAlmoxarifadoDAOImpl implements TransferenciasAlmoxarifadoDAO {

    EntityManager manager;

    public TransferenciasAlmoxarifadoDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbTransferenciasAlmoxarifado transferencias) {
        manager.getTransaction().begin();
        manager.persist(transferencias);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbTransferenciasAlmoxarifado transferencias) {
        manager.getTransaction().begin();
        manager.merge(transferencias);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbTransferenciasAlmoxarifado transferencias) {
        manager.getTransaction().begin();
        manager.remove(transferencias);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbTransferenciasAlmoxarifado> listarTodos() {
        String jpql = "SELECT t FROM TbTransferenciasAlmoxarifado t";
        Query query = manager.createQuery(jpql);
        List<TbTransferenciasAlmoxarifado> transferenciasList = query.getResultList();
        return transferenciasList;
    }

    @Override
    public TbTransferenciasAlmoxarifado listarUm(int id) {
        String jpql = "SELECT t FROM TbTransferenciasAlmoxarifado t WHERE t.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbTransferenciasAlmoxarifado) obj;
    }
}
