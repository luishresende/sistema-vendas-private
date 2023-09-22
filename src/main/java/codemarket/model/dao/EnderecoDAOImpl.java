package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbEndereco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EnderecoDAOImpl implements EnderecoDAO {

    EntityManager manager;

    public EnderecoDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbEndereco endereco) {
        manager.getTransaction().begin();
        manager.persist(endereco);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbEndereco endereco) {
        manager.getTransaction().begin();
        manager.merge(endereco);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbEndereco endereco) {
        manager.getTransaction().begin();
        manager.remove(endereco);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbEndereco> listarTodos() {
        String jpql = "SELECT e FROM TbEndereco e";
        Query query = manager.createQuery(jpql);
        List<TbEndereco> enderecoList = query.getResultList();
        return enderecoList;
    }

    @Override
    public TbEndereco listarUm(int id) {
        String jpql = "SELECT e FROM TbEndereco e WHERE e.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbEndereco) obj;
    }
}
