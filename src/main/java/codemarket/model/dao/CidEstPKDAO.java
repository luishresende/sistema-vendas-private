/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbCidEstPK;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface CidEstPKDAO {
    void salvar(TbCidEstPK cidestpk);
    void atualizar(TbCidEstPK cidestpk);
    void excluir(TbCidEstPK cidestpk);
    List<TbCidEstPK> listarTodos();
    TbCidEstPK listarUm(int id);    
}
