package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbFuncionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class FuncionarioDAOImpl implements FuncionarioDAO {

    EntityManager manager;

    public FuncionarioDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbFuncionario funcionario) {
        manager.getTransaction().begin();
        manager.persist(funcionario);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbFuncionario funcionario) {
        manager.getTransaction().begin();
        manager.merge(funcionario);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbFuncionario funcionario) {
        manager.getTransaction().begin();
        manager.remove(funcionario);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbFuncionario> listarTodos() {
        String jpql = "SELECT f FROM TbFuncionario f";
        Query query = manager.createQuery(jpql);
        List<TbFuncionario> funcionarioList = query.getResultList();
        return funcionarioList;
    }

    @Override
    public TbFuncionario listarUm(int id) {
        String jpql = "SELECT f FROM TbFuncionario f WHERE f.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbFuncionario) obj;
    }
}
