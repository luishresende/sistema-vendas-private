package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbGrupoPermissoes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GrupoPermissoesDAOImpl implements GrupoPermissoesDAO {

    EntityManager manager;

    public GrupoPermissoesDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbGrupoPermissoes grupopermissoes) {
        manager.getTransaction().begin();
        manager.persist(grupopermissoes);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbGrupoPermissoes grupopermissoes) {
        manager.getTransaction().begin();
        manager.merge(grupopermissoes);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbGrupoPermissoes grupopermissoes) {
        manager.getTransaction().begin();
        manager.remove(grupopermissoes);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbGrupoPermissoes> listarTodos() {
        String jpql = "SELECT g FROM TbGrupoPermissoes g";
        Query query = manager.createQuery(jpql);
        List<TbGrupoPermissoes> grupoPermissoesList = query.getResultList();
        return grupoPermissoesList;
    }

    @Override
    public TbGrupoPermissoes listarUm(int id) {
        String jpql = "SELECT g FROM TbGrupoPermissoes g WHERE g.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbGrupoPermissoes) obj;
    }
}
