package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbEstado;
import javax.persistence.EntityManager;

public class CidadeDAOImpl implements CidadeDAO{
    EntityManager manager;
    
    public CidadeDAOImpl() {
        manager = ConexaoHibernate.getInstance();
    }
    
    public void listar(TbEstado Estado){
        String jpql = "SELECT cid.cidDescricao FROM TbCidade cid WHERE ";
    }
}
