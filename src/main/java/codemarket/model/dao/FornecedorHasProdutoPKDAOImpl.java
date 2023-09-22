package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbFornecedorHasProdutoPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FornecedorHasProdutoPKDAOImpl implements FornecedorHasProdutoPKDAO {

    EntityManager manager;

    public FornecedorHasProdutoPKDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbFornecedorHasProdutoPK fornecedorhasprodutopk) {
        manager.getTransaction().begin();
        manager.persist(fornecedorhasprodutopk);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbFornecedorHasProdutoPK fornecedorhasprodutopk) {
        manager.getTransaction().begin();
        manager.merge(fornecedorhasprodutopk);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbFornecedorHasProdutoPK fornecedorhasprodutopk) {
        manager.getTransaction().begin();
        manager.remove(fornecedorhasprodutopk);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbFornecedorHasProdutoPK> listarTodos() {
        String jpql = "SELECT fhp FROM TbFornecedorHasProdutoPK fhp";
        Query query = manager.createQuery(jpql);
        List<TbFornecedorHasProdutoPK> fornecedorHasProdutoPKList = query.getResultList();
        return fornecedorHasProdutoPKList;
    }

    @Override
    public TbFornecedorHasProdutoPK listarUm(int id) {
        String jpql = "SELECT fhp FROM TbFornecedorHasProdutoPK fhp WHERE fhp.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbFornecedorHasProdutoPK) obj;
    }
}
