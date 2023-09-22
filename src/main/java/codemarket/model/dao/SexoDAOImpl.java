package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbSexo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class SexoDAOImpl implements SexoDAO {

    EntityManager manager;

    public SexoDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }

    @Override
    public void salvar(TbSexo sexo) {
        manager.getTransaction().begin();
        manager.persist(sexo);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbSexo sexo) {
        manager.getTransaction().begin();
        manager.merge(sexo);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbSexo sexo) {
        manager.getTransaction().begin();
        manager.remove(sexo);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbSexo> listarTodos() {
        String jpql = "SELECT s FROM TbSexo s";
        Query query = manager.createQuery(jpql);
        List<TbSexo> sexoList = query.getResultList();
        return sexoList;
    }

    @Override
    public TbSexo listarUm(int id) {
        String jpql = "SELECT s FROM TbSexo s WHERE s.id = " + id;
        Query query = manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        return (TbSexo) obj;
    }
}
