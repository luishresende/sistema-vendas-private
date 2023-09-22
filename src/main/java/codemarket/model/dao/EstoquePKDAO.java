/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbEstoquePK;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface EstoquePKDAO {
    void salvar(TbEstoquePK estoquepk);
    void atualizar(TbEstoquePK estoquepk);
    void excluir(TbEstoquePK estoquepk);
    List<TbEstoquePK> listarTodos();
    TbEstoquePK listarUm(int id);    
}
