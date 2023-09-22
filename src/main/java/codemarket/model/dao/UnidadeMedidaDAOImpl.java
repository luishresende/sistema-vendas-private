package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbUnidadeMedida;
import java.util.List;
import javax.persistence.EntityManager;

public class UnidadeMedidaDAOImpl implements UnidadeMedidaDAO {

    EntityManager manager;
    
    public UnidadeMedidaDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }
    
    @Override
    public void salvar(TbUnidadeMedida unidademedida) {
        manager.getTransaction().begin();
        manager.persist(unidademedida);
        manager.getTransaction().commit();
    }

    @Override
    public void atualizar(TbUnidadeMedida unidademedida) {
        manager.getTransaction().begin();
        manager.persist(unidademedida);
        manager.getTransaction().commit();
    }

    @Override
    public void excluir(TbUnidadeMedida unidademedida) {
        manager.getTransaction().begin();
        manager.remove(unidademedida);
        manager.getTransaction().commit();
    }

    @Override
    public List<TbUnidadeMedida> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TbUnidadeMedida listarUm(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
