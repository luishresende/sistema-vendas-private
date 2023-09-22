/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codemarket.model.dao;

import codemarket.model.pojo.TbFornecedor;
import java.util.List;

/**
 *
 * @author kauan
 */
public interface FornecedorDAO {
    void salvar(TbFornecedor fornecedor);
    void atualizar(TbFornecedor fornecedor);
    void excluir(TbFornecedor fornecedor);
    List<TbFornecedor> listarTodos();
    TbFornecedor listarUm(int id);    
}
