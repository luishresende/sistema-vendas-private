/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbEstoque;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface EstoqueDAO {
    void salvar(TbEstoque estoque);
    void atualizar(TbEstoque estoque);
    void excluir(TbEstoque estoque);
    List<TbEstoque> listarTodos();
    TbEstoque listarUm(int id);    
}
