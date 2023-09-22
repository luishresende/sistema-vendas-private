/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbEntidade;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface EntidadeDAO {
    void salvar(TbEntidade entidade);
    void atualizar(TbEntidade entidade);
    void excluir(TbEntidade entidade);
    List<TbEntidade> listarTodos();
    TbEntidade listarUm(int id);    
}
