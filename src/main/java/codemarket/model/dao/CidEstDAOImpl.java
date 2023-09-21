package codemarket.model.dao;

import codemarket.model.conexao.ConexaoHibernate;
import codemarket.model.pojo.TbEstado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CidEstDAOImpl implements CidEstDAO{
    
    EntityManager manager;
        
    public CidEstDAOImpl(){
        manager = ConexaoHibernate.getInstance();
    }
    
    @Override
    public List<String> listarCidades(TbEstado estado){
        String sql = "SELECT cep.TbCidade.cidDescricao FROM TbCidEst ce WHERE cep.tbEstado.estSigla = " + estado.getEstSigla();
        Query query = (Query) manager.createQuery(sql);
        List<String> cidades =  query.getResultList();
        
        return cidades;
    }
}
